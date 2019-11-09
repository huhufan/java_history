package com.imooc.demo1;

import org.springframework.stereotype.Service;

@Service("userDao")
public class UserDao {
    public UserDao(){
        System.out.println("我是UserDao的构造方法");
    }
}
