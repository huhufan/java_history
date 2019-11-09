package com.example.casedemo.controller;

import com.example.casedemo.dao.DepartmentDao;
import com.example.casedemo.dao.EmployeeDao;
import com.example.casedemo.entities.Department;
import com.example.casedemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "emp/add";
    }
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        model.addAttribute("emp",employee);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String add(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @PutMapping("/emp")
    public String update(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
