package com.atguigu.springboot_dubbo_user_consumer.controller;

import com.atguigu.springboot_dubbo_common.bean.UserAddress;
import com.atguigu.springboot_dubbo_common.service.OrderService;
import com.atguigu.springboot_dubbo_user_consumer.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    OrderService   orderService;

    @ResponseBody
    @RequestMapping("/hello")
    public List<UserAddress> hello(){
        List<UserAddress> userAddresses = orderService.initOrder("1");
        return userAddresses;
    }
}
