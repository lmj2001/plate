package com.test.nkspider.url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class GetIMDBVideo {
    public static void main(String[] args) throws IOException {
        // 分析获取待下载资源的url
        String uri = "https://imdb-video.media-imdb.com/vi2986917913/1434659607842-pgv4ql-1626139634755.mp4?Expires=1626833934&Signature=ItR-LTBz0OpHSotflQoH1EU31sxgEtAUF6gaUl0Xgm-dkuRNdNa5Kj3qBxVYPYvcxwzfSn-AsSHQaCvNRHTuqb6Vc5Zno8FYM~94nKva3hBmmvTn8rp4ByqryHbUXhhiaQ7D27q03iqATEBEKP7iwmofXEwuB6QRcZCJCVT1EEhUcQJoqnu4V2GLJQaiGQSwVyt4BhhdHEJVndhRgWGjOzMBMLPZE-6qphIL1VyXsHJtHBknGAmJqjImiHcd-6AM2UM1Pd1~fw0-574YG3hGiNdNwxqLZ623N3ialywUs991NCbdxpV3r1l1jccw6OhrDvPmCTph1EP4brb8G2Drfg__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA";
        //  创建url对象，放入uri
        URL url = new URL(uri);
        //  打开远程url的http的连接的connection
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        // httpURLConnection 的apl帮助文档
        httpURLConnection.setRequestMethod("GET");//设置请求方法
        // httpURLConnection.setConnectTimeout(5);
        // 设置请求头参数
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36");

        // 获取响应
        // 获取status_code
        int statusCode = httpURLConnection.getResponseCode();
        //判断状态码
        if (statusCode == HttpURLConnection.HTTP_OK) {
            // 视频资源下载
            // 基于http connection 获取输入流
            InputStream is = httpURLConnection.getInputStream();
            // 借助java io完成视频下载
            String filename = "1.mp4";
            File file = new File(filename);
            //
            OutputStream fos = new FileOutputStream(file);
            byte[] temp = new byte[1024];
            int len = 0;
            while ((len = is.read(temp)) != -1) {
                fos.write(temp, 0, len);
            }
            // 关闭流
            fos.close();
            is.close();
        }
    }
}
