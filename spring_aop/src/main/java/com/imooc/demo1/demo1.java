package com.imooc.demo1;

import org.junit.Test;

public class demo1 {

    @Test
    public void demo1(){
        UserDao userDao = new UserDaoImpl();

        UserDao proxy = (UserDao)new MyJDKProxy(userDao).createProxy();

        proxy.save();
        proxy.update();
    }


}
