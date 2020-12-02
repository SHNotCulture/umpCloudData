package com.ump.service.impl;

import com.github.pagehelper.PageHelper;
import com.ump.dao.TAlarmMessageMapper;
import com.ump.entity.TAlarmMessage;
import com.ump.entity.TAlarmMessageCriteria;
import com.ump.service.TAlarmMessageService;
import com.ump.util.DateUtil;
import com.ump.util.PageBean;
import com.ump.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: TAlarmMessageService接口实现类
* @author 李书瀚
* @date 2020/03/31 16:54
*/
@Service
public class TAlarmMessageServiceImpl  implements TAlarmMessageService {

    private  static final Logger logger= LoggerFactory.getLogger( TAlarmMessageServiceImpl.class);
    @Autowired
    private TAlarmMessageMapper tAlarmMessageMapper;

    /**
     * 设置未处理任务的查询条件
     * @param tAlarmMessage
     * @return
     */
    private TAlarmMessageCriteria  getTAlarmMessageCriteria (TAlarmMessage tAlarmMessage,String parkIds){
        //获取用户车场权限
        List<Integer> ids= StringUtil.stringList2List(parkIds.split(","));
        TAlarmMessageCriteria tAlarmMessageCriteria = new TAlarmMessageCriteria();
        TAlarmMessageCriteria.Criteria criteria = tAlarmMessageCriteria.createCriteria();
        if (tAlarmMessage!=null){
            if (tAlarmMessage.getParkId()!=null){
                criteria.andParkIdEqualTo(tAlarmMessage.getParkId());
            }
            criteria.andDealStatusEqualTo(0);
            criteria.andParkIdIn(ids);
        }
        return tAlarmMessageCriteria;
    }
    /**
     * 设置查询条件
     * @param tAlarmMessage
     * @return
     */
    private TAlarmMessageCriteria getmyTAlarmMessageCriteria (TAlarmMessage tAlarmMessage,String parkIds){
        List<Integer> ids= StringUtil.stringList2List(parkIds.split(","));
        TAlarmMessageCriteria tAlarmMessageCriteria = new TAlarmMessageCriteria();
        TAlarmMessageCriteria.Criteria criteria = tAlarmMessageCriteria.createCriteria();
        if (tAlarmMessage!=null){

            if (tAlarmMessage.getParkId()!=null){
                criteria.andParkIdEqualTo(tAlarmMessage.getParkId());
            }
            if (tAlarmMessage.getParkName()!=null && tAlarmMessage.getParkName()!=""){
                criteria.andParkNameLike("%" + tAlarmMessage.getParkName() + "%");
            }
            if (tAlarmMessage.getPortId()!=null){
                criteria.andPortIdEqualTo(tAlarmMessage.getPortId());
            }
            if (tAlarmMessage.getPortName()!=null && tAlarmMessage.getPortName()!=""){
                criteria.andPortNameLike("%" + tAlarmMessage.getPortName() + "%");
            }
            if (tAlarmMessage.getComputerName()!=null && tAlarmMessage.getComputerName()!=""){
                criteria.andComputerNameLike("%" + tAlarmMessage.getComputerName() + "%");
            }
            if (tAlarmMessage.getOnlineStatus()!=null){
                criteria.andOnlineStatusEqualTo(tAlarmMessage.getOnlineStatus());
            }
            if (tAlarmMessage.getCarinFlow()!=null && tAlarmMessage.getCarinFlow()!=""){
                criteria.andCarinFlowLike("%" + tAlarmMessage.getCarinFlow() + "%");
            }
            if (tAlarmMessage.getGroudSensorCamera()!=null){
                criteria.andGroudSensorCameraEqualTo(tAlarmMessage.getGroudSensorCamera());
            }
            if (tAlarmMessage.getGroudSensorBanister()!=null){
                criteria.andGroudSensorBanisterEqualTo(tAlarmMessage.getGroudSensorBanister());
            }
            if (tAlarmMessage.getCameraStaus()!=null){
                criteria.andCameraStausEqualTo(tAlarmMessage.getCameraStaus());
            }
            if (tAlarmMessage.getBanisterStatus()!=null){
                criteria.andBanisterStatusEqualTo(tAlarmMessage.getBanisterStatus());
            }
            if (tAlarmMessage.getAlarmStatus()!=null){
                criteria.andAlarmStatusEqualTo(tAlarmMessage.getAlarmStatus());
            }
            if (tAlarmMessage.getAlarmLevel()!=null){
                criteria.andAlarmLevelEqualTo(tAlarmMessage.getAlarmLevel());
            }
            if (tAlarmMessage.getAlarmTime()!=null && tAlarmMessage.getAlarmTime()!=""){
                criteria.andAlarmTimeLike("%" + tAlarmMessage.getAlarmTime() + "%");
            }
            if (tAlarmMessage.getDealStatus()!=null){
                criteria.andDealStatusEqualTo(tAlarmMessage.getDealStatus());
            }
            if (tAlarmMessage.getUserId()!=null){
                criteria.andUserIdEqualTo(tAlarmMessage.getUserId());
            }
            if (tAlarmMessage.getUserName()!=null && tAlarmMessage.getUserName()!=""){
                criteria.andUserNameEqualTo(tAlarmMessage.getUserName());
            }
            if (tAlarmMessage.getCreateTime()!=null && tAlarmMessage.getCreateTime()!=""){
                criteria.andCreateTimeLike("%" + tAlarmMessage.getCreateTime() + "%");
            }
            criteria.andParkIdIn(ids);
        }
        return tAlarmMessageCriteria;
    }
    /**
    * 获取数据总量
    * @param tAlarmMessage
    * @return
    */
    private Integer getCount(TAlarmMessage tAlarmMessage,Integer flog,String parkIds){
        Integer total=0;
        if(flog.equals(0)){
            total = (int)tAlarmMessageMapper.countByExample(getTAlarmMessageCriteria(tAlarmMessage,parkIds));
        }
        else if(flog.equals(1)){
            total = (int)tAlarmMessageMapper.countByExample(getmyTAlarmMessageCriteria(tAlarmMessage,parkIds));
        }
    return total;
    }
    /**
    *查询(分页)tAlarmMessage
    * @param tAlarmMessage
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TAlarmMessage> getTAlarmMessagebyPage(TAlarmMessage tAlarmMessage, Integer flog,Integer page, Integer limit,String parkIds){
        PageHelper.startPage(page, limit,"id desc");
        List<TAlarmMessage> tAlarmMessageLists =getTAlarmMessage(tAlarmMessage,flog,parkIds);
        Integer countNums =getCount(tAlarmMessage,flog,parkIds);
        PageBean<TAlarmMessage> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tAlarmMessageLists);
            return pageData;
        }
    /**
    * 查询tAlarmMessage
    * @param tAlarmMessage
    * @return
    */
    public List<TAlarmMessage> getTAlarmMessage(TAlarmMessage tAlarmMessage,Integer flog,String parkIds){
        List<TAlarmMessage> tAlarmMessages=null;
        if(flog.equals(0)){
            tAlarmMessages = tAlarmMessageMapper.selectByExample(getTAlarmMessageCriteria(tAlarmMessage,parkIds));
        }
        else if(flog.equals(1)){
            tAlarmMessages = tAlarmMessageMapper.selectByExample(getmyTAlarmMessageCriteria(tAlarmMessage,parkIds));
        }
        return tAlarmMessages;
    }
    /**
    * 更新tAlarmMessage
    * @param tAlarmMessage
    * @return
    */
    public String UpdateTAlarmMessage(TAlarmMessage tAlarmMessage)
    {
            String msg="";
            try{
            if(tAlarmMessage.getId()!=null){
                tAlarmMessage.setCreateTime(DateUtil.getCurDateTime());
            tAlarmMessageMapper.updateByPrimaryKeySelective(tAlarmMessage);
                msg="更新TAlarmMessage成功";
            }
            else
            {
            tAlarmMessageMapper.insertSelective(tAlarmMessage);
                msg="新建TAlarmMessage成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }
    /**
    * 删除tAlarmMessage
    * @param tAlarmMessage
    * @return
    */
    public String DeleteTAlarmMessage(TAlarmMessage tAlarmMessage){
            String msg="";
            if(tAlarmMessage.getId()!=null){
            tAlarmMessageMapper.deleteByPrimaryKey(tAlarmMessage.getId());
            msg="删除TAlarmMessage成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tAlarmMessage
    * @param id
    * @return
    */
    public TAlarmMessage getTAlarmMessageByID(Integer id) {
        return  tAlarmMessageMapper.selectByPrimaryKey(id);
    }
}
