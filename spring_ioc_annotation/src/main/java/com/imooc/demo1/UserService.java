package com.imooc.demo1;

import org.junit.validator.ValidateWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component("userService")
public class UserService {
    @Value("米饭")
    private String name;
//    @Autowired
//    @Qualifier("userDao")
    @Resource(name = "userDao")
    private UserDao userDao;

    public String sayHello(String name){
        return "hello"+name;
    }

}
