package com.atguigu.springbootamqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAmqpApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void contextLoads() {
//        Map<String,Object> map = new HashMap<>();
//        map.put("title","This is my first message");
//        map.put("data", Arrays.asList("hello","123","haha"));
//        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqphahah",null));
    }
    @Test
    public void contextLoads2() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
