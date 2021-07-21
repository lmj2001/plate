package com.test.nkspider.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

public class GetDoubanReview {
    public static String BASE_URL = "https://movie.douban.com/review/best/";
    public static final int PAGE_SIZE = 10;
    public static final String PAGE_START = "?start=";

    public static void main(String[] args) throws IOException {
        // 分析并获取待爬取的url字符串
        for (int i = 0; i < 10; i++) {
            String url = BASE_URL + PAGE_START + String.valueOf(i * PAGE_SIZE);
//            System.out.println(url);
            //Document document = Jsoup.connect(url).get();// 向指定的url 发送一个get请求，获取响应的soup文档,不推荐
            // 获取connect ，基于Jsoup
            Connection connection = Jsoup.connect(url);
            // 设置连接参数，封装请求（头）参数
            connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36");
            // 发送请求,获得响应（soup文档）
            Document document = connection.get();
            //
            String htmlText = document.html();
            String text = document.text();
//            System.out.println(htmlText);
//            System.out.println(text);
            // 基于soup文档完成定位和提取操作,定位
            Elements elements = document.select("div.main.review-item");
//            Elements elementsByClass = document.getElementsByClass("main review-item");
//            Elements aClass = document.getElementsByAttributeValue("class", "main review-item");
            // 开始提取
            // 推荐使用迭代器实现
            Iterator<Element> iterator = elements.iterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                // 基于元素定位
                Element main_hd = element.select("header").get(0);
                Element main_bd = element.selectFirst("div.main-bd");
                // 作者信息
                Element authorInfoElement = main_hd.getElementsByClass("name").get(0);
                // 时间信息
                Element timeInfoElement = main_hd.getElementsByAttributeValue("class", "main-meta").get(0);
                // 短评信息
                Element shortContentElement = main_bd.selectFirst("div.review-short");
                String authorName = authorInfoElement.text();
                String authorHomePage = authorInfoElement.attr("href");
                String createTime = timeInfoElement.text();
                String createDate = timeInfoElement.attr("content");
                String shortContent = shortContentElement.text();
                System.out.println("{" +
                        "authorName='" + authorName + '\'' +
                        ", authorHomePage='" + authorHomePage + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", createDate='" + createDate + '\'' +
                        ", shortContent='" + shortContent + '\'' +
                        '}');
            }
        }

    }
}
// Jsoup 支持java的链式编程
/*Jsoup.connect(url)
        .timeout(10)
        .userAgent("***")
        .data("username", "zhangsan")
        .data("passwd", "123456")
        .post();*/
