package com.imooc.ioc.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springDemo3 {
    @Test
    /**
     * 生命周期测试
     */
    public void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Man man = (Man)applicationContext.getBean("man");

        man.run();

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.findAll();
        userDao.save();
        userDao.delete();
        userDao.update();

    }
}
