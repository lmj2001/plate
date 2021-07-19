package com.test.bookshop.dao;

import com.test.bookshop.domain.po.User;

public interface UserDao extends GenericDao<User, Integer> {
    User FindByName(String usn);
}
