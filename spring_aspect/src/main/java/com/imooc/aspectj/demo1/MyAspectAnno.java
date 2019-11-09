package com.imooc.aspectj.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspectAnno {

    //@Before(value = "execution(* com.imooc.aspectj.demo1.ProductDao.save(..))")
    @Before(value = "myPointCut1()")
    public void before(){
        System.out.println("--------前置通知---------");
    }
    @AfterReturning(value = "execution(* com.imooc.aspectj.demo1.ProductDao.update(..))",returning = "result")
    public void afterReturn(Object result){
        System.out.println("--------后置通知---------"+result);
    }
    @Around(value = "execution(* com.imooc.aspectj.demo1.ProductDao.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------前置通知---------"+joinPoint);
        Object proceed = joinPoint.proceed();
        System.out.println("--------后置通知---------"+joinPoint);
        return  proceed;
    }
    @AfterThrowing(value = "execution(* com.imooc.aspectj.demo1.ProductDao.findAll(..))" , throwing = "e")
    public void afterThrow(Throwable e){
        System.out.println("-------异常抛出通知--------"+e.getMessage());
    }

    @After(value = "execution(* com.imooc.aspectj.demo1.ProductDao.findOne())")
    public void after(){
        System.out.println("-------最终通知--------");
    }


    @Pointcut(value = "execution(* com.imooc.aspectj.demo1.ProductDao.save(..))")
    private void myPointCut1(){}
}
