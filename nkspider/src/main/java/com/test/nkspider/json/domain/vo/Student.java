package com.test.nkspider.json.domain.vo;

import java.util.List;

public class Student {
    private String name;
    private long age;
    private List<String> like;
    private List<Score> scores;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", like=" + like +
                ", scores=" + scores +
                '}';
    }

    public Student() {
    }

    public Student(String name, long age, List<String> like, List<Score> scores) {
        this.name = name;
        this.age = age;
        this.like = like;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public List<String> getLike() {
        return like;
    }

    public void setLike(List<String> like) {
        this.like = like;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }


}
