package com.iot.raspi_client;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RaspiClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaspiClientApplication.class, args);
    }

}
