package com.example.spring_boot_mybatis2.controller;

import com.example.spring_boot_mybatis2.DaoMapper.DepartmentMapper;
import com.example.spring_boot_mybatis2.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {
    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/test")
    public Map<String,Object> get(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","hu");
        return map;
    }
    @RequestMapping("/dep/{id}")
    public Department getById(@PathVariable Integer id){
        return departmentMapper.getById(id);
    }
}
