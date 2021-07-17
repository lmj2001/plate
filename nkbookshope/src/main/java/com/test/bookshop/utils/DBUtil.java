package com.test.bookshop.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//简化使用者的使用成本：定义成方法和属性，应该是public static
//读取dbconfig.properties 文件内容
public class DBUtil {

    //声明私有静态属性，实例化dbconfid.properties类对象,因为只要给这个类用
    private static Properties prop = new Properties();

    //声明静态代码块,借助私有方法属性prop完成dbconfig的读入
    //借助DBUtil.class.getClassLoader()保证在web项目中可以定位和读入web项目
    static {
        try {
            prop.load(DBUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //声明公有属性，保存获取的配置信息
    public static String driver =prop.getProperty("jdbc.driver");
    public static String url =prop.getProperty("jdbc.url");
    public static String user =prop.getProperty("jdbc.user");
    public static String passwd = prop.getProperty("jdbc.passwd");
}
