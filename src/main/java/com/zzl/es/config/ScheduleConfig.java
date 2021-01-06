package com.zzl.es.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;

//@Configuration
//@EnableScheduling
public class ScheduleConfig implements AsyncConfigurer,SchedulingConfigurer {

	@Override
	public Executor getAsyncExecutor() {
		// TODO Auto-generated method stub
//		return AsyncConfigurer.super.getAsyncExecutor();
		return taskExecutor();
	}
	
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean
    public Executor taskExecutor() {
		  ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		  //当前线程数
		  scheduler.setPoolSize(20);
		  //定时任务前缀
		  scheduler.setThreadNamePrefix("myselfThreadPool");
		  //该方法用来设置线程池中 任务的等待时间，如果超过这个时间还没有销毁就 强制销毁，以确保应用最后能够被关闭，而不是阻塞住
		  scheduler.setAwaitTerminationSeconds(20);
		  // 该方法用来设置 线程池关闭 的时候 等待 所有任务都完成后，再继续 销毁 其他的 Bean，这样这些 异步任务 的 销毁 就会先于 数据库连接池对象 的销毁
		  scheduler.setWaitForTasksToCompleteOnShutdown(true);
    	
    	
        return scheduler; //指定线程池大小
    }
}

