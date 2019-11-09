package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@SuppressWarnings("serial ")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptno;
    private String dname;
    private String db_source;  //来自哪个数据库，因为微服务架构可以一个服务对应一个数据库


    public static void main(String[] args) {
        Dept dept = new Dept();


    }
}



