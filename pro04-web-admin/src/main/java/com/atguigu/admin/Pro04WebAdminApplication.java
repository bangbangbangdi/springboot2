package com.atguigu.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.atguigu")
@SpringBootApplication
public class Pro04WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pro04WebAdminApplication.class, args);
    }

}
