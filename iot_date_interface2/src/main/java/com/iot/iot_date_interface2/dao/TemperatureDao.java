package com.iot.iot_date_interface2.dao;

import com.iot.iot_date_interface2.entity.Temperature;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface TemperatureDao {

    List<Temperature> selectAll();

    Boolean insert(Temperature temperature);

    List<Temperature> selectByAK(String ak);


}

