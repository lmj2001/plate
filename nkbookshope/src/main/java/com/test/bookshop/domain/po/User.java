package com.test.bookshop.domain.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class User implements Serializable {
    //声明属性
    private Integer id;
    private String usn;
    private String pwd;
    private int age;
    private Date birthday;
    private double salary;
    private Timestamp regtime;

    //生产构造方法


    public User() {
    }

    /**
     * 给select方法使用
     * @param id
     * @param usn
     * @param age
     * @param birthday
     * @param salary
     * @param regtime
     */
    public User(Integer id, String usn, String pwd,
                int age, Date birthday, double salary, Timestamp regtime) {
        this.id = id;
        this.usn = usn;
        this.pwd = pwd;
        this.age = age;
        this.birthday = birthday;
        this.salary = salary;
        this.regtime = regtime;
    }

    /**
     *给insert功能使用
     * @param usn
     * @param age
     * @param birthday
     * @param salary
     * @param regtime
     */
    public User(String usn, String pwd, int age, Date birthday, double salary, Timestamp regtime) {
        this.usn = usn;
        this.pwd = pwd;
        this.age = age;
        this.birthday = birthday;
        this.salary = salary;
        this.regtime = regtime;
    }


    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //封装公有setter&getter方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Timestamp getRegtime() {
        return regtime;
    }

    public void setRegtime(Timestamp regtime) {
        this.regtime = regtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usn='" + usn + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", salary=" + salary +
                ", regtime=" + regtime +
                '}';
    }
}
