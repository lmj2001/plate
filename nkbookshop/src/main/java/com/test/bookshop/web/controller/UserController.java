package com.test.bookshop.web.controller;


import com.test.bookshop.domain.po.User;
import com.test.bookshop.service.UserService;
import com.test.bookshop.service.impl.UserServeImpl;
import java.util.List;

public class UserController {
    private UserService userService = new UserServeImpl();
    private User user;

    public String login() {
        //获取界面层，视图层，前端传过来的请求参数==前端完成
        //调用下一层业务逻辑层的方法
        boolean res = userService.isValiable(user.getUsn(), user.getPwd());
        if (res)
            return "success";
        else
            return "用户名或密码错误";
    }

    public String register() {
        //获取界面层，视图层，前端传过来的请求参数==前端完成
        //调用下一层业务逻辑层的方法
        boolean res = userService.register(user);
        if (res)
            return "success";
        else
            return "注册失败";
    }

    public List<User> showAllUser() {
        return userService.FindAll();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

