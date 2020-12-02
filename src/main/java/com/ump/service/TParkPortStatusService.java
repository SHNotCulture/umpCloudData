package com.ump.service;

import com.ump.entity.MQTTResult.MQTTHeartbeatResult;
import com.ump.entity.TParkPortStatus;
import com.ump.util.PageBean;
import net.sf.json.JSONObject;

import java.util.List;

/**
* @Description: TParkPortStatusService接口
* @author 李书瀚
* @date 2020/03/31 16:54
*/
public interface TParkPortStatusService {
    PageBean<TParkPortStatus> getTParkPortStatusbyPage(TParkPortStatus tParkPortStatus, Integer page, Integer limit);
    List<TParkPortStatus> getTParkPortStatus(TParkPortStatus tParkPortStatus);
    String UpdateTParkPortStatus(TParkPortStatus tParkPortStatus);
    String DeleteTParkPortStatus(TParkPortStatus tParkPortStatus);
    TParkPortStatus getTParkPortStatusByID(Integer id);
    JSONObject getPortNum(Integer parkId);
    String setParkPortStatus(MQTTHeartbeatResult mqttHeartbeatResult);

}