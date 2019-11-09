package com.demo.sql.bean;

public class YH {
    private  String id;
    private String username;
    private String password;
    private Integer usersign;
    private String sex;
    private String emial;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUsersign() {
        return usersign;
    }

    public void setUsersign(Integer usersign) {
        this.usersign = usersign;
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

    public YH(String id, String username, String password, Integer usersign, String sex, String emial) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.usersign = usersign;
        this.sex = sex;
        this.emial = emial;
    }
}
