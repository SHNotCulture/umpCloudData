package com.ump.entity.MQTTResult;

public class CarFeeRsp {
    private Integer code;

    private String carplate;

    private String incarplate;

    private String intime;

    private  String outtime;

    private String duration;

    private String parkid;

    private String orderid;

    private double paid;

    private double needpay;

    private Integer timeStamp;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCarplate() {
        return carplate;
    }

    public void setCarplate(String carplate) {
        this.carplate = carplate;
    }

    public String getIncarplate() {
        return incarplate;
    }

    public void setIncarplate(String incarplate) {
        this.incarplate = incarplate;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getParkid() {
        return parkid;
    }

    public void setParkid(String parkid) {
        this.parkid = parkid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getNeedpay() {
        return needpay;
    }

    public void setNeedpay(double needpay) {
        this.needpay = needpay;
    }

    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "CarFeeRsp{" +
                "code=" + code +
                ", carplate='" + carplate + '\'' +
                ", incarplate='" + incarplate + '\'' +
                ", intime='" + intime + '\'' +
                ", outtime='" + outtime + '\'' +
                ", duration='" + duration + '\'' +
                ", parkid='" + parkid + '\'' +
                ", orderid='" + orderid + '\'' +
                ", paid=" + paid +
                ", needpay=" + needpay +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
