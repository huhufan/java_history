package com.android.android_service.controller;

import com.android.android_service.Entity.SensorData;
import com.android.android_service.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

/**
 * @auther hu  .
 * @create 2019/9/27
 */
@RestController
public class MyController {
    @Autowired
    private SensorDataService sensorDataService;

    @RequestMapping("/getAll")
    public List<SensorData> getAll(){
        List<SensorData> all = sensorDataService.getAll();
        return all;
    }

    /**
     * private Integer ID;
     *     private String TEMPERATURE;
     *     private String LIGHT;
     *     private String ACCELEROMETER;
     *     private String MAGNETIC_FIELD;
     *     private String ORIENTATION;
     */
    @PostMapping("/add")
    public void add(String TEMPERATURE,String LIGHT,String ACCELEROMETER,String MAGNETIC_FIELD,String ORIENTATION){
        sensorDataService.add(new SensorData(TEMPERATURE,LIGHT,ACCELEROMETER,MAGNETIC_FIELD,ORIENTATION));
    }
}
