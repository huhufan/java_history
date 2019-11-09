package com.imooc.cp.biz;

import com.imooc.cp.entity.Department;
import com.imooc.cp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeBiz {
    void add(Employee employee);
    void edit(Employee employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();
}
