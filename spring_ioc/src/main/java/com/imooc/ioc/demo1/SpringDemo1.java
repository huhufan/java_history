package com.imooc.ioc.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.beans.beancontext.BeanContext;

public class SpringDemo1 {

    @Test
    /**
     * 传统方式
     */
    public void demo1(){
        //UserService userService = new UserServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        userService.setName("张三");
        userService.sayHello();
    }

    @Test
    /**
     * spring 方式
     */

    public void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)applicationContext.getBean("UserService");
        userService.sayHello();
    }

    @Test
    /**
     * beanFactory
     */
    public void demo3(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        UserService userService = (UserService)beanFactory.getBean("UserService");
        userService.sayHello();
    }

}
