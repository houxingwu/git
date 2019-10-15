package com.hou;

import java.math.*;
import java.util.Date;

/*
*
* gen by beetlsql 2016-01-06
*/
public class User  {
    private Integer id ;
    private Integer age ;
    private String name ;
    private Date createDate ;


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "com.hou.User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}