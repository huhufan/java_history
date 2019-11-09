package com.imooc.cp.biz;

import com.imooc.cp.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
public interface DepartmentBiz {
    void add(Department department);
    void edit(Department department);
    void remove(String sn);
    Department get(String sn);
    List<Department> getAll();
}
