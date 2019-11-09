package com.imooc.demo4;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class MyAroundAdvice implements MethodInterceptor {


    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("环绕前增强");
        Object obj = methodInvocation.proceed();
        System.out.println("环绕后增强");

        return obj;
    }
}
