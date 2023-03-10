package com.atguigu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@ServletComponentScan(basePackages = "com.atguigu")
@SpringBootApplication
@MapperScan("com.atguigu.admin.mapper")
public class Pro04WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pro04WebAdminApplication.class, args);
    }

}
