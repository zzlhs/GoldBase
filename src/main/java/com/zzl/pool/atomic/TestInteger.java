package com.zzl.pool.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestInteger {
	int temp = 0;
	public static void main(String[] args) {
//		AtomicInteger atomicInteger = new AtomicInteger(0);
//		
//		int res = atomicInteger.getAndIncrement();
//		System.out.println(res);
//		System.out.println(atomicInteger);
		
		new TestInteger().m1();
	}
	
	public void m1() {
		
		System.out.println(temp);
//		ExecutorService executorService = Executors.newCachedThreadPool();
//		for(int i = 0;i<500;i++) {
//			executorService.submit(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName() + "执行完毕...");
//					temp++;
//				}
//			});
//		}
		for(int i = 0;i<10000;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + "执行完毕...");
						temp++;
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}).start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(10);
			System.out.println(temp);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
