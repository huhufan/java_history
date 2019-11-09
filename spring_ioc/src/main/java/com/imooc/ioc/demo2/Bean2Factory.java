package com.imooc.ioc.demo2;

public class Bean2Factory {
    public static Bean2 createBean2(){
        System.out.println("bean2Factory被执行了");
        return new Bean2();
    }
}
