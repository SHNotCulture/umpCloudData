package com.ump.aspect;

import com.ump.dao.*;
import com.ump.entity.*;
import com.ump.service.*;
import com.ump.util.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author lishuhan
 * @Description:Http请求监听
 * @Date Create in 11:402018-5-9
 * @Modified By:
 */
@Aspect
@Component
public class HttpAspect {
    private  static final Logger logger= LoggerFactory.getLogger(HttpAspect.class);
  /*  @Autowired
    private DealLogService dealLogService;*/
  /*  @Autowired
    private JournalService journalService;
    @Autowired
    private BlackListService blackListService;
    @Autowired
    private BusineService busineService;
    @Autowired
    private CarPayRuleService carPayRuleService;
    @Autowired
    private TruckSpaceService truckSpaceService;
    @Autowired
    private RolePowerService rolePowerService;
    @Autowired
    private UserService userService;*/

    private String logMsg;
    @Pointcut("execution(public * com.ump.controller.work.*.*(..))")
    private  void mainAction(){
    }
    @Before("mainAction()")
    public void dobefore(JoinPoint joinPoint)throws ClassNotFoundException {
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logMsg=getLogInfo(joinPoint).get("logInfo");
    }

    @After("mainAction()")
    public void doAfter(JoinPoint joinPoint) throws ClassNotFoundException {
         ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr().toString();
                Map<String, String> map = getLogInfo(joinPoint);
                String operationType=map.get("operationType");
                String logInfo=logMsg;
                if (Integer.valueOf(operationType)!=0) {
                   /* TCompanyUser user = SessionUtil.getUser();
                    TDealLog tDealLog=new TDealLog();
                    tDealLog.setUserId(user.getId());
                    tDealLog.setUserName(user.getUserName());
                    tDealLog.setDealType(2);
                    tDealLog.setDealContent(logInfo);
                    tDealLog.setCreateTime(DateUtil.getCurDateTime());
                    dealLogService.updateDealLog(tDealLog);*/
                }
        logger.info("访问结束");
    }

    @AfterReturning(returning = "object",pointcut = "mainAction()")
    public void doAfterReturn(Object object){
        //返回数据
        logger.info("response={}",object.toString());
    }

    private Map<String, String> getLogInfo(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        Object[] arguments = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        String modulerType="";
        String operationType="";
        String logInfo="";
        if (methods.length>0) {
            for (Method method : methods){
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        if (method.getAnnotation(HttpLog.class) != null) {
                            modulerType = method.getAnnotation(HttpLog.class).modularTypeName();
                            operationType = method.getAnnotation(HttpLog.class).operationType();
                            break;
                        }
                    }
                }}
        }
        if(modulerType!=""&&operationType!="")
        {
            if(Integer.valueOf(operationType)!=0){
                logger.info("开始记录日志,modulerType="+modulerType+",operationType="+operationType);
                Object argOne=arguments[0];
               /* TCompanyUser user = SessionUtil.getUser();
                switch (modulerType){
                    case "更新报警工单信息":
                        if(argOne instanceof TAlarmMessage){
                            TAlarmMessage tAlarmMessage=(TAlarmMessage)argOne;
                            logInfo= String.format("用户【%s】更新了报警工单信息，当前状态：【%s】",user.getUserName(),tAlarmMessage.getDealStatus());
                        }
                        break;
                    case "转移坐席":
                        if(argOne instanceof TAlarmMessage){
                            TAlarmMessage tAlarmMessage=(TAlarmMessage)argOne;
                            logInfo= String.format("用户【%s】转移坐席至【%s】，当前状态：【%s】",user.getUserName(),tAlarmMessage.getUserName(),tAlarmMessage.getDealStatus());
                        }
                        break;
                    case "申请连接/断开线下系统":
                        if(argOne instanceof String) {
                            String laneId=(String)argOne;
                            Object argTwo=arguments[1];
                            Integer flag=(Integer)argTwo;
                            switch (flag){
                                case 1:
                                    logInfo = String.format("用户【%s】申请连接通道：【%s】", user.getUserName(), laneId);
                                    break;
                                case 0:
                                    logInfo = String.format("用户【%s】申请断开通道：【%s】", user.getUserName(), laneId);
                                    break;
                                    default:
                                        break;
                            }

                        }
                        break;
                    case "通道抓拍":
                        if(argOne instanceof String) {
                            String laneId=(String)argOne;
                            logInfo = String.format("用户【%s】抓拍，当前通道：【%s】", user.getUserName(), laneId);
                        }
                        break;

                    case "出场时人工匹配入场车牌":
                        if(argOne instanceof Integer) {
                            Integer parkId = (Integer)argOne;
                            Object argTwo=arguments[1];
                            String laneId=(String)argTwo;
                            Object argThree = arguments[2];
                            String orderId = (String)argThree;
                            logInfo = String.format("用户【%s】出场时人工匹配入场车牌，当前通道：【%s】，流水号：【%s】", user.getUserName(), laneId, orderId);
                        }
                    break;

                    case "出场时人工修改出场车牌":
                        if(argOne instanceof Integer) {
                            Integer parkId = (Integer)argOne;
                            Object argTwo=arguments[1];
                            String laneId=(String)argTwo;
                            Object argThree = arguments[2];
                            String newOutCarplate = (String)argThree;
                            logInfo = String.format("用户【%s】出场时人工修改出场车牌，当前通道：【%s】，修改车牌：【%s】", user.getUserName(), laneId, newOutCarplate);
                        }
                        break;

                    case "入场开闸放行":
                        if(argOne instanceof Integer) {
                            Integer parkId = (Integer)argOne;
                            Object argTwo=arguments[1];
                            String laneId=(String)argTwo;
                            logInfo = String.format("用户【%s】入场开闸放行，当前通道：【%s】", user.getUserName(), laneId);
                        }
                        break;

                    case "取消入场":
                        if(argOne instanceof Integer) {
                            Integer parkId = (Integer)argOne;
                            Object argTwo=arguments[1];
                            String laneId=(String)argTwo;
                            logInfo = String.format("用户【%s】取消入场，当前通道：【%s】", user.getUserName(), laneId);
                        }
                        break;

                    case "出场放行":
                        if(argOne instanceof Integer) {
                            Integer parkId = (Integer)argOne;
                            Object argTwo=arguments[1];
                            String laneId=(String)argTwo;
                            Object argThree=arguments[3];
                            Double payAmout = (Double)argThree;
                            logInfo = String.format("用户【%s】出场放行，当前通道：【%s】，缴费金额：【%s】", user.getUserName(), laneId, payAmout);
                        }
                        break;

                    case "取消出场":
                        if(argOne instanceof Integer) {
                            Integer parkId = (Integer)argOne;
                            Object argTwo=arguments[1];
                            String laneId=(String)argTwo;
                            logInfo = String.format("用户【%s】取消出场，当前通道：【%s】", user.getUserName(), laneId);
                        }
                        break;
                    default:
                        break;
                }*/
                }
                }
        Map<String, String> map = new HashMap<String, String>(2);
        map.put("logInfo",logInfo);
        map.put("operationType",operationType);
      return map;
    }

    public String getMsgInfo(Object obPar, Object ob, String[] ignore){
        Map<String, List<Object>> compareResult = CompareFields.compareFields(obPar,ob,ignore);
        Set<String> keySet = compareResult.keySet();
        StringBuffer msg = new StringBuffer();
        for(String key : keySet){
            List<Object> list = compareResult.get(key);
            msg.append(key+"【"+list.get(1)+"】");
        }
        return msg.toString();
    }
}
