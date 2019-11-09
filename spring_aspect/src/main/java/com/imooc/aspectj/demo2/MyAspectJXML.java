package com.imooc.aspectj.demo2;


import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectJXML {

    public void before(){
        System.out.println("----前置通知----");
    }
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------前置通知---------"+joinPoint);
        Object proceed = joinPoint.proceed();
        System.out.println("--------后置通知---------"+joinPoint);
        return  proceed;
    }
}
