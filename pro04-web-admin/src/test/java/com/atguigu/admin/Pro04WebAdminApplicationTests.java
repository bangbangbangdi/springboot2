package com.atguigu.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Pro04WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {

        //jdbcTemplate.queryForObject("");
        //jdbcTemplate.queryForList()
        Long aLong = jdbcTemplate.queryForObject("select count(*) from jobs", Long.class);
        log.info("记录总数:{}",aLong);
        log.info("数据源类型:{}",dataSource.getClass());
    }

}
