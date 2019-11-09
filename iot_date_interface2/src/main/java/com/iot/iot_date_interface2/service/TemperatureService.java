package com.iot.iot_date_interface2.service;

import com.iot.iot_date_interface2.dao.TemperatureDao;
import com.iot.iot_date_interface2.entity.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {
    @Autowired
    private TemperatureDao temperatureDao;


    public List<Temperature> getAll(){
        List<Temperature> temperatures = temperatureDao.selectAll();
        return temperatures;
    }

    public boolean add(Temperature temperature){
        Boolean res = temperatureDao.insert(temperature);
        return res;
    }

    public List<Temperature> getByAK(String ak){
        List<Temperature> temperatures = temperatureDao.selectByAK(ak);
        return temperatures;
    }
}
