package com.ump.service.impl;

import com.github.pagehelper.PageHelper;
import com.ump.dao.TParkPortStatusMapper;
import com.ump.entity.MQTTResult.MQTTHeartbeatResult;
import com.ump.entity.TAlarmMessage;
import com.ump.entity.TParkPortStatus;
import com.ump.entity.TParkPortStatusCriteria;
import com.ump.service.TAlarmMessageService;
import com.ump.service.TParkPortStatusService;
import com.ump.util.BeanCopyUtil;
import com.ump.util.DateUtil;
import com.ump.util.PageBean;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: TParkPortStatusService接口实现类
* @author 李书瀚
* @date 2020/03/31 16:54
*/
@Service
public class TParkPortStatusServiceImpl  implements TParkPortStatusService {

    private  static final Logger logger= LoggerFactory.getLogger( TParkPortStatusServiceImpl.class);
    @Autowired
    private TParkPortStatusMapper tParkPortStatusMapper;
    @Autowired
    private TAlarmMessageService alarmMessageService;
    /**
    * 设置查询条件
    * @param tParkPortStatus
    * @return
    */
    private  TParkPortStatusCriteria setCriteria(TParkPortStatus tParkPortStatus){
        TParkPortStatusCriteria tParkPortStatusCriteria = new TParkPortStatusCriteria();
        TParkPortStatusCriteria.Criteria criteria = tParkPortStatusCriteria.createCriteria();
        if (tParkPortStatus!=null){

            if (tParkPortStatus.getParkId()!=null){
                criteria.andParkIdEqualTo(tParkPortStatus.getParkId());
            }
            if (tParkPortStatus.getParkName()!=null && tParkPortStatus.getParkName()!=""){
                criteria.andParkNameLike("%" + tParkPortStatus.getParkName() + "%");
            }
            if (tParkPortStatus.getPortId()!=null){
                criteria.andPortIdEqualTo(tParkPortStatus.getPortId());
            }
            if (tParkPortStatus.getPortName()!=null && tParkPortStatus.getPortName()!=""){
                criteria.andPortNameLike("%" + tParkPortStatus.getPortName() + "%");
            }
            if (tParkPortStatus.getComputerName()!=null && tParkPortStatus.getComputerName()!=""){
                criteria.andComputerNameLike("%" + tParkPortStatus.getComputerName() + "%");
            }
            if (tParkPortStatus.getIdAddress()!=null && tParkPortStatus.getIdAddress()!=""){
                criteria.andIdAddressLike("%" + tParkPortStatus.getIdAddress() + "%");
            }
            if (tParkPortStatus.getOnlineStatus()!=null){
                criteria.andOnlineStatusEqualTo(tParkPortStatus.getOnlineStatus());
            }
            if (tParkPortStatus.getCarinFlow()!=null && tParkPortStatus.getCarinFlow()!=""){
                criteria.andCarinFlowLike("%" + tParkPortStatus.getCarinFlow() + "%");
            }
            if (tParkPortStatus.getGroudSensorCamera()!=null){
                criteria.andGroudSensorCameraEqualTo(tParkPortStatus.getGroudSensorCamera());
            }
            if (tParkPortStatus.getGroudSensorBanister()!=null){
                criteria.andGroudSensorBanisterEqualTo(tParkPortStatus.getGroudSensorBanister());
            }
            if (tParkPortStatus.getCameraStaus()!=null){
                criteria.andCameraStausEqualTo(tParkPortStatus.getCameraStaus());
            }
            if (tParkPortStatus.getBanisterStatus()!=null){
                criteria.andBanisterStatusEqualTo(tParkPortStatus.getBanisterStatus());
            }
            if (tParkPortStatus.getAlarmStatus()!=null){
                criteria.andAlarmStatusEqualTo(tParkPortStatus.getAlarmStatus());
            }
            if (tParkPortStatus.getCameraCarplate()!=null && tParkPortStatus.getCameraCarplate()!=""){
                criteria.andCameraCarplateLike("%" + tParkPortStatus.getCameraCarplate() + "%");
            }
            if (tParkPortStatus.getCameraUrl()!=null && tParkPortStatus.getCameraUrl()!=""){
                criteria.andCameraUrlLike("%" + tParkPortStatus.getCameraUrl() + "%");
            }
        }
        return  tParkPortStatusCriteria;
    }
    /**
    * 获取数据总量
    * @param tParkPortStatus
    * @return
    */
    private Integer getCount(TParkPortStatus tParkPortStatus){
    Integer total =(int)tParkPortStatusMapper.countByExample(setCriteria(tParkPortStatus));
    return total;
    }
    /**
    *查询(分页)tParkPortStatus
    * @param tParkPortStatus
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TParkPortStatus> getTParkPortStatusbyPage(TParkPortStatus tParkPortStatus, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TParkPortStatus> TParkPortStatuss=getTParkPortStatus(tParkPortStatus);
            Integer countNums =getCount(tParkPortStatus);
            PageBean<TParkPortStatus> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(TParkPortStatuss);
            return pageData;
        }
    /**
    * 查询tParkPortStatus
    * @param tParkPortStatus
    * @return
    */
    public List<TParkPortStatus> getTParkPortStatus(TParkPortStatus tParkPortStatus){
    List<TParkPortStatus>  TParkPortStatuss=tParkPortStatusMapper.selectByExample(setCriteria(tParkPortStatus));
    return TParkPortStatuss;
    }
    /**
    * 更新tParkPortStatus
    * @param tParkPortStatus
    * @return
    */
    public String UpdateTParkPortStatus(TParkPortStatus tParkPortStatus)
    {
            String msg="";
            try{
            if(tParkPortStatus.getId()!=null){
            tParkPortStatusMapper.updateByPrimaryKeySelective(tParkPortStatus);
                msg="更新TParkPortStatus成功";
            }
            else
            {
            tParkPortStatusMapper.insertSelective(tParkPortStatus);
                msg="新建TParkPortStatus成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }
    /**
    * 删除tParkPortStatus
    * @param tParkPortStatus
    * @return
    */
    public String DeleteTParkPortStatus(TParkPortStatus tParkPortStatus){
            String msg="";
            if(tParkPortStatus.getId()!=null){
            tParkPortStatusMapper.deleteByPrimaryKey(tParkPortStatus.getId());
            msg="删除TParkPortStatus成功";
            }
            return msg;
    }
    /**
    * 根据ID查询tParkPortStatus
    * @param id
    * @return
    */
    public TParkPortStatus getTParkPortStatusByID(Integer id) {
        return  tParkPortStatusMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取岗亭报警信息
     * @param mqttHeartbeatResult
     * @return
     */
    public  String setParkPortStatus(MQTTHeartbeatResult mqttHeartbeatResult){

        try {
            logger.info("获取到通道实时状态："+mqttHeartbeatResult.toString());
            TParkPortStatus tParkPortStatus=new TParkPortStatus();
            tParkPortStatus.setParkId(Integer.valueOf(mqttHeartbeatResult.getParkId()));
            tParkPortStatus.setParkName(mqttHeartbeatResult.getParkName());
            tParkPortStatus.setPortId(mqttHeartbeatResult.getLaneId());
            tParkPortStatus.setPortName(mqttHeartbeatResult.getLaneName());
            tParkPortStatus.setInouttype(mqttHeartbeatResult.getInoutType());
            tParkPortStatus.setIpcsn(mqttHeartbeatResult.getIpcSn());
            tParkPortStatus.setAuxipc1sn(mqttHeartbeatResult.getAuxIpc1Sn());
            tParkPortStatus.setAuxipc2sn(mqttHeartbeatResult.getAuxIpc2Sn());
            tParkPortStatus.setSoftwarever(mqttHeartbeatResult.getSoftwareVer());
            tParkPortStatus.setIpcofflinelist(mqttHeartbeatResult.getIPCofflinelist());
            tParkPortStatus.setGroudSensorCamera(mqttHeartbeatResult.getCapDGon());
            tParkPortStatus.setGroudSensorBanister(mqttHeartbeatResult.getBarriDGon());
            tParkPortStatus.setCarinFlow(mqttHeartbeatResult.getCarInFlow().toString());
            tParkPortStatus.setAlarmStatus(mqttHeartbeatResult.getAlarm());
            if(mqttHeartbeatResult.getAlarm().equals(1)){
                tParkPortStatus.setLaneStatus(1);//车主求助
            }
            if(mqttHeartbeatResult.getCapDGon()>=180){
                tParkPortStatus.setLaneStatus(2);//抓拍地感停车超过3分钟
            }
            if(mqttHeartbeatResult.getBarriDGon()>=180){
                tParkPortStatus.setLaneStatus(3);//道闸地感停车超过3分钟
            }
            if(mqttHeartbeatResult.getCarInFlow()>=180){
                tParkPortStatus.setLaneStatus(4);//有流程未处理超过3分钟
            }
            logger.info("解析为："+tParkPortStatus.toString());
            TParkPortStatus tParkPortStatusSel=new TParkPortStatus();
            tParkPortStatusSel.setPortId(mqttHeartbeatResult.getLaneId());
            //查询该通道信息是否已经存在
            if(getTParkPortStatus(tParkPortStatusSel).size()==1){
                //按照通道相机主序列号更新通道信息
                tParkPortStatusMapper.updateByExampleSelective(tParkPortStatus,setCriteria(tParkPortStatusSel));
            }
            else {
                UpdateTParkPortStatus(tParkPortStatus);
            }
            logger.info("更改通道实时状态");

            //添加报警事件
            TAlarmMessage  tAlarmMessage=new TAlarmMessage();
            BeanCopyUtil.CopyBeanToBean(tParkPortStatus,tAlarmMessage);
            tAlarmMessage.setDealStatus(0);
            tAlarmMessage.setAlarmLevel(tParkPortStatus.getLaneStatus());
            tAlarmMessage.setAlarmTime(DateUtil.getCurDateTime());
            alarmMessageService.UpdateTAlarmMessage(tAlarmMessage);
           /* //获取已经上线的webSocket 用户列表
            Iterator<TCompanyUser> it=mqttServerService.allValues().iterator();
            while (it.hasNext()){
                TCompanyUser user=it.next();
                logger.info(user.toString());
                Map map=new HashMap();
                map.put("user",user.getUserName());
                map.put("url","main");
                //向相应页面发送报警信息
                mqttServerService.sendInfo("0",JsonUtil.mapToJson(map));
            }*/


        }
        catch (Exception e){
            logger.info(e.toString());
        }
        return "更新通道信息成功";
    }

    public JSONObject getPortNum(Integer parkId){
        TParkPortStatusCriteria tParkPortStatusCriteria = new TParkPortStatusCriteria();
        TParkPortStatusCriteria.Criteria criteria = tParkPortStatusCriteria.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        criteria.andLaneStatusEqualTo(0);
        Integer SuccessNum = (int)tParkPortStatusMapper.countByExample(tParkPortStatusCriteria);
        tParkPortStatusCriteria = new TParkPortStatusCriteria();
        criteria = tParkPortStatusCriteria.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        criteria.andLaneStatusNotEqualTo(0);
        Integer FailNum = (int)tParkPortStatusMapper.countByExample(tParkPortStatusCriteria);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("SuccessNum",SuccessNum);
        jsonObject.put("FailNum",FailNum);
        jsonObject.put("parkId",parkId);
        return  jsonObject;

    }
}
