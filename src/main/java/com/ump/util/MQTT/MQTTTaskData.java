package com.ump.util.MQTT;

public class MQTTTaskData {
    private String topic;           //订阅指向发送地址
    private String task_sn; 		// 任务sn，日期精确到毫秒
    private String task_type; 	// 任务名称
    private String data; 			// 数据，json格式

    public String getTask_sn() {
        return task_sn;
    }

    public void setTask_sn(String task_sn) {
        this.task_sn = task_sn;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "MQTTTaskData{" +
                "task_sn='" + task_sn + '\'' +
                ", task_type='" + task_type + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
