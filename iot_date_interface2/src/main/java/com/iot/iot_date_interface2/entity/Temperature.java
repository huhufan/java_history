package com.iot.iot_date_interface2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


public class Temperature implements Serializable {
    @Digits(integer = 3,fraction = 3,message = "The temperature value must be a number(Integer digits less than 3 and decimal digits less than 3")
    private float temperature;
    @Digits(integer = 3,fraction = 3,message = "The humidity value must be a number(Integer digits less than 3 and decimal digits less than 3")
    private float humidity;
    @NotNull(message = "The ACCESS KEY can not be empty")
    private String ak;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    public Temperature(float temperature, float humidity, String ak, Date create_time) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.ak = ak;
        this.create_time = create_time;
        float a = 333.323f;
    }
    public Temperature( ) {
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }


}
