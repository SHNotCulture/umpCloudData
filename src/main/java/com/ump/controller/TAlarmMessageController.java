package com.ump.controller;

import com.ump.aspect.HttpLog;
import com.ump.entity.TAlarmMessage;
import com.ump.service.TAlarmMessageService;
import com.ump.util.ActionRsp;
import com.ump.util.ActionRspUtil;
import com.ump.util.ControllerRsp;
import com.ump.util.ControllerRspUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: TAlarmMessageController类
* @author 李书瀚
* @date 2020/03/31 16:54
*/
@RestController
@RequestMapping("/tAlarmMessage")
public class TAlarmMessageController {

    private  static final Logger logger= LoggerFactory.getLogger(TAlarmMessageController.class);
    @Autowired
    private TAlarmMessageService tAlarmMessageService;
    /**
    * 查询信息
    * @paramtAlarmMessage\\
    * @return
    */
    @PostMapping(value = "/getTAlarmMessage")
    @HttpLog(operationType = "0",modularTypeName = "查询TAlarmMessage")
    public ActionRsp getTAlarmMessage(@RequestBody TAlarmMessage tAlarmMessage, Integer flog, String parkIds){
    return ActionRspUtil.Success(tAlarmMessageService.getTAlarmMessage(tAlarmMessage,flog,parkIds));
    }
    /**
    * 查询信息(分页)
    * @paramtAlarmMessage
    * @return
    */
    @PostMapping(value = "/getTAlarmMessagebyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TAlarmMessage(分页)")
    public ControllerRsp getTAlarmMessagebyPage(@RequestBody TAlarmMessage tAlarmMessage, @RequestParam("flog")Integer flog, @RequestParam("page")Integer page, @RequestParam("limit")Integer limit, @RequestParam("parkIds")String parkIds){
    return ControllerRspUtil.Success(tAlarmMessageService.getTAlarmMessagebyPage(tAlarmMessage,flog,page,limit,parkIds));
    }
    /**
    * 更新信息
    * @paramtAlarmMessage
    * @return
    */
    @PostMapping(value = "/updateTAlarmMessage")
    @HttpLog(operationType = "1",modularTypeName = "更新TAlarmMessage信息")
    public ActionRsp UpdateTAlarmMessage(@RequestBody TAlarmMessage tAlarmMessage,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tAlarmMessageService.UpdateTAlarmMessage(tAlarmMessage));
    }

    /**
    * 删除信息
    * @param tAlarmMessage
    * @return
    */
    @PostMapping(value = "/deleteTAlarmMessage")
    @HttpLog(operationType = "1",modularTypeName = "删除TAlarmMessage信息")
    public ActionRsp DeleteTAlarmMessage(@RequestBody TAlarmMessage tAlarmMessage){
    return ActionRspUtil.Success(tAlarmMessageService.DeleteTAlarmMessage( tAlarmMessage));
    }
}