package com.test.bookshop.dao.jdbcimpl;

import com.test.bookshop.utils.DBUtil;

import java.sql.*;

//具体Dao的类，完成数据库访问的共性操作
//不处理异常，抛出异常，给调用者（具体的子类）处理
public class GenericBaseDao {

    //声明私有静态属性、获取数据库保存或者连接的配置参数
    private static String driver = DBUtil.driver;
    private static String url = DBUtil.url;
    private static String user = DBUtil.user;
    private static String passwd = DBUtil.passwd;

    //借助静态代码块完成一次性的注册驱动程序
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //共性的操作：获取连接、执行通用的增删改方法、执行通用的查询方法、关闭连接
    //声明基础接口对象，因为是父类中属性，可以被子类使用
    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;
    protected int result = -1;//原因是没有修改成功也可能是0

    /**
     * 获取连接方法,获取数据库连接
     *
     * @throws SQLException
     */
    public void getConnection() throws SQLException {
        conn = DriverManager.getConnection(url, user, passwd);
    }

    /**
     * 关闭连接资源，先判断再关闭。
     *
     * @throws SQLException
     */
    public void closeAll() throws SQLException {
        //先判断，在非空和未关闭的情况下的条件下关闭
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (pstmt != null && !pstmt.isClosed()) {
            pstmt.close();
        }
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
        //判断增删改的情况
        if (result != -1) result = -1;
    }

    /**
     * 通用的增删改方法,生成sql语句的容器对象，放入sql语句，执行获取返回结果,使用final性能更高
     *
     * @param sql
     * @param params
     * @throws SQLException
     */
    public void executeUpdate(final String sql, final Object... params) throws SQLException {
        //生成sql语句的容器对象
        pstmt = conn.prepareStatement(sql);
        //判断是否有参数，如果有，逐个遍历参数数组，逐个将参数传入sql语句
        if (params != null) {//有参数的传入，开始遍历，进行参数设置
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        //执行sql语句（增删改），将返回结果放入result中。
        result = pstmt.executeUpdate();
    }

    /**
     * 通用的查询方法，生成sql语句的容器对象，放入sql语句，执行获取返回结果集,使用final性能更高
     *
     * @param sql
     * @param params
     * @throws SQLException
     */
    public void executeQuery(final String sql, final Object... params) throws SQLException {
        //生成sql语句的容器对象
        pstmt = conn.prepareStatement(sql);
        //判断是否有参数，如果有，逐个遍历参数数组，逐个将参数传入sql语句
        if (params != null) {//有参数的传入，开始遍历，进行参数设置
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        //执行sql语句（增删改），将返回结果集放入re中。
        rs = pstmt.executeQuery();
    }

    /**  上述所有方法的结果或者结果集都在具体子类中处理
     */
}
