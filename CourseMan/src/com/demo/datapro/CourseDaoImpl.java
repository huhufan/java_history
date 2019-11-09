package com.demo.datapro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDaoImpl {
    private static final List<Map<String,String>> usersTable = new ArrayList<>();
    private static final List<Course> coursesTable = new ArrayList<>();
static {
    User user=new User("imooc","imooc","超级管理员");
    Map<String,String> map=new HashMap();
    map.put("username",user.getUsername());
    map.put("password",user.getPassword());
    map.put("userType",user.getUserType());
    usersTable.add(map);
}

    public static List<Map<String, String>> getUsersTable() {
        return usersTable;
    }

    public static List<Course> getCoursesTable() {
        return coursesTable;
    }
}
