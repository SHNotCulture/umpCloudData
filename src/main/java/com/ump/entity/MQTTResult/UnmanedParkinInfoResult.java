package com.ump.entity.MQTTResult;

public class UnmanedParkinInfoResult {
    public String inLaneId;
    public String carInFlow;
    public String orderId;
    public String opened;
    public String carNature;
    public String inCarPlate;
    public String isBlackCarplate;
    public String inCarPlateColor;
    public String inPicPath;
    public String inTime;
    public String inCarType;
    public String inAreaNumber;
    public String message;

    public String getInLaneId() {
        return inLaneId;
    }

    public void setInLaneId(String inLaneId) {
        this.inLaneId = inLaneId;
    }

    public String getCarInFlow() {
        return carInFlow;
    }

    public void setCarInFlow(String carInFlow) {
        this.carInFlow = carInFlow;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOpened() {
        return opened;
    }

    public void setOpened(String opened) {
        this.opened = opened;
    }

    public String getCarNature() {
        return carNature;
    }

    public void setCarNature(String carNature) {
        this.carNature = carNature;
    }

    public String getInCarPlate() {
        return inCarPlate;
    }

    public void setInCarPlate(String inCarPlate) {
        this.inCarPlate = inCarPlate;
    }

    public String getIsBlackCarplate() {
        return isBlackCarplate;
    }

    public void setIsBlackCarplate(String isBlackCarplate) {
        this.isBlackCarplate = isBlackCarplate;
    }

    public String getInCarPlateColor() {
        return inCarPlateColor;
    }

    public void setInCarPlateColor(String inCarPlateColor) {
        this.inCarPlateColor = inCarPlateColor;
    }

    public String getInPicPath() {
        return inPicPath;
    }

    public void setInPicPath(String inPicPath) {
        this.inPicPath = inPicPath;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getInCarType() {
        return inCarType;
    }

    public void setInCarType(String inCarType) {
        this.inCarType = inCarType;
    }

    public String getInAreaNumber() {
        return inAreaNumber;
    }

    public void setInAreaNumber(String inAreaNumber) {
        this.inAreaNumber = inAreaNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UnmanedParkinInfoResult{" +
                "inLaneId='" + inLaneId + '\'' +
                ", carInFlow='" + carInFlow + '\'' +
                ", orderId='" + orderId + '\'' +
                ", opened='" + opened + '\'' +
                ", carNature='" + carNature + '\'' +
                ", inCarPlate='" + inCarPlate + '\'' +
                ", isBlackCarplate='" + isBlackCarplate + '\'' +
                ", inCarPlateColor='" + inCarPlateColor + '\'' +
                ", inPicPath='" + inPicPath + '\'' +
                ", inTime='" + inTime + '\'' +
                ", inCarType='" + inCarType + '\'' +
                ", inAreaNumber='" + inAreaNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
