package com.ump.entity.MQTTResult;

public class PrePayCoupon {
    private String parkId;
    private String carPlate;
    private String inTime;
    private String orderId;
    private double discountsFee;

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

    public double getDiscountsFee() {
        return discountsFee;
    }

    public void setDiscountsFee(double discountsFee) {
        this.discountsFee = discountsFee;
    }

    @Override
    public String toString() {
        return "PrePayCoupon{" +
                "parkId='" + parkId + '\'' +
                ", carPlate='" + carPlate + '\'' +
                ", inTime='" + inTime + '\'' +
                ", orderId='" + orderId + '\'' +
                ", discountsFee=" + discountsFee +
                '}';
    }
}
