package com.example.spring_boot_mybatis2.DaoMapper;

import com.example.spring_boot_mybatis2.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {
   @Select("select * from department where id=#{id}")
     Department getById(Integer id);
}
