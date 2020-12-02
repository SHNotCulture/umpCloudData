package com.ump.service;

import com.ump.entity.TAlarmMessage;
import com.ump.util.PageBean;

import java.util.List;

/**
* @Description: TAlarmMessageService接口
* @author 李书瀚
* @date 2020/03/31 16:54
*/
public interface TAlarmMessageService {
    PageBean<TAlarmMessage> getTAlarmMessagebyPage(TAlarmMessage tAlarmMessage,Integer flog,Integer page, Integer limit,String parkIds);
    List<TAlarmMessage> getTAlarmMessage(TAlarmMessage tAlarmMessage,Integer flog,String parkIds);
    String UpdateTAlarmMessage(TAlarmMessage tAlarmMessage);
    String DeleteTAlarmMessage(TAlarmMessage tAlarmMessage);
    TAlarmMessage getTAlarmMessageByID(Integer id);

}