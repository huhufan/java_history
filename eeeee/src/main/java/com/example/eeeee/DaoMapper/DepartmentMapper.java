package com.example.eeeee.DaoMapper;

import com.example.eeeee.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface DepartmentMapper {
   @Select("select * from department where id=#{id}")
     Department getById(Integer id);
}
