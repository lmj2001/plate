package com.test.webmagic.domain.po;

public class Movie {
    //电影的属性
    private int m_id;
    private String m_title;
    private String m_urls;
    private Float m_ratings;
    private String m_dir;
    private String m_actor;
    private String m_type;
    private String m_time;

    @Override
    public String toString() {
        return "Movie{" +
                "m_id=" + m_id +
                ", m_title='" + m_title + '\'' +
                ", m_urls='" + m_urls + '\'' +
                ", m_ratings=" + m_ratings +
                ", m_dir='" + m_dir + '\'' +
                ", m_actor='" + m_actor + '\'' +
                ", m_type='" + m_type + '\'' +
                ", m_time='" + m_time + '\'' +
                '}';
    }

    public Movie() {
    }

    public Movie(int m_id, String m_title, String m_urls, Float m_ratings, String m_dir, String m_actor, String m_type, String m_time) {
        this.m_id = m_id;
        this.m_title = m_title;
        this.m_urls = m_urls;
        this.m_ratings = m_ratings;
        this.m_dir = m_dir;
        this.m_actor = m_actor;
        this.m_type = m_type;
        this.m_time = m_time;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public String getM_urls() {
        return m_urls;
    }

    public void setM_urls(String m_urls) {
        this.m_urls = m_urls;
    }

    public Float getM_ratings() {
        return m_ratings;
    }

    public void setM_ratings(Float m_ratings) {
        this.m_ratings = m_ratings;
    }

    public String getM_dir() {
        return m_dir;
    }

    public void setM_dir(String m_dir) {
        this.m_dir = m_dir;
    }

    public String getM_actor() {
        return m_actor;
    }

    public void setM_actor(String m_actor) {
        this.m_actor = m_actor;
    }

    public String getM_type() {
        return m_type;
    }

    public void setM_type(String m_type) {
        this.m_type = m_type;
    }

    public String getM_time() {
        return m_time;
    }

    public void setM_time(String m_time) {
        this.m_time = m_time;
    }
}
