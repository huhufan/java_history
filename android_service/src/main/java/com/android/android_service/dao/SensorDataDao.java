package com.android.android_service.dao;

import com.android.android_service.Entity.SensorData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SensorDataDao {
    List<SensorData> selectAll();
    Boolean insert(SensorData data);
}
