package com.ump.entity.MQTTResult;

public class MQTTHeartbeatResult {
    private String parkId;
    private String parkName;
    private String laneId;
    private String laneName;
    private Integer inoutType;
    private String ipcSn;
    private String auxIpc1Sn;
    private String auxIpc2Sn;
    private String softwareVer;
    private String IPCofflinelist;
    private Integer capDGon;
    private Integer barriDGon;
    private Integer barriOpened;
    private Integer carInFlow;
    private Integer alarm;

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getLaneId() {
        return laneId;
    }

    public void setLaneId(String laneId) {
        this.laneId = laneId;
    }

    public String getLaneName() {
        return laneName;
    }

    public void setLaneName(String laneName) {
        this.laneName = laneName;
    }

    public Integer getInoutType() {
        return inoutType;
    }

    public void setInoutType(Integer inoutType) {
        this.inoutType = inoutType;
    }

    public String getIpcSn() {
        return ipcSn;
    }

    public void setIpcSn(String ipcSn) {
        this.ipcSn = ipcSn;
    }

    public String getAuxIpc1Sn() {
        return auxIpc1Sn;
    }

    public void setAuxIpc1Sn(String auxIpc1Sn) {
        this.auxIpc1Sn = auxIpc1Sn;
    }

    public String getAuxIpc2Sn() {
        return auxIpc2Sn;
    }

    public void setAuxIpc2Sn(String auxIpc2Sn) {
        this.auxIpc2Sn = auxIpc2Sn;
    }

    public String getSoftwareVer() {
        return softwareVer;
    }

    public void setSoftwareVer(String softwareVer) {
        this.softwareVer = softwareVer;
    }

    public String getIPCofflinelist() {
        return IPCofflinelist;
    }

    public void setIPCofflinelist(String IPCofflinelist) {
        this.IPCofflinelist = IPCofflinelist;
    }

    public Integer getCapDGon() {
        return capDGon;
    }

    public void setCapDGon(Integer capDGon) {
        this.capDGon = capDGon;
    }

    public Integer getBarriDGon() {
        return barriDGon;
    }

    public void setBarriDGon(Integer barriDGon) {
        this.barriDGon = barriDGon;
    }

    public Integer getBarriOpened() {
        return barriOpened;
    }

    public void setBarriOpened(Integer barriOpened) {
        this.barriOpened = barriOpened;
    }

    public Integer getCarInFlow() {
        return carInFlow;
    }

    public void setCarInFlow(Integer carInFlow) {
        this.carInFlow = carInFlow;
    }

    public Integer getAlarm() {
        return alarm;
    }

    public void setAlarm(Integer alarm) {
        this.alarm = alarm;
    }

    @Override
    public String toString() {
        return "MQTTHeartbeatResult{" +
                "parkId='" + parkId + '\'' +
                ", parkName='" + parkName + '\'' +
                ", laneId='" + laneId + '\'' +
                ", laneName='" + laneName + '\'' +
                ", inoutType=" + inoutType +
                ", ipcSn='" + ipcSn + '\'' +
                ", auxIpc1Sn='" + auxIpc1Sn + '\'' +
                ", auxIpc2Sn='" + auxIpc2Sn + '\'' +
                ", softwareVer='" + softwareVer + '\'' +
                ", IPCofflinelist='" + IPCofflinelist + '\'' +
                ", capDGon=" + capDGon +
                ", barriDGon=" + barriDGon +
                ", barriOpened=" + barriOpened +
                ", carInFlow=" + carInFlow +
                ", alarm=" + alarm +
                '}';
    }
}
