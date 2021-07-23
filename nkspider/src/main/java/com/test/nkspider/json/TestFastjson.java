package com.test.nkspider.json;

import com.alibaba.fastjson.JSON;
import com.test.nkspider.json.domain.vo.ProductComments;
import com.test.nkspider.json.domain.vo.Student;
import com.test.nkspider.json.domain.vo.pr;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class TestFastjson {
    public static void main(String[] args) throws IOException {
        String jsonStr = "{\"name\":\"zhangsan\"," +
                " \"age\":20, " +
                "\"like\":[\"aa\", \"bb\", \"cc\"]," +
                "\"scores\":{\"chinese\":10,\"math\":20,\"english\":30}}";
        // 使用fastjson反序列化
        Student student = JSON.parseObject(jsonStr, Student.class);
        // 获取数据
        System.out.println(student.getScores().get(0).getChinese());
        System.out.println(student);

        // 使用fastjson序列化
        student.getScores().get(0).setMath(99);
        String jsonText = JSON.toJSONString(student);
        System.out.println(jsonText);

        //
        String url = "https://club.jd.com/comment/productPageComments.action?productId=100023014936&score=0&sortType=5&page=1&pageSize=10";
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36")
                .get();
        String jdJsonText = doc.text();
        System.out.println(jdJsonText);
        System.out.println("jjjjjjjjjjjjj");
        pr productComments = JSON.parseObject(jdJsonText, pr.class);
        System.out.println(productComments);

    }
}
