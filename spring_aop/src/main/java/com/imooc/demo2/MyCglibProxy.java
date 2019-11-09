package com.imooc.demo2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibProxy implements MethodInterceptor {
    private ProductDao productDao;

    public MyCglibProxy(ProductDao productDao){
        this.productDao = productDao;
    }
    public Object createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(productDao.getClass());
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("save".equals(method.getName())){
            System.out.println("效验---");
            return methodProxy.invokeSuper(o,objects);
        }
        return methodProxy.invokeSuper(o,objects);
    }
}
