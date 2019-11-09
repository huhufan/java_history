package com.android.android_service.service;

import com.android.android_service.Entity.SensorData;
import com.android.android_service.dao.SensorDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataService {
    @Autowired
    private SensorDataDao sensorDataDao;


    public List<SensorData> getAll() {
        List<SensorData> sensorDataList = sensorDataDao.selectAll();
        return sensorDataList;
    }

    public boolean add(SensorData sensorData) {
        Boolean res = sensorDataDao.insert(sensorData);
        return res;
    }

}
