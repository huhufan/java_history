package com.imooc.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class SpringDemo1 {
    @Test
    public void demo1(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("G:\\IDE\\Project\\spring_ioc_annotation\\src\\main\\resources\\applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService.sayHello("haha"));
    }


}
