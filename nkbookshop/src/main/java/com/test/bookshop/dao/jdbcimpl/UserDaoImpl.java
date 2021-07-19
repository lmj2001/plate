package com.test.bookshop.dao.jdbcimpl;

import com.test.bookshop.dao.UserDao;
import com.test.bookshop.domain.po.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//借助BaseDao中的共性方法实现UserDao接口中的方法的具体实现

/**
 * 不做插入是否成功的判断，老老实实返回
 */
public class UserDaoImpl extends GenericBaseDao implements UserDao {
   /*
         1. 打开连接
         2. 生成独有的sql语句
         3. 调用对应的通用的增删改查询
         4. 处理返回结果
            · 增删改的返回结果，获取result的值返回
            · 查询的方法，获取返回的结果集，遍历结果集，将结果集中的记录封装到对应的实体类中
         5. 关闭连接
    */

    @Override
    public User FindByid(Integer id) {
        User user = null;
        try {
            this.getConnection();
            String sql = "select * from users where id = ?";
            this.executeQuery(sql, id);
            if (rs != null && rs.next()) {
                //推荐写列标题，将一行记录封装到实体类中
                user = new User(rs.getInt("id"), rs.getString("usn"),
                        rs.getString("pwd"), rs.getInt("age"),
                        rs.getDate("birthday"), rs.getDouble("salary"),
                        rs.getTimestamp("regtime"));
            }
            this.closeAll();
        } catch (SQLException throwables) {
            System.out.println("连接出错了。。。。。。");
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> FindAll() {
        List<User> users = null;
        try {
            this.getConnection();
            String sql = "select * from users ";
            this.executeQuery(sql);
            if (rs != null) {
                //推荐写列标题
                users = new ArrayList<>();
                while (rs.next()) {
                    //将一行记录封装到一个实体类对象中，并加入到list中
                    users.add(new User(rs.getInt("id"),
                            rs.getString("usn"), rs.getString("pwd"),
                            rs.getInt("age"), rs.getDate("birthday"),
                            rs.getDouble("salary"), rs.getTimestamp("regtime")));
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            System.out.println("连接出错了。。。。。。");
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> FindBySQL(String sql, Object... params) {
        List<User> users = null;
        try {
            this.getConnection();
            this.executeQuery(sql, params);
            if (rs != null) {
                //推荐写列标题
                users = new ArrayList<>();
                while (rs.next()) {
                    //将一行记录封装到一个实体类对象中，并加入到list中
                    users.add(new User(rs.getInt("id"),
                            rs.getString("usn"), rs.getString("pwd"),
                            rs.getInt("age"), rs.getDate("birthday"),
                            rs.getDouble("salary"), rs.getTimestamp("regtime")));
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            System.out.println("连接出错了。。。。。。");
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public Integer insert(User user) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "insert into users values(null, ?, ?, ?, ?, ?, ?)";
            this.executeUpdate(sql, user.getUsn(), user.getPwd(), user.getAge(),
                    user.getBirthday(), user.getSalary(), user.getRegtime());
            res = result;
            /*
                如果返回值是ID或者Entity
                if(res!=0&&rs!=-1){
                sql="select last_insert_id()"
                this.executeQuery(sql);
                if(rs!=null&&rs.next()){
                int id=rs.getInt();
                return id;

                user.setId(id);
                return user;
                }
                  }
             */
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public int update(User user) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "update users set usn = ?, pwd = ?, age = ?, birthday = ?, " +
                    "salary = ?, regtime = ? where id = ?";
            this.executeUpdate(sql, user.getUsn(), user.getPwd(), user.getAge(),
                    user.getBirthday(), user.getSalary(), user.getRegtime(),
                    user.getId());
            res = result;
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public int delete(Integer id) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "delete from users where id = ?";
            this.executeUpdate(sql, id);
            res = result;
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(User user) {
        return this.delete(user.getId());
    }

    @Override
    public User FindByName(String usn) {
        User user = null;
        try {
            this.getConnection();
            String sql = "select * from users where usn = ?";
            this.executeQuery(sql, usn);
            if (rs != null && rs.next()) {
                //推荐写列标题，将一行记录封装到实体类中
                user = new User(rs.getInt("id"), rs.getString("usn"),
                        rs.getString("pwd"), rs.getInt("age"),
                        rs.getDate("birthday"), rs.getDouble("salary"),
                        rs.getTimestamp("regtime"));
            }
            this.closeAll();
        } catch (SQLException throwables) {
            System.out.println("连接出错了。。。。。。");
            throwables.printStackTrace();
        }
        return user;
    }
}
