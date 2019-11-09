package com.example.demo.Dao;

import com.example.demo.entity.Department;
import org.springframework.stereotype.Repository;

public interface DepartmentDao {

     Department get(Integer id);
}
