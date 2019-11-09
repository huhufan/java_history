package com.iot.iot_date_interface2.controller;


import com.iot.iot_date_interface2.entity.Beam;
import com.iot.iot_date_interface2.entity.Temperature;
import com.iot.iot_date_interface2.service.BeamService;
import com.iot.iot_date_interface2.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class GetDataController {

    @Autowired
    TemperatureService temperatureService;
    @Autowired
    BeamService beamService;

    /**
     * 温湿度 temperature(humidity)
     * @return
     */


    @GetMapping("/getByAK/temperature/{ak}")
    public List<Temperature> getByAK(@PathVariable("ak") String ak){
       return temperatureService.getByAK(ak);
    }


    /**
     *  光照强度 beam
     */


    @GetMapping("/getByAK/beam/{ak}")
    public List<Beam> getBeamByAK(@PathVariable("ak") String ak){
        return beamService.getByAK(ak);
    }

}
