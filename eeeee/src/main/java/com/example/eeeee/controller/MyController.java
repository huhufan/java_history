package com.example.eeeee.controller;

import com.example.eeeee.DaoMapper.DepartmentMapper;
import com.example.eeeee.DaoMapper.EmployeeMapper;
import com.example.eeeee.entity.Department;
import com.example.eeeee.entity.Employee;
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
    @Autowired
    EmployeeMapper employeeMapper;

    @RequestMapping("/test")
    public Map<String, Object> get() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "hu");
        return map;
    }

    @RequestMapping("/dep/{id}")
    public Department getById(@PathVariable Integer id) {
        return departmentMapper.getById(id);
    }

    @RequestMapping("/em/{id}")
    public Employee emGetById(@PathVariable Integer id) {
        return employeeMapper.getById(id);
    }
}
