package com.test.webmagic;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import com.test.webmagic.domain.po.Movie;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
public class MovieGetdata implements PageProcessor {

    //网站的相关配置：包括编码、抓取间隔、重试次数等
    private Site site = Site.me()
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36 Edg/91.0.864.71")
            .setRetryTimes(3)
            .setSleepTime(1000);

    public Site getSite() {
        return site;
    }

    public void process(Page page) {
        List<String> movies = new ArrayList<String>();
        Movie movie = new Movie();
        //使用XPath查找所有class属性为'title'的div元素，并找到a子节点，并提取a节点的文本信息
        List<String> titles = page.getHtml().xpath("//div[@class='title']/a/text()").all(); //匹配标题
        List<String> movieUrls = page.getHtml().xpath("//div[@class='post']/a").links().all(); //匹配电影url
        List<String> ratings = page.getHtml().xpath("//div[@class='rating']/span[@class='rating_nums']/text()").all(); //匹配评分
        List<String> attrFields = page.getHtml().xpath("//div[@class='abstract']").all();
        //page.putField("titles", titles);  //本质传值到ResultItems对象里
        page.putField("titles", titles);
        page.putField("movieUrls", movieUrls);
        page.putField("ratings", ratings);
        page.putField("attrFields", attrFields);
       /*  获得下一页内容
        *  第一页：https://www.douban.com/doulist/3907668/
           第二页：https://www.douban.com/doulist/3907668/?start=25&sort=seq&playable=0&sub_type=
           第三页：https://www.douban.com/doulist/3907668/?start=50&sort=seq&playable=0&sub_type=
       */
        // 获取所有的其他列表页
        List<String> hrefs = page.getHtml().links().regex("https://www.douban.com/doulist/3907668/\\?start=\\d+&sort=seq&playable=0&sub_type=").all();
        // 将列表页加入待爬取list 中
        page.addTargetRequests(hrefs);
    }

    public static void main(String[] args) throws IOException {
        Spider.create(new MovieGetdata())
                //从"https://www.douban.com/doulist/3907668/"开始抓取
                .addUrl("https://www.douban.com/doulist/3907668/")
                //存储在数据库中
                .addPipeline(new MySqlPipeline())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}
