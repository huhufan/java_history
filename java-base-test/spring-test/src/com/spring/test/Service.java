package com.spring.test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @auther hu  .
 * @create 2019/9/9
 */

@Component
public class Service {
    public void doService() {
        System.out.println("service.............");
    }
}
