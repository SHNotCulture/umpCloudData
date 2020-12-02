package com.ump.controller;

import com.ump.aspect.HttpLog;
import com.ump.entity.TAlarmLevel;
import com.ump.service.TAlarmLevelService;
import com.ump.util.ActionRsp;
import com.ump.util.ActionRspUtil;
import com.ump.util.ControllerRsp;
import com.ump.util.ControllerRspUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: TAlarmLevelController类
* @author 李书瀚
* @date 2020/03/31 16:54
*/
@RestController
@RequestMapping("/tAlarmLevel")
public class TAlarmLevelController {

    private  static final Logger logger= LoggerFactory.getLogger(TAlarmLevelController.class);
    @Autowired
    private TAlarmLevelService tAlarmLevelService;
    /**
    * 查询信息
    * @paramtAlarmLevel
    * @return
    */
    @PostMapping(value = "/getTAlarmLevel")
    @HttpLog(operationType = "0",modularTypeName = "查询TAlarmLevel")
    public ActionRsp getTAlarmLevel(@RequestBody TAlarmLevel tAlarmLevel, HttpServletRequest request){
    return ActionRspUtil.Success(tAlarmLevelService.getTAlarmLevel(tAlarmLevel));
    }
    /**
    * 查询信息(分页)
    * @paramtAlarmLevel
    * @return
    */
    @PostMapping(value = "/getTAlarmLevelbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TAlarmLevel(分页)")
    public ControllerRsp getTAlarmLevelbyPage(@RequestBody TAlarmLevel tAlarmLevel,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tAlarmLevelService.getTAlarmLevelbyPage(tAlarmLevel,page,limit));
    }
    /**
    * 更新信息
    * @paramtAlarmLevel
    * @return
    */
    @PostMapping(value = "/updateTAlarmLevel")
    @HttpLog(operationType = "1",modularTypeName = "更新TAlarmLevel信息")
    public ActionRsp UpdateTAlarmLevel(@RequestBody TAlarmLevel tAlarmLevel,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tAlarmLevelService. UpdateTAlarmLevel(tAlarmLevel));
    }

    /**
    * 删除信息
    * @param tAlarmLevel
    * @return
    */
    @PostMapping(value = "/deleteTAlarmLevel")
    @HttpLog(operationType = "1",modularTypeName = "删除TAlarmLevel信息")
    public ActionRsp DeleteTAlarmLevel(@RequestBody TAlarmLevel tAlarmLevel){
    return ActionRspUtil.Success(tAlarmLevelService.DeleteTAlarmLevel( tAlarmLevel));
    }
}