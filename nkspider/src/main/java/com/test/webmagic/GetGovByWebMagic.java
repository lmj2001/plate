package com.test.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GetGovByWebMagic implements PageProcessor {
    // 部分一：给出抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        System.out.println(page.getUrl());
        // 部分二：抽取页面元素
        String title = page.getHtml().xpath("//head/title/text()").toString();
        System.out.println(title);
        if (title == null) {
            page.setSkip(true);
        }
        page.putField("allhtml", page.getHtml().toString());
        // 部分三：从页面发现后续的url地址来抓取
        // 采集该网站新闻列表页
        page.addTargetRequests(page.getHtml().links().regex("(http://sousuo.gov.cn/column/30611/\\d+.htm)").all());
        // 采集该网站每条新闻详细页
        page.addTargetRequests(
                page.getHtml().links().regex("(http://www.gov.cn/xinwen/2021-\\d+/\\d+/content_\\d+.htm)").all());
//                page.getHtml().links().regex("(http://www.gov.cn/xinwen/2021-07/\\d+/content_\\d+.htm)").all());
    }
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {
        // 创建爬虫，设置爬虫的参数，如：起始url,持久化信息,线程信息等
        Spider.create(new GetGovByWebMagic())
                // 从"http://sousuo.gov.cn/column/30611/0.htm"开始抓
                .addUrl("http://sousuo.gov.cn/column/30611/0.htm")
                // 抓取页面的存储路径
                .addPipeline(new FilePipeline("data/govnews"))
                // 开启5个线程抓取
                .thread(5)
                // 启动爬虫
                .run();
    }
}
