package com.xuegao.to_mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.xuegao.to_mysql.dao"})
public class ToMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToMysqlApplication.class, args);
    }

}
