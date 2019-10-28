package com.jc.dship;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jc.dship.dao")
public class DshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(DshipApplication.class, args);
    }

}
