package com.test.bookshop.dao.jdbcimpl;

import com.test.bookshop.dao.UserDao;
import com.test.bookshop.domain.po.User;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TestUserDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.FindByid(1);
        System.out.println(user);

        Date birthday = new Date();
        Timestamp regtime = new Timestamp(System.currentTimeMillis());
        User users = new User("aiawa", "1232", 20, birthday, 791012.9, regtime);
        System.out.println(userDao.insert(users));
        List<User> list=userDao.FindAll();
        System.out.println(list);
    }
}
