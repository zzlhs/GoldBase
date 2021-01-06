package com.zzl.es.quartz;

import org.apache.log4j.Logger;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.zzl.es.service.ServiceImpl;

/**
 * @author lvgo
 * @version 1.0
 * @package com.erayt.xsds.common.schedule.batch
 * @description: xsds job 类
 * @date 2019/9/19 10:06
 */
@Component
public class XsdsJob extends QuartzJobBean {

    private Logger logger = Logger.getLogger(XsdsJob.class);
    private Logger loggerBatch = Logger.getLogger(XsdsJob.class);

    /**
     * 任务名称
     */
    @Value("${XSDS_JOB}")  // 这里读取的是配置文件, 有需要自行调整
    private String jobName;
    /**
     * 任务组名称
     */
    @Value("${JOB_GROUP_NAME}") // 这里读取的是配置文件, 有需要自行调整
    private String jobGroupName;

    public String getJobName() {
        return jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }
    
    @Autowired
    private ServiceImpl serviceImpl;

    @Override
    protected void executeInternal(JobExecutionContext currentJob) throws JobExecutionException {
//        QueryEngineImpl queryEngine = null;
//        SysParamService sysParamService = null;
//        FinancialOverNight financialOverNight = null;
        try {
            XmlWebApplicationContext context = (XmlWebApplicationContext) currentJob
                    .getScheduler().getContext().get("applicationContextKey");
            
            currentJob.getScheduler().getContext().get("");
            
//            queryEngine = (QueryEngineImpl) context.getBean("queryEngine");
//            sysParamService = (SysParamService) context.getBean("sysParamService");
//            financialOverNight = (FinancialOverNight) context.getBean("financialOverNight");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        CronTriggerImpl trigger = (CronTriggerImpl) currentJob.getTrigger();
        logger.info("任务调度执行计划【" + trigger.getName() + "】已启动");
        JobDataMap jobDataMap = trigger.getJobDataMap();
        Integer type = (Integer) jobDataMap.get("type");
        logger.info("当前执行任务type:" + type);
        switch (type) {
            case 1000:
               System.out.println("测试任务正常执行");
                break;
            case 1001:
            	serviceImpl.test();
            	
                break;
            default:
                break;
        }
        logger.info("任务调度执行计划【" + trigger.getName() + "】已结束");
    }

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}
}

