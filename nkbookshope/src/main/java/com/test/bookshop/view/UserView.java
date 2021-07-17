package com.test.bookshop.view;

import com.test.bookshop.domain.po.User;
import com.test.bookshop.web.controller.UserController;

public class UserView {
    public static void register(){

    }
    public static void main(String[] args) {
        //完成控制器的实例化
        UserController userController = new UserController();
        //页面1，完成登陆功能
        //用户自己输入的
        String usn = "askkas";
        String pwd = "1232";

        //完成前端页面请求参数的封装
        User loginUser = new User();
        loginUser.setUsn(usn);
        loginUser.setPwd(pwd);

        //调用控制器层来实现登陆功能
        userController.setUser(loginUser);
        String resultView = userController.login();
        System.out.println(resultView);
    }
}
