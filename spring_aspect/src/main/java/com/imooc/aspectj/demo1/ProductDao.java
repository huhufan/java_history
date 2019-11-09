package com.imooc.aspectj.demo1;

public class ProductDao {

    public void save(){
        System.out.println("保存商品。。");
    }
    public void delete(){
        System.out.println("删除商品。。");
    }
    public String update(){
        System.out.println("更新商品。。");
        return "update的return";
    }
    public void findAll(){
        System.out.println("发现商品。。");
        int a = 2/0;
    }
    public void findOne(){
        System.out.println("发现one商品。。");
        int a = 2/0;
    }
}
