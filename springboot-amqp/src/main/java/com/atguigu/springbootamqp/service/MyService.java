package com.atguigu.springbootamqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @RabbitListener(queues = "atguigu.news")
    public void service(Message message){
        System.out.println("收到消息");
        System.out.println(message.toString());
    }
}
