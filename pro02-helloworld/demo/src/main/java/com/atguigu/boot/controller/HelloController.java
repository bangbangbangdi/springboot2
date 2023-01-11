package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person person(){

        String userName = person.getUserName();
        System.out.println("userName = " + userName);

        System.out.println("userName = \n lisi");
        return person;
    }

}
