package com.example.smart_home_api2.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public enum Motto {
    ONE("zrq","宗瑞琪","帅帅帅帅帅帅帅帅帅帅帅帅帅帅帅！"),TWO("zzr","张卓然","我可能是个傻屌吧，不知道填个啥！"),THREE("czq","柴子祺","733最帅！"),
    FOUR("fw","樊伟","虽不能至，却心向往之！"),FIVE("klxsz","仙女猪本人","这可能就是个仙女吧！"),SIX("cxk","蔡徐坤","我是全世界最爱的坤坤哦！")
    ,SEVEN("fhh","虎虎樊最 . 了na",".............!!!")
    ;
    private String sx;
    private String name;
    private String  motto;

    private Motto(String sx,String name, String motto) {
        this.sx = sx;
        this.name = name;
        this.motto = motto;
    }
    public static String getName(String sx){
        for (Motto data: values()){
            if (data.sx.equals(sx)){
                return data.name;
            }
        }
        return null;
    }
    public static String getMotto(String sx){
        for (Motto data: values()){
            if (data.sx.equals(sx)){
                return data.motto;
            }
        }
        return null;
    }
}
