package com.ump.service.impl;

import com.github.pagehelper.PageHelper;
import com.ump.dao.TDealLogMapper;
import com.ump.entity.TDealLog;
import com.ump.entity.TDealLogCriteria;
import com.ump.service.TDealLogService;
import com.ump.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: TDealLogService接口实现类
* @author 李书瀚
* @date 2020/03/31 16:54
*/
@Service
public class TDealLogServiceImpl  implements TDealLogService {

    private  static final Logger logger= LoggerFactory.getLogger( TDealLogServiceImpl.class);
    @Autowired
    private TDealLogMapper tDealLogMapper;

    /**
    * 设置查询条件
    * @param tDealLog
    * @return
    */
    private  TDealLogCriteria setCriteria(TDealLog tDealLog){
        TDealLogCriteria tDealLogCriteria= new TDealLogCriteria();
        if(tDealLog!=null){
        TDealLogCriteria.Criteria criteria=tDealLogCriteria.createCriteria();
        if(tDealLog.getId()!=null){
        criteria.andIdEqualTo(tDealLog.getId());
        }

        }
        return  tDealLogCriteria;
    }
    /**
    * 获取数据总量
    * @param tDealLog
    * @return
    */
    private Integer getCount(TDealLog tDealLog){
    Integer total =(int)tDealLogMapper.countByExample(setCriteria(tDealLog));
    return total;
    }
    /**
    *查询(分页)tDealLog
    * @param tDealLog
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TDealLog> getTDealLogbyPage(TDealLog tDealLog, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TDealLog> TDealLogs=getTDealLog(tDealLog);
            Integer countNums =getCount(tDealLog);
            PageBean<TDealLog> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(TDealLogs);
            return pageData;
        }
    /**
    * 查询tDealLog
    * @param tDealLog
    * @return
    */
    public List<TDealLog> getTDealLog(TDealLog tDealLog){
    List<TDealLog>  TDealLogs=tDealLogMapper.selectByExample(setCriteria(tDealLog));
    return TDealLogs;
    }
    /**
    * 更新tDealLog
    * @param tDealLog
    * @return
    */
    public String UpdateTDealLog(TDealLog tDealLog)
    {
            String msg="";
            try{
            if(tDealLog.getId()!=null){
            tDealLogMapper.updateByPrimaryKeySelective(tDealLog);
                msg="更新TDealLog成功";
            }
            else
            {
            tDealLogMapper.insertSelective(tDealLog);
                msg="新建TDealLog成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }
    /**
    * 删除tDealLog
    * @param tDealLog
    * @return
    */
    public String DeleteTDealLog(TDealLog tDealLog){
            String msg="";
            if(tDealLog.getId()!=null){
            tDealLogMapper.deleteByPrimaryKey(tDealLog.getId());
            msg="删除TDealLog成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tDealLog
    * @param id
    * @return
    */
    public TDealLog getTDealLogByID(Integer id) {
        return  tDealLogMapper.selectByPrimaryKey(id);
    }
}
