package com.imooc.ioc.demo1;

public class UserServiceImpl implements UserService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("hello spring "+name);
    }
}
