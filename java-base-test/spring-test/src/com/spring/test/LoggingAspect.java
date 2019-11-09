package com.spring.test;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther hu  .
 * @create 2019/9/9
 */
//将这个类声明为一个切面，需要放入到IOC容器中，再声明为一个切面
@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* com.spring.test.Service.doService())")
    public void beforeAdvice() {
        System.out.println("beforeAdvice..........");
    }

    @After("execution(* com.spring.test.Service.doService())")
    public void afterAdvice() {
        System.out.println("afterAdvice..........");
    }
}