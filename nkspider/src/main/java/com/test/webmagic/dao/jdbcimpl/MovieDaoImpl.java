package com.test.webmagic.dao.jdbcimpl;

import com.test.webmagic.dao.MovieDao;
import com.test.webmagic.domain.po.Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MovieDaoImpl  implements MovieDao {
    public void addMovie(Movie movie) {
        Connection  conn=null;
        PreparedStatement pstmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获得连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies?setServerTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "root");
            // sql语句
            String sql = "insert into movies(m_title,m_urls,m_ratings,m_dir,m_actor,m_type,m_time) values (?,?,?,?,?,?,?);";
            // pstmt
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, movie.getM_title());
            pstmt.setString(2, movie.getM_urls());
            pstmt.setFloat(3, movie.getM_ratings());
            pstmt.setString(4, movie.getM_dir());
            pstmt.setString(5, movie.getM_actor());
            pstmt.setString(6, movie.getM_type());
            pstmt.setString(7, movie.getM_time());
            //执行sql语句
            pstmt.execute();
            System.out.println("添加成功");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
