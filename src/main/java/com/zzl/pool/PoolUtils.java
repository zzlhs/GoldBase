package com.zzl.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/**
 * 
 * @author bioknow008
 *
 */
public class PoolUtils {
	
	public static void main(String[] args) {
		
		int i = 1 << 2;
		int j = 10;
		if(j > 6) {
			System.out.println("j>6");
		}
		if(j > 5) {
			System.out.println("j>5");
		}
	}
	public static ScheduledExecutorService m1() {
		/*
		 * 一个
		 */
		ExecutorService executorService = Executors.newCachedThreadPool();
		/*
		 * 单一线程池
		 */
		Executors.newSingleThreadExecutor();
		/*
		 * 
		 */
		Executors.newFixedThreadPool(5);
		/*
		 * 
		 */
		Executors.newScheduledThreadPool(1);
		
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				for(;;) {
					System.out.println("哈哈哈...");
				}
			}
		});
		return null;
	}
	
}
