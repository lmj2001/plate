package com.test.webmagic;

import java.io.IOException;

import java.util.List;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
public class DangdangBook implements PageProcessor {
    //第一部分：抓取网站的相关配置：包括编码、抓取间隔、重试次数等
    private Site site = Site.me()
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .addHeader("Connection", "keep-alive")
            .addHeader("X-Requested-With", "XMLHttpRequest")
            .addHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8")
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36 Edg/91.0.864.71")
            .setRetryTimes(3)
            .setSleepTime(1000)
            // 防止反爬， 加入登录后的 cookies
            .addCookie("dest_area", "country_id%3D9000%26province_id%3D111%26city_id%20%3D0%26district_id%3D0%26town_id%3D0")
            .addCookie("__permanent_id", "20210724101318025232455306760936329")
            .addCookie("__visit_id", "20210724101318027240595239843398944")
            .addCookie("__out_refer", "")
            .addCookie("secret_key", "838a71fa77c382e6f673e159ea15b6a1")
            .addCookie("permanent_key", "20210724103119819741752827f590fb")
            .addCookie("alipay_request_from", "https://login.dangdang.com/signin.aspx?returnurl=http%253A%252F%252Fproduct.dangdang.com%252F25246609.html")
            .addCookie("ddscreen", "2")
            .addCookie("smidV2", "2021072410362336234dff37e9e4c8d55dc637ab16dfe300545d2b7c22c4490")
            .addCookie("__dd_token_id", "2021072410371414308684374228afad")
            .addCookie("USERNUM", "dgv7fXNF7hDVC09lT4UQuQ==")
            .addCookie("login.dangdang.com", ".AYH=20210724102624072490039&.ASPXAUTH=o/cE1SeaXtSllTYBYUYBur6h5hy+zgXZgaKN+EyNYAD4j5sL1llKUA==")
            .addCookie("dangdang.com", "email=MTM2MjIxMzMxNDQ1NTgzM0BkZG1vYmlscGhvbmVfX3VzZXIuY29t&nickname=&display_id=3795190138712&customerid=5W2y1mUqQSrBywc+PWDFHA==&viptype=wzTKLqtgi1g=&show_name=136%2A%2A%2A%2A3144")
            .addCookie("ddoy", "email=1362213314455833%40ddmobilphone__user.com&nickname=&agree_date=1&validatedflag=0&uname=13622133144&utype=&.ALFG=off&.ALTM=1627094234")
            .addCookie("sessionID", "pc_528475cdedf44b060098a4a7c61b49601a19cad4a3944ca3c09491b10909492d")
            .addCookie("LOGIN_TIME", "1627094257460")
            .addCookie("__rpm", "...1627094269515%7C...1627094287003")
            .addCookie("__trace_id", "20210724103807563177597455221114486");

    public Site getSite() {
        return site;
    }
    public void process(Page page) {
        // 子页面处理•第一部分：每本图书的子页面，借助Xpath语法抽取每个图书的url
        List hrefs= (page.getHtml().xpath("//div[@class='name']/a").links().all());
        // 子页面处理•第二部分：下一页处理，将下一页的url加到页面下载队列中去。
        page.addTargetRequests(hrefs);

        System.out.println("------------------------start-------------------------");
        // 抽取所有需要信息
        String b_name = page.getHtml().xpath("//*[@id='product_info']/div[1]/h1/@title").toString(); //图书名称
        String b_author = page.getHtml().xpath("//*[@id='author']/a[1]/text()").toString();//图书作者
        String b_price = page.getHtml().xpath("//*[@id='dd-price']/text()").toString();//价格
        String b_electron_price = page.getHtml().xpath("//*[@id='e-book-price']/text()").toString(); //电子书价格
        String b_public = page.getHtml().xpath("//*[@id='product_info']/div[2]/span[2]/a/text()").toString();//出版社
        String b_time = page.getHtml().xpath("//*[@id='product_info']/div[2]/span[3]/text()").toString(); //跳转页面，爬取书籍类型
        String b_common = page.getHtml().xpath("//*[@id='comm_num_down']/text()").toString();//跳转页面，细化书籍类型
        // 将抽取的信息放入 page 对象中
        page.putField("b_name", b_name);
        page.putField("b_author", b_author);
        page.putField("b_price", b_price);
        page.putField("b_electron_price", b_electron_price);
        page.putField("b_public", b_public);
        page.putField("b_time", b_time);
        page.putField("b_common", b_common);

        System.out.println("-------------------------end-------------------------");
        //下一页处理：此处简略，只爬取前 6 个月的数据
        page.addTargetRequest("http://bang.dangdang.com/books/bestsellers/01.00.00.00.00.00-year-2020-0-1-2");
        page.addTargetRequest("http://bang.dangdang.com/books/bestsellers/01.00.00.00.00.00-year-2020-0-1-3");
        page.addTargetRequest("http://bang.dangdang.com/books/bestsellers/01.00.00.00.00.00-year-2020-0-1-4");
        page.addTargetRequest("http://bang.dangdang.com/books/bestsellers/01.00.00.00.00.00-year-2020-0-1-5");
        page.addTargetRequest("http://bang.dangdang.com/books/bestsellers/01.00.00.00.00.00-year-2020-0-1-6");
        //List pagehref=page.getHtml().links().regex("http://bang.dangdang.com/books/bestsellers/01.00.00.00.00.00-year-2020-0-1-\\d+").all();
    }


    public static void main( String[] args ) throws IOException {
        // 启动爬虫，将数据保存在 json 文件中
        Spider.create(new DangdangBook())
                //从第一页开始抓取
                .addUrl("http://bang.dangdang.com/books/bestsellers/01.00.00.00.00.00-year-2020-0-1-1")
                //存储在数据库中
                .addPipeline(new JsonFilePipeline("data/dangbook"))
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}

