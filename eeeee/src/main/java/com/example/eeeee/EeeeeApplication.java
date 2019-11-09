package com.example.eeeee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.example.eeeee.DaoMapper")
@SpringBootApplication
public class EeeeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EeeeeApplication.class, args);
    }

}
