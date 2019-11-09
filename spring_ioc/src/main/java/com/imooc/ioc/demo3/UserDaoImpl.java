package com.imooc.ioc.demo3;


public class UserDaoImpl implements UserDao {
    public void findAll() {
        System.out.println("findAll");
    }

    public void save() {
        System.out.println("save");
    }

    public void update() {
        System.out.println("update");
    }

    public void delete() {
        System.out.println("delete");
    }
}
