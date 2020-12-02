package com.ump.controller;

import com.ump.aspect.HttpLog;
import com.ump.entity.TDealLog;
import com.ump.service.TDealLogService;
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
* @Description: TDealLogController类
* @author 李书瀚
* @date 2020/03/31 16:54
*/
@RestController
@RequestMapping("/tDealLog")
public class TDealLogController {

    private  static final Logger logger= LoggerFactory.getLogger(TDealLogController.class);
    @Autowired
    private TDealLogService tDealLogService;
    /**
    * 查询信息
    * @paramtDealLog
    * @return
    */
    @PostMapping(value = "/getTDealLog")
    @HttpLog(operationType = "0",modularTypeName = "查询TDealLog")
    public ActionRsp getTDealLog(@RequestBody TDealLog tDealLog, HttpServletRequest request){
    return ActionRspUtil.Success(tDealLogService.getTDealLog(tDealLog));
    }
    /**
    * 查询信息(分页)
    * @paramtDealLog
    * @return
    */
    @PostMapping(value = "/getTDealLogbyPage")
    @HttpLog(operationType = "0",modularTypeName = "查询TDealLog(分页)")
    public ControllerRsp getTDealLogbyPage(@RequestBody TDealLog tDealLog,HttpServletRequest request,Integer page, Integer limit){
    return ControllerRspUtil.Success(tDealLogService.getTDealLogbyPage(tDealLog,page,limit));
    }
    /**
    * 更新信息
    * @paramtDealLog
    * @return
    */
    @PostMapping(value = "/updateTDealLog")
    @HttpLog(operationType = "1",modularTypeName = "更新TDealLog信息")
    public ActionRsp UpdateTDealLog(@RequestBody TDealLog tDealLog,HttpServletRequest request)
    {
        return ActionRspUtil.Success(tDealLogService. UpdateTDealLog(tDealLog));
    }

    /**
    * 删除信息
    * @param tDealLog
    * @return
    */
    @PostMapping(value = "/deleteTDealLog")
    @HttpLog(operationType = "1",modularTypeName = "删除TDealLog信息")
    public ActionRsp DeleteTDealLog(@RequestBody TDealLog tDealLog){
    return ActionRspUtil.Success(tDealLogService.DeleteTDealLog( tDealLog));
    }
}