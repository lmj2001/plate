package com.test.bookshop.dao;

import java.io.Serializable;
import java.util.List;

/*
基于泛型的接口
    泛型：
        Entity =实体类，共性 ：implentmrnt Serializable
        ID = 主键 ，共性 ：Object
    方法：
        查询、删除、修改
 */
public interface GenericDao<Entity extends Serializable, ID extends Object> {
    Entity FindByid(ID id);

    List<Entity> FindAll();

    List<Entity> FindBySQL(String sql, Object... params);

    ID insert(Entity entity);

    int update(Entity entity);

    int delete(ID id);

    int delete(Entity entity);
}
