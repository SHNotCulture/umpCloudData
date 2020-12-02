package com.ump.service.impl;

import com.github.pagehelper.PageHelper;
import com.ump.dao.TAlarmLevelMapper;
import com.ump.entity.TAlarmLevel;
import com.ump.entity.TAlarmLevelCriteria;
import com.ump.service.TAlarmLevelService;
import com.ump.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: TAlarmLevelService接口实现类
* @author 李书瀚
* @date 2020/03/31 16:54
*/
@Service
public class TAlarmLevelServiceImpl  implements TAlarmLevelService {

    private  static final Logger logger= LoggerFactory.getLogger( TAlarmLevelServiceImpl.class);
    @Autowired
    private TAlarmLevelMapper tAlarmLevelMapper;

    /**
    * 设置查询条件
    * @param tAlarmLevel
    * @return
    */
    private  TAlarmLevelCriteria setCriteria(TAlarmLevel tAlarmLevel){
        TAlarmLevelCriteria tAlarmLevelCriteria= new TAlarmLevelCriteria();
        if(tAlarmLevel!=null){
        TAlarmLevelCriteria.Criteria criteria=tAlarmLevelCriteria.createCriteria();
            if(tAlarmLevel.getId()!=null){
            criteria.andIdEqualTo(tAlarmLevel.getId());
            }
            if (tAlarmLevel.getLevel()!=null){
                criteria.andLevelEqualTo(tAlarmLevel.getLevel());
            }
            if (tAlarmLevel.getUrl()!=null && tAlarmLevel.getUrl()!=""){
                criteria.andUrlLike("%" + tAlarmLevel.getUrl() + "%");
            }
        }
        return  tAlarmLevelCriteria;
    }
    /**
    * 获取数据总量
    * @param tAlarmLevel
    * @return
    */
    private Integer getCount(TAlarmLevel tAlarmLevel){
    Integer total =(int)tAlarmLevelMapper.countByExample(setCriteria(tAlarmLevel));
    return total;
    }
    /**
    *查询(分页)tAlarmLevel
    * @param tAlarmLevel
    * @param page
    * @param limit
    * @return
    */
    public PageBean<TAlarmLevel> getTAlarmLevelbyPage(TAlarmLevel tAlarmLevel, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TAlarmLevel> tAlarmLevels=getTAlarmLevel(tAlarmLevel);
            Integer countNums =getCount(tAlarmLevel);
            PageBean<TAlarmLevel> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tAlarmLevels);
            return pageData;
        }
    /**
    * 查询tAlarmLevel
    * @param tAlarmLevel
    * @return
    */
    public List<TAlarmLevel> getTAlarmLevel(TAlarmLevel tAlarmLevel){
    List<TAlarmLevel>  tAlarmLevels=tAlarmLevelMapper.selectByExample(setCriteria(tAlarmLevel));
    return tAlarmLevels;
    }
    /**
    * 更新tAlarmLevel
    * @param tAlarmLevel
    * @return
    */
    public String UpdateTAlarmLevel(TAlarmLevel tAlarmLevel)
    {
            String msg="";
            try{
            if(tAlarmLevel.getId()!=null){
            tAlarmLevelMapper.updateByPrimaryKeySelective(tAlarmLevel);
                msg="更新TAlarmLevel成功";
            }
            else
            {
            tAlarmLevelMapper.insertSelective(tAlarmLevel);
                msg="新建TAlarmLevel成功";
            }
            }
            catch (Exception e)
            {

            }
            return msg;
    }
    /**
    * 删除tAlarmLevel
    * @param tAlarmLevel
    * @return
    */
    public String DeleteTAlarmLevel(TAlarmLevel tAlarmLevel){
            String msg="";
            if(tAlarmLevel.getId()!=null){
            tAlarmLevelMapper.deleteByPrimaryKey(tAlarmLevel.getId());
            msg="删除TAlarmLevel成功";
            }
            return msg;
    }

    /**
    * 根据ID查询tAlarmLevel
    * @param id
    * @return
    */
    public TAlarmLevel getTAlarmLevelByID(Integer id) {
        return  tAlarmLevelMapper.selectByPrimaryKey(id);
    }
}
