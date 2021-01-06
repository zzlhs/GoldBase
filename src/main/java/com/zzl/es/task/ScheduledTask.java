package com.zzl.es.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

//@Configuration
//@EnableAsync
public class ScheduledTask {
	
	ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	@Scheduled(cron = "* * * * * *")
	public void task1() {
		
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("task1-1 -> " + Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(10);
					
					System.out.println("task1-2 -> " + Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(10);
					System.out.println("task1-3 -> " + Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(10);
					
					System.out.println("task1-4 -> " + Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(10);
					
					System.out.println("task1-5 -> " + Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(10);
					
					System.out.println("task1-6 -> " + Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
		});
		
//		System.out.println("task1 -> " + Thread.currentThread().getName());
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					System.out.println("task1-1 -> " + Thread.currentThread().getName());
//					TimeUnit.SECONDS.sleep(10);
//					
//					System.out.println("task1-2 -> " + Thread.currentThread().getName());
//					TimeUnit.SECONDS.sleep(10);
//					System.out.println("task1-3 -> " + Thread.currentThread().getName());
//					TimeUnit.SECONDS.sleep(10);
//					
//					System.out.println("task1-4 -> " + Thread.currentThread().getName());
//					TimeUnit.SECONDS.sleep(10);
//					
//					System.out.println("task1-5 -> " + Thread.currentThread().getName());
//					TimeUnit.SECONDS.sleep(10);
//					
//					System.out.println("task1-6 -> " + Thread.currentThread().getName());
//					TimeUnit.SECONDS.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();
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
