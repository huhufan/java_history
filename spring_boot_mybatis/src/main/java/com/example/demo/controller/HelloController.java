package com.example.demo.controller;

import com.example.demo.Dao.DepartmentDao;
import com.example.demo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
//    @Autowired
//    DepartmentDao departmentDao;
//
//    @GetMapping("/hello/{id}")
//    public Department get(@PathVariable Integer id){
//        return departmentDao.get(id);
//    }
     @Autowired
     JdbcTemplate jdbcTemplate;
     @RequestMapping("/query")
     public Map<String,Object> query(){
             List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from department");
         return list.get(0);
}

}
