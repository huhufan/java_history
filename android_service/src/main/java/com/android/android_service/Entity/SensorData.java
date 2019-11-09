package com.android.android_service.Entity;

/**
 * @auther hu  .
 * @create 2019/9/27
 */
public class SensorData {
    private Integer ID;
    private String TEMPERATURE;
    private String LIGHT;
    private String ACCELEROMETER;
    private String MAGNETIC_FIELD;
    private String ORIENTATION;

    @Override
    public String toString() {
        return "SensorData{" +
                "ID=" + ID +
                ", TEMPERATURE='" + TEMPERATURE + '\'' +
                ", LIGHT='" + LIGHT + '\'' +
                ", ACCELEROMETER='" + ACCELEROMETER + '\'' +
                ", MAGNETIC_FIELD='" + MAGNETIC_FIELD + '\'' +
                ", ORIENTATION='" + ORIENTATION + '\'' +
                '}';
    }

    public SensorData(Integer ID, String TEMPERATURE, String LIGHT, String ACCELEROMETER, String MAGNETIC_FIELD, String ORIENTATION) {
        this.ID = ID;
        this.TEMPERATURE = TEMPERATURE;
        this.LIGHT = LIGHT;
        this.ACCELEROMETER = ACCELEROMETER;
        this.MAGNETIC_FIELD = MAGNETIC_FIELD;
        this.ORIENTATION = ORIENTATION;
    }

    public SensorData(String TEMPERATURE, String LIGHT, String ACCELEROMETER, String MAGNETIC_FIELD, String ORIENTATION) {
        this.TEMPERATURE = TEMPERATURE;
        this.LIGHT = LIGHT;
        this.ACCELEROMETER = ACCELEROMETER;
        this.MAGNETIC_FIELD = MAGNETIC_FIELD;
        this.ORIENTATION = ORIENTATION;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTEMPERATURE() {
        return TEMPERATURE;
    }

    public void setTEMPERATURE(String TEMPERATURE) {
        this.TEMPERATURE = TEMPERATURE;
    }

    public String getLIGHT() {
        return LIGHT;
    }

    public void setLIGHT(String LIGHT) {
        this.LIGHT = LIGHT;
    }

    public String getACCELEROMETER() {
        return ACCELEROMETER;
    }

    public void setACCELEROMETER(String ACCELEROMETER) {
        this.ACCELEROMETER = ACCELEROMETER;
    }

    public String getMAGNETIC_FIELD() {
        return MAGNETIC_FIELD;
    }

    public void setMAGNETIC_FIELD(String MAGNETIC_FIELD) {
        this.MAGNETIC_FIELD = MAGNETIC_FIELD;
    }

    public String getORIENTATION() {
        return ORIENTATION;
    }

    public void setORIENTATION(String ORIENTATION) {
        this.ORIENTATION = ORIENTATION;
    }
}
