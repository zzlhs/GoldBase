//package com.zzl.es.quartz;
//
//import org.quartz.CronScheduleBuilder;
//import org.quartz.CronTrigger;
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
//import org.quartz.TriggerKey;
//
//public class Task {
//	
//	
//	public void m1() {
//		
//		  Trigger trigger = n
//		  try {
//		  	  // TriggerKey  是作为一个触发器的标识存在的, 通过 TriggerKey 可以定位到一个触发器, 这里使用的参数为触发器所在组及触发器名称
//		      TriggerKey triggerKey = TriggerKey.triggerKey(trigger.getTriggerName(), trigger.getTriggerGroupName());
//			  // 通过使用调度器 scheduler.getTrigger() 方法返回值来获取对应的触发器
//		      if (scheduler.getTrigger(triggerKey) != null) {
//		          logger.error("当前任务【" + trigger.getTriggerName() + "】已存在, 无法覆盖创建任务调度计划");
//		          return;
//		      }
//			  // 触发器构建器
//		      TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
//		      // 执行时辅助参数
//		      triggerBuilder.usingJobData(trigger.getParam());
//		      // 触发器信息
//		      triggerBuilder.withIdentity(trigger.getTriggerName(), trigger.getTriggerGroupName());
//		      // 设置后立即启动
//		      triggerBuilder.startNow();
//		      // 使用的调度类型, 这里配置为cron表达式触发器
//		      triggerBuilder.withSchedule(
//		              CronScheduleBuilder.cronSchedule(trigger.getCron())
//		                      .withMisfireHandlingInstructionDoNothing());
//		      // 该触发器所关联的任务
//		      triggerBuilder.forJob(trigger.getJobName(), trigger.getJobGroupName());
//		      CronTrigger cronTrigger = (CronTrigger) triggerBuilder.build();
//		      // 设置触发器
//		      scheduler.scheduleJob(cronTrigger);
//		      // 当前调度器是否执行, 如果没执行, 启动该调度器
//		      if (!scheduler.isShutdown()) {
//		          scheduler.start();
//		          logger.info("【" + trigger.getTriggerName() + "】任务调度计划启动成功!");
//		      }
//		  } catch (Exception e) {
//		      throw new RuntimeException(e);
//		  }
//
//	}
//}
