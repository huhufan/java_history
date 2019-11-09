package com.demo.sql.bean;
/*
create table ZZ(
id varchar(20) primary key,
username varchar(20) not null,
title varchar(20),
password varchar(20) not null,
sex enum('男','女') default '男',
emial varchar(20),
ZBK_id varchar(20) not null,
room_url varchar(50),
foreign key(ZBK_id) references ZBK(id)
); */
public class ZZ {
    private String id;
    private String username;
    private String title;
    private String password;
    private String sex;
    private String emial;
    private String room_url;
    private String zz_sign;

    public ZZ(String id, String username, String title, String password, String sex, String emial, String room_url, String zz_sign) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.password = password;
        this.sex = sex;
        this.emial = emial;
        this.room_url = room_url;
        this.zz_sign = zz_sign;

    }

    public String getZz_sign() {
        return zz_sign;
    }

    public void setZz_sign(String zz_sign) {
        this.zz_sign = zz_sign;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }


    public String getRoom_url() {
        return room_url;
    }

    public void setRoom_url(String room_url) {
        this.room_url = room_url;
    }

    public ZZ(String id, String username, String title, String password, String sex, String emial, String room_url) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.password = password;
        this.sex = sex;
        this.emial = emial;
        this.room_url = room_url;
    }
}
