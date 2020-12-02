package com.ump.util;

import javax.validation.constraints.NotNull;

/**
 * @Author lishuhan
 * @Date Create in 10:542018-5-4
 * @Modified By:
 */
public class ActionReq {
    @NotNull(message = "方法必填")
    private String service;
    private Object data;
    @NotNull(message = "车场id必填")
    private Integer parkId;
    @NotNull(message = "必填，PAI密钥")
    private String key;
    @NotNull(message = "第三方接入ID（车易泊提供）")
    private String ID;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "ActionReq{" +
                "service='" + service + '\'' +
                ", data=" + data +
                ", parkId=" + parkId +
                ", key='" + key + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }

}
