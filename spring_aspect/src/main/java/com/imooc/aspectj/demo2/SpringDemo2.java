package com.imooc.aspectj.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class SpringDemo2 {
    @Resource(name = "customer")
    private Customer customer;

    @Test
    public void demo1(){
        customer.save();
        customer.update();
        customer.delete();
        customer.find();
    }
}
