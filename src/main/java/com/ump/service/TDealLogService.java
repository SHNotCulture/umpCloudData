package com.ump.service;

import com.ump.entity.TDealLog;
import com.ump.util.PageBean;

import java.util.List;

/**
* @Description: TDealLogService接口
* @author 李书瀚
* @date 2020/03/31 16:54
*/
public interface TDealLogService {
    PageBean<TDealLog> getTDealLogbyPage(TDealLog tDealLog, Integer page, Integer limit);
    List<TDealLog> getTDealLog(TDealLog tDealLog);
    String UpdateTDealLog(TDealLog tDealLog);
    String DeleteTDealLog(TDealLog tDealLog);
    TDealLog getTDealLogByID(Integer id);

}