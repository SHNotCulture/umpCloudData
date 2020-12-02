package com.ump.entity.MQTTResult;

public class TheThirdCoupon {
    private String parkId;
    private String carPlate;
    private String inTime;
    private String orderId;

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "TheThirdCoupon{" +
                "parkId='" + parkId + '\'' +
                ", carPlate='" + carPlate + '\'' +
                ", inTime='" + inTime + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
