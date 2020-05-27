package com.hx.swagger2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hx.swagger2.mapper")
public class mybatisplusApplication {
    public static void main(String[] args) {
        SpringApplication.run(mybatisplusApplication.class, args);
    }

}
