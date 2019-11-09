package com.imooc.demo2;

import org.junit.Test;

public class demo2 {
    @Test
    public void test(){
        ProductDao productDao = new ProductDao();
        MyCglibProxy myCglibProxy = new MyCglibProxy(productDao);

        ProductDao proxy = (ProductDao)myCglibProxy.createProxy();
        proxy.save();
        proxy.update();
    }
}

