package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.name:Lisi}")
    private String name;

    @Autowired
    private Person person;

    @Value("${ComSpec}")
    private String msg;

    @Value("${os.name}")
    private String osName;


    @GetMapping("/")
    public String hello() {
        return person.getClass().toString();
    }

    @GetMapping("/person")
    public Person person() {
        return person;
    }

    @GetMapping("/msg")
    public String msg() {
        return msg + "===>" + osName;
    }

}
