package com.ump.service;

import com.ump.entity.TAlarmLevel;
import com.ump.util.PageBean;

import java.util.List;

/**
* @Description: TAlarmLevelService接口
* @author 李书瀚
* @date 2020/03/31 16:54
*/
public interface TAlarmLevelService {
    PageBean<TAlarmLevel> getTAlarmLevelbyPage(TAlarmLevel tAlarmLevel, Integer page, Integer limit);
    List<TAlarmLevel> getTAlarmLevel(TAlarmLevel tAlarmLevel);
    String UpdateTAlarmLevel(TAlarmLevel tAlarmLevel);
    String DeleteTAlarmLevel(TAlarmLevel tAlarmLevel);
    TAlarmLevel getTAlarmLevelByID(Integer id);

}