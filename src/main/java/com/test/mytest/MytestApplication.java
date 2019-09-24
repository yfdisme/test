package com.test.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan("com.test.mytest.dao")
public class MytestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytestApplication.class, args);
    }

}
