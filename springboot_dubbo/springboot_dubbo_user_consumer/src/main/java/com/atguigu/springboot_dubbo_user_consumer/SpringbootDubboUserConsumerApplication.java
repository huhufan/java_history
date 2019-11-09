package com.atguigu.springboot_dubbo_user_consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class SpringbootDubboUserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboUserConsumerApplication.class, args);
    }

}
