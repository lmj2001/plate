package com.test.nkspider.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class TestUrl {
    public static void main(String[] args) throws IOException {
        // 创建一个urlStr
        String urlStr = "http://baidu.com/";
        // 新建java的url的实例对象
        URL url = new URL(urlStr);
        // 基于url获取输入流,最底层的字节流
        InputStream is = url.openStream();
        // 对字符流进行封装,获取Bufferedreader对象
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        // 借助br完成IO打印
        String tmp = "";
        while ((tmp=br.readLine())!=null){
            System.out.println(tmp);
        }
        // 关闭流(IOSURL)
        br.close();isr.close();is.close();

    }
}
