package com.imooc.demo4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class SpringDemo4 {

    //@Resource(name = "customer")
    @Resource(name = "customerProxy")
    private Customer customer;

    @Test
    public void demo4() {
       customer.delete();
       customer.find();
       customer.save();
       customer.update();
    }
}

