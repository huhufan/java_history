package com.imooc.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyJDKProxy implements InvocationHandler {
    private UserDao userDao;

    public MyJDKProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public Object createProxy(){
        Object proxy = Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),this);
        return proxy;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("save".equals(method.getName())){
            System.out.println("权限效验");
            return method.invoke(userDao,args);
        }
        return method.invoke(userDao,args);
    }
}
