package com.zzl.es.qua;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SampleScheduler {
	@Bean
	public JobDetail sampleJobDetail() {
	    // 链式编程,可以携带多个参数,在Job类中声明属性 + setter方法
	    return JobBuilder.newJob(SampleJob.class)
	    				 .withIdentity("sampleJob")
	    				 .usingJobData("name","World")
	    				 .storeDurably()
	    				 .build();
	}

	@Bean
	public Trigger sampleJobTrigger(){
	    // 每隔两秒执行一次
	    SimpleScheduleBuilder scheduleBuilder =
	            SimpleScheduleBuilder.simpleSchedule()
	            					.withIntervalInSeconds(2)
	            					.repeatForever();
	    
	    return TriggerBuilder.newTrigger()
	    					.forJob(sampleJobDetail())
	    					.withIdentity("sampleTrigger")
	    					.withSchedule(scheduleBuilder)
	    					.build();
	}
	
}
