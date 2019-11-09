package com.atguigu.springboot_dubbo_ticket_provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class SpringbootDubboTicketProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboTicketProviderApplication.class, args);
    }

}
