package com.iot.iot_date_interface2.dao;

import com.iot.iot_date_interface2.entity.Beam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BeamDao {
    List<Beam> selectAll();

    List<Beam> selectByAK(String ak);

    Boolean insert(Beam beam);
}
