package com.test.bookshop.service;

import com.test.bookshop.domain.po.User;

import java.util.List;

//业务逻辑中接口,跟业务相关的函数
public interface UserService {
    boolean register(User user);

    boolean isValiable(String usn, String pwd);

    boolean remove(User user);

    boolean modify(User user);

    List<User> FindAll();
}
