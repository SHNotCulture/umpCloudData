package com.ump.controller;

import com.ump.aspect.HttpLog;
import com.ump.entity.MQTTResult.MQTTHeartbeatResult;
import com.ump.entity.TParkPortStatus;
import com.ump.service.TParkPortStatusService;
import com.ump.util.ActionRsp;
import com.ump.util.ActionRspUtil;
import com.ump.util.ControllerRsp;
import com.ump.util.ControllerRspUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: TParkPortStatusController类
* @author 李书瀚
* @date 2020/03/31 16:54
*/
@RestController
@RequestMapping("/tParkPortStatus")
public class TParkPortStatusController {

    private  static final Logger logger= LoggerFactory.getLogger(TParkPortStatusController.class);
    @Autowired
    private TParkPortStatusService tParkPortStatusService;
    /**
    * 查询信息
    * @paramtParkPortStatus
    * @return
    */
    @PostMapping(value = "/getTParkPortStatus")
    @HttpLog(operationType = "0",modularTypeName = "查询TParkPortStatus")
    public ActionRsp getTParkPortStatus(@RequestBody TParkPortStatus tParkPortStatus, HttpServletRequest request){
    return ActionRspUtil.Success(tParkPortStatusService.getTParkPortStatus(tParkPortStatus));
    }
    /**
    * 查询信息(分页)
    * @paramtParkPortStatus
    * @return
    */
    @PostMapping(value = "/getTParkPortStatusbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TParkPortStatus(分页)")
    public ControllerRsp getTParkPortStatusbyPage(@RequestBody TParkPortStatus tParkPortStatus,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tParkPortStatusService.getTParkPortStatusbyPage(tParkPortStatus,page,limit));
    }
    /**
    * 更新信息
    * @paramtParkPortStatus
    * @return
    */
    @PostMapping(value = "/updateTParkPortStatus")
    @HttpLog(operationType = "1",modularTypeName = "更新TParkPortStatus信息")
    public ActionRsp UpdateTParkPortStatus(@RequestBody TParkPortStatus tParkPortStatus,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tParkPortStatusService. UpdateTParkPortStatus(tParkPortStatus));
    }

    /**
    * 删除信息
    * @param tParkPortStatus
    * @return
    */
    @PostMapping(value = "/deleteTParkPortStatus")
    @HttpLog(operationType = "1",modularTypeName = "删除TParkPortStatus信息")
    public ActionRsp DeleteTParkPortStatus(@RequestBody TParkPortStatus tParkPortStatus){
    return ActionRspUtil.Success(tParkPortStatusService.DeleteTParkPortStatus( tParkPortStatus));
    }
    /**
     * 获取报警通道数量
     * @param parkId
     * @return
     */
    @PostMapping(value = "/getPortNum")
    @HttpLog(operationType = "0",modularTypeName = "获取报警通道数量")
    public JSONObject getPortNum(Integer parkId){
        return tParkPortStatusService.getPortNum(parkId);
    }
    /**
     * 获取岗亭报警信息
     * @param mqttHeartbeatResult
     * @return
     */
    @PostMapping(value = "/setParkPortStatus")
    @HttpLog(operationType = "0",modularTypeName = "获取岗亭报警信息")
    public String setParkPortStatus(@RequestBody MQTTHeartbeatResult mqttHeartbeatResult){
        return tParkPortStatusService.setParkPortStatus(mqttHeartbeatResult);
    }


}