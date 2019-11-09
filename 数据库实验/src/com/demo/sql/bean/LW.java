package com.demo.sql.bean;

public class LW {
    private String zz_id;
    private String user_id;
    private Integer money;

    public String getZz_id() {
        return zz_id;
    }

    public void setZz_id(String zz_id) {
        this.zz_id = zz_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public LW(String zz_id, String user_id, Integer money) {
        this.zz_id = zz_id;
        this.user_id = user_id;
        this.money = money;
    }
}
