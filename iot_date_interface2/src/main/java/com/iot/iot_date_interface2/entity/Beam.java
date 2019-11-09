package com.iot.iot_date_interface2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Beam implements Serializable {
    @Digits(integer = 3,fraction = 3,message = "The beam value must be a number(Integer digits less than 3 and decimal digits less than 3")
    private float beam;
    @NotNull(message = "The ACCESS KEY can not be empty")
    private String ak;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    public Beam(float beam, String ak, Date create_time) {
        this.beam = beam;
        this.ak = ak;
        this.create_time = create_time;
    }

    public Beam() {
    }

    public float getBeam() {
        return beam;
    }

    public void setBeam(float beam) {
        this.beam = beam;
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
}
