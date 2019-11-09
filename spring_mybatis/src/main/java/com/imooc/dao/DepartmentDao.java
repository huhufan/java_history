package com.imooc.dao;

import com.imooc.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {

    List<Department> getAll();
}
