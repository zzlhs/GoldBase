package com.zzl.es.controller;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zzl.es.quartz.ScheduleService;
import com.zzl.es.quartz.XsdsJob;
import com.zzl.es.quartz.XsdsJobTrigger;

@RestController
public class TestController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private Scheduler scheduler;

	 @RequestMapping(value = "/index", method = RequestMethod.GET)
	    public void index() throws SchedulerException {
	      //cron表达式
	        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/8 * * * * ?");
	        //根据name 和group获取当前trgger 的身份
	        TriggerKey triggerKey = TriggerKey.triggerKey("cj", "123");
	        CronTrigger triggerOld = null;
	        try {
	            //获取 触发器的信息
	            triggerOld = (CronTrigger) scheduler.getTrigger(triggerKey);
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	        if (triggerOld == null) {
	            //将job加入到jobDetail中
	            JobDetail jobDetail = JobBuilder.newJob(XsdsJob.class).withIdentity("cj", "123").build();
	            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("cj","123").withSchedule(cronScheduleBuilder).build();
	            //执行任务
	            scheduler.scheduleJob(jobDetail, trigger);
	        } else {
	            System.out.println("当前job已存在--------------------------------------------");
	        }
	    }
	
	@GetMapping("/start")
	public String test() {
		scheduleService.createXsdsJob();
		scheduleService.setDemoSchedule();
		scheduleService.startJobs();
		return "test";
	}
	
	@GetMapping("/updateCron")
	public String test1() {
		String cron = "0/1 * * * * ?";
		XsdsJobTrigger trigger = scheduleService.getXsdsJobTrigger("这是一个测试任务", cron, "type", 1000);
		scheduleService.modifyJobTime(trigger);
		
//		scheduleService.createXsdsJob();
//		scheduleService.setDemoSchedule();
//		scheduleService.startJobs();
		return "test1";
	}
	
	@GetMapping("/end")
	public String test3() {
		String cron = "0/1 * * * * ?";
		
		XsdsJob job = new XsdsJob();
		job.setJobName("xsdsJob");
		job.setJobGroupName("jobGroupName");
		XsdsJobTrigger trigger = scheduleService.getXsdsJobTrigger(job, "这是一个测试任务", "trgGroupName");
		try {
			scheduleService.removeJob(trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		scheduleService.createXsdsJob();
//		scheduleService.setDemoSchedule();
//		scheduleService.startJobs();
		return "test3";
	}
	
	@GetMapping("/test4")
	public String test4() {
		String cron = "0/1 * * * * ?";
		
		XsdsJob job = new XsdsJob();
		job.setJobName("xsdsJob1");
		job.setJobGroupName("jobGroupName");
		XsdsJobTrigger trigger = scheduleService.getXsdsJobTrigger(job, "这是一个测试任务", "trgGroupName");
		scheduleService.modifyJobTime(trigger);
//		scheduleService.createXsdsJob();
//		scheduleService.setDemoSchedule();
//		scheduleService.startJobs();
		return "test4";
	}
}
