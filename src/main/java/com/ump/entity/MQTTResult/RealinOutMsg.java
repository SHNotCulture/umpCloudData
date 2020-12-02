package com.ump.entity.MQTTResult;

public class RealinOutMsg {
    private String laneId;
    private String msgNo;
    private String msg;

    public String getLaneId() {
        return laneId;
    }

    public void setLaneId(String laneId) {
        this.laneId = laneId;
    }

    public String getMsgNo() {
        return msgNo;
    }

    public void setMsgNo(String msgNo) {
        this.msgNo = msgNo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RealinOutMsg{" +
                "laneId='" + laneId + '\'' +
                ", msgNo='" + msgNo + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
