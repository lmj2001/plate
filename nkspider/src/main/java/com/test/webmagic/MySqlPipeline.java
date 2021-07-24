package com.test.webmagic;

import com.test.webmagic.dao.MovieDao;
import com.test.webmagic.dao.jdbcimpl.MovieDaoImpl;
import com.test.webmagic.domain.po.Movie;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
public class MySqlPipeline implements Pipeline {

    public void process(ResultItems resultItems, Task task) {
        Movie movie=new Movie();
        //System.out.println(resultItems.toString());
        List<String> titles=resultItems.get("titles");
        List<String> movieUrls=resultItems.get("movieUrls");
        List<String> ratings=resultItems.get("ratings");
        List<String> attrFields=resultItems.get("attrFields");

        for (int i = 0; i < titles.size(); i++) {
            movie.setM_title(titles.get(i));
            movie.setM_urls(movieUrls.get(i));
            movie.setM_ratings(Float.valueOf(ratings.get(i)));
            String[] movieAttrs = attrFields.get(i).split("<br>");
            if(movieAttrs.length>4) {
                movie.setM_dir(movieAttrs[0].substring(23).trim());
                movie.setM_actor(movieAttrs[1].trim());
                movie.setM_type(movieAttrs[2].substring(4).trim());
                movie.setM_time(movieAttrs[4].substring(4, 9).trim());
            }else {//有些电影信息残缺不全：比如没有类型、没有等级评分（舍弃）
                movie.setM_dir("不详");
                movie.setM_actor("不详");
                movie.setM_type("不详");
                movie.setM_time("不详");
            }
            MovieDao movieDao=new MovieDaoImpl();
            movieDao.addMovie(movie);
        }
    }
}

