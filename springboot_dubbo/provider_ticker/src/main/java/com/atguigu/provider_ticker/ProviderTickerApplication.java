package com.atguigu.provider_ticker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//将服务提供者注册到注册中心
@SpringBootApplication
public class ProviderTickerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTickerApplication.class, args);
    }

}
