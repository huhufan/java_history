package com.example.middleware.Dao;

import com.example.middleware.entity.Dl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DlDAO {
     boolean insert(Dl dl);

     boolean delete(String xm);

     boolean update(Dl dl);

     List<Dl> selectAll();

     Dl selectByXM(String xm);




}
