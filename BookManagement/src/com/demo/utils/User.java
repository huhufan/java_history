package com.demo.utils;

public class User {
//    用户类User：
//    类型描述：能够描述用户名、密码、手机号码和邮箱等
//    方法：构造方法、get和set方法，toString()方法
    private String username,password,phoneNumber,emial;

    public User(String username, String password, String phoneNumber, String emial) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emial = emial;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emial='" + emial + '\'' +
                '}';
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }
}
