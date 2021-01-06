package com.zzl.es.quartz;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author lvgo
 * @version 1.0
 * @package com.erayt.xsds.common.schedule.service
 * @description: 定时任务调度管理
 * @date 2019/9/18 16:00
 */
@Service
public class ScheduleService {

	public static final String TRG_BATCHTODAY = "当日晚间批处理任务";
	public static final String TRG_SYSBATCH = "系统隔夜批处理任务";
	public static final String TRG_SYSONLINEBATCH = "系统联机隔夜批处理任务";

	private static Logger logger = Logger.getLogger(ScheduleService.class);
	@Value("${TRG_GROUP_NAME}")
	public String triggerGroupName = "TRIGGER_GROUP_SYSTEM";
	@Resource
	private XsdsJob xsdsJob;

//    @Resource
//    private SchedulerFactoryBean scheduler = new SchedulerFactoryBean().getScheduler();

	@Resource
	private Scheduler scheduler; // = new SchedulerFactoryBean().getScheduler();

	public void setDemoSchedule() {

//        Scheduler scheduler = new SchedulerFactoryBean().getScheduler();

		String cron = "* * * * * *";

		cron = "0 * * * * *";
		cron = "0/5 * * * * ?";
		addTrigger(getXsdsJobTrigger("这是一个测试任务", cron, "type", 1000));
	}

	/**
	 * 创建一个xsds任务
	 */
	public void createXsdsJob() {
		JobDetail jobDetail = JobBuilder.newJob(xsdsJob.getClass()).storeDurably().requestRecovery()
				.withIdentity(xsdsJob.getJobName(), xsdsJob.getJobGroupName()).build();
		try {
			scheduler.addJob(jobDetail, true);
		} catch (SchedulerException e) {
			logger.error("增加XSDS基本任务异常", e);
		}
	}

	/**
	 * 获取一个XSDS任务触发器对象
	 *
	 * @param name 创建的任务名称
	 * @param cron 任务执行时间
	 * @return 任务执行触发器
	 */
	public XsdsJobTrigger getXsdsJobTrigger(String name, String cron) {
		return new XsdsJobTrigger.Builder().jobGroupName(xsdsJob.getJobGroupName()).jobName(xsdsJob.getJobName())
				.triggerGroupName(triggerGroupName).triggerName(name).cron(cron);
	}

	public XsdsJobTrigger getXsdsJobTrigger(String name, String cron, String paramKey, Object paramValue) {
		return new XsdsJobTrigger.Builder().jobGroupName(xsdsJob.getJobGroupName()).jobName(xsdsJob.getJobName())
				.triggerGroupName(triggerGroupName).triggerName(name).cron(cron).params(paramKey, paramValue);
	}

	public XsdsJobTrigger getXsdsJobTrigger(XsdsJob job, String triggerName, String triggerGroupName) {
		return new XsdsJobTrigger.Builder().jobGroupName(job.getJobGroupName()).jobName(job.getJobName())
				.triggerGroupName(triggerGroupName).triggerName(triggerName);
	}

	/**
	 * 增加一个任务执行触发器
	 *
	 * @param trigger 任务执行触发器
	 */
	public void addTrigger(AbstractTrigger trigger) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(trigger.getTriggerName(), trigger.getTriggerGroupName());
			if (scheduler.getTrigger(triggerKey) != null) {
				logger.error("当前任务【" + trigger.getTriggerName() + "】已存在, 无法覆盖创建任务调度计划");
				return;
			}
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			triggerBuilder.usingJobData(trigger.getParam());
			triggerBuilder.withIdentity(trigger.getTriggerName(), trigger.getTriggerGroupName());
			triggerBuilder.startNow();
			triggerBuilder.withSchedule(
					CronScheduleBuilder.cronSchedule(trigger.getCron()).withMisfireHandlingInstructionDoNothing());
			triggerBuilder.forJob(trigger.getJobName(), trigger.getJobGroupName());
			CronTrigger cronTrigger = (CronTrigger) triggerBuilder.build();
			scheduler.scheduleJob(cronTrigger);
			if (!scheduler.isShutdown()) {
				scheduler.start();
				logger.info("【" + trigger.getTriggerName() + "】任务调度计划启动成功!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改一个任务的触发时间
	 *
	 * @param xsdsJob xsds任务类 提供触发器组, 触发器名称, 修改后的cron表达式
	 */
	public void modifyJobTime(AbstractTrigger xsdsJob) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(xsdsJob.getTriggerName(), xsdsJob.getTriggerGroupName());
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if (trigger == null) {
				return;
			}
			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(xsdsJob.getCron())) {
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
				try {
					triggerBuilder.forJob(xsdsJob.getJobName(), xsdsJob.getJobGroupName());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				triggerBuilder.withIdentity(xsdsJob.getTriggerName(), xsdsJob.getTriggerGroupName());
				triggerBuilder.startNow();
				triggerBuilder.usingJobData(trigger.getJobDataMap());
				triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(xsdsJob.getCron()));
				trigger = (CronTrigger) triggerBuilder.build();
				scheduler.rescheduleJob(triggerKey, trigger);
				logger.info("【" + xsdsJob.getTriggerName() + "】任务调度计划重设成功!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 移除一个任务
	 *
	 * @param xsdsJob xsds 任务类 提供任务名称, 任务组, 触发器名称, 触发器组
	 */
	public void removeJob(AbstractTrigger xsdsJob) throws Exception {
		TriggerKey triggerKey = TriggerKey.triggerKey(xsdsJob.getTriggerName(), xsdsJob.getTriggerGroupName());
		JobKey jobKey = JobKey.jobKey(xsdsJob.getJobName(), xsdsJob.getJobGroupName());
		List<? extends Trigger> list = scheduler.getTriggersOfJob(jobKey);
		
		if(list.size() == 0) {
			throw new NullPointerException("未找到任务!");
		}
		scheduler.pauseTrigger(triggerKey);
		scheduler.unscheduleJob(triggerKey);
		scheduler.deleteJob(JobKey.jobKey(xsdsJob.getJobName(), xsdsJob.getJobGroupName()));
	}

	/**
	 * 启动所有定时任务
	 */
	public void startJobs() {
		try {
			scheduler.start();
			logger.info("任务调度计划启动成功");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 关闭所有定时任务
	 */
	public void shutdownJobs() {
		try {
			if (!scheduler.isShutdown()) {
				scheduler.shutdown();
				logger.info("任务调度计划停止成功");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
