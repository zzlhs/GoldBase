package com.zzl.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(5);
		
		for(int i = 0;i<4;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(1);
						countDownLatch.countDown();
						System.out.println(Thread.currentThread().getName() + " 执行结束...");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}).start();
		}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(5);
					countDownLatch.countDown();
					System.out.println(Thread.currentThread().getName() + " 执行结束...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
		try {
			System.out.println(Thread.currentThread().getName() + " 开始等待...");
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " 执行结束...");
		
	}
}
