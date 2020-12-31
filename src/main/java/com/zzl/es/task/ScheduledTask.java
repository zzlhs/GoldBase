package com.zzl.es.task;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
public class ScheduledTask {
	
	@Scheduled(cron = "* * * * * *")
	@Async
	public void task1() {
		System.out.println("task1 -> " + Thread.currentThread().getName());
		try {
			System.out.println("task1-1 -> ");
			TimeUnit.SECONDS.sleep(10);
			System.out.println("task1-2 -> ");
			TimeUnit.SECONDS.sleep(10);
			System.out.println("task1-3 -> ");
			TimeUnit.SECONDS.sleep(10);
			System.out.println("task1-4 -> ");
			TimeUnit.SECONDS.sleep(10);
			System.out.println("task1-5 -> ");
			TimeUnit.SECONDS.sleep(10);
			System.out.println("task1-6 -> ");
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	@Scheduled(cron = "* * * * * *")
//	public void task2() {
//		System.out.println("task2 -> " + Thread.currentThread().getName());
//
//	}
//	
//	@Scheduled(cron = "* * * * * *")
//	public void task3() {
//		System.out.println("task3 -> " + Thread.currentThread().getName());
//
//	}
}
