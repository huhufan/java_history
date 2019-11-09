package com.imooc.cp.dao;

import com.imooc.cp.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {
    List<Department> selectAll();
    void insert(Department department);
    void update(Department department);
    void delete(String sn);
    Department select(String sn);
}
