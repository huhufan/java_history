package com.iot.iot_date_interface2.controller;


import com.iot.iot_date_interface2.entity.Beam;
import com.iot.iot_date_interface2.entity.Temperature;
import com.iot.iot_date_interface2.service.BeamService;
import com.iot.iot_date_interface2.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.Date;

@RestController
@Validated
public class UploadDataController {
    @Autowired
    TemperatureService temperatureService;
    @Autowired
    BeamService beamService;


    @RequestMapping("/upload/temperature")
    public String insertTemperature(@Digits(integer = 3,fraction = 3,message = "The temperature must be a number(Integer digits less than 3 and decimal digits less than 3") @PathParam("temperature")  float  temperature,
                                     @Digits(integer = 3,fraction = 3,message = "The humidity must be a number(Integer digits less than 3 and decimal digits less than 3")  @PathParam("humidity")  float humidity,
                                     @NotNull(message = "Insert failed because the ACCESS KEY cannot be empty") @PathParam("ak") String ak){
        Temperature obj = new Temperature(temperature,humidity,ak,new Date());
        temperatureService.add(obj);
        return "success";
    }

    @RequestMapping("/uploadByPostBody/temperature")
    public String insertTemperatureByPost(@Validated @RequestBody Temperature temperature){
        temperature.setCreate_time(new Date());
        temperatureService.add(temperature);
        return "success";
    }


    @RequestMapping("/upload/beam")
    public String insertHumidity(@Digits(integer = 3,fraction = 3,message = "The beam must be a number(Integer digits less than 3 and decimal digits less than 3") @PathParam("beam")  float beam,
                                  @NotNull(message = "The ACCESS KEY cannot be empty") @PathParam("ak") String ak){
        Beam beam1 = new Beam(beam,ak,new Date());
        beamService.add(beam1);
        return "success";

    }

    @RequestMapping("/uploadByPostBody/beam")
    public String insertBeamByPost(@Validated @RequestBody Beam beam){
        beam.setCreate_time(new Date());
        beamService.add(beam);
        return "success";
    }

}
