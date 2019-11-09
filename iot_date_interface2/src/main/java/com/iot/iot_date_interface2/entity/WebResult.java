package com.iot.iot_date_interface2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author pengyuming
 *
 */
public class WebResult<T>  {

    public static final String SUCESS = "SUCESS";
    public static final String FAILED = "FAILED";

    /**
     * 状态码
     */
    @JsonProperty("flag")
    private String flag;
    /**
     * 信息
     */
    @JsonProperty("info")
    private String info;

    /**
     * 数据
     */
    @JsonProperty("data")
    private T data;

    public WebResult() {

    }

    public WebResult(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}