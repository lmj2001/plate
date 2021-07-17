package com.test.bookshop.service.impl;

import com.test.bookshop.dao.UserDao;
import com.test.bookshop.dao.jdbcimpl.UserDaoImpl;
import com.test.bookshop.domain.po.User;
import com.test.bookshop.service.UserService;

import java.util.List;

/*
    所有业务逻辑方法的具体实现需要借助Dao层中的方法来实现
        1. Dao要作为业务逻辑层实现类的一个属性
        2. 业务逻辑层中实现类中的方法内部要对Dao进行调用，来实现自身的功能

 */
public class UserServeImpl implements UserService {

    //UserDao作为UserServiceImpl中的一个属性，并且实例化。
    //UserServiceImpl依赖UserDao，其方法的实现要借助对UserDao中方法的调用来实现
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(User user) {
        boolean res = false;
        int result = userDao.insert(user);
        if (result == 1)
            res = true;
        return res;
    }

    @Override
    public boolean isValiable(String usn, String pwd) {
        boolean res = false;
        User user = userDao.FindByName(usn);
        if (user != null && pwd.equals(user.getPwd()))
            res = true;
        return res;
    }

    @Override
    public boolean remove(User user) {
        boolean res = false;
        int result = userDao.delete(user);
        if (result != -1 && result != 0) {
            res = true;
        }
        return res;
    }

    @Override
    public boolean modify(User user) {
        boolean res = false;
        User existUser = userDao.FindByName(user.getUsn());
        //已经存在该用户，直接返回
        if (existUser != null) {
            return false;
        }
        int result = userDao.update(user);
        if (result != -1 && result != 0) {
            res = true;
        }
        return res;
    }

    @Override
    public List<User> FindAll() {
        return userDao.FindAll();
    }
}
