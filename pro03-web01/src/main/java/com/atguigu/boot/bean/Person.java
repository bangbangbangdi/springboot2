package com.atguigu.boot.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}
