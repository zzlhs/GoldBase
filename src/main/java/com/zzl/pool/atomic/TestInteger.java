package com.zzl.pool.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestInteger {
//	private int count = 0;
	
	private AtomicInteger count = new AtomicInteger(0);
	
	public void increment() {  
		count.incrementAndGet();
    }  
      
    private int getCount() {  
        return count.get();  
    }  
	public static void main(String[] args) {
		final TestInteger testInteger =	new TestInteger();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for(int i = 0 ; i < 50000 ; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
//					System.out.println("123");  // 注意当去掉这条注释语句时 int 的不加锁现象才会出现，打印语句回事cpu清除缓存
					testInteger.increment();
				}
			});
		}
		executorService.shutdown();
		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
			System.out.println("---->" + testInteger.getCount());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	public void m1(ExecutorService executorService) {
//		
//		for(int i = 0 ; i < 50000 ; i++) {
//			executorService.execute(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName() + "执行完毕...");
//					temp++;
//				}
//			});
//		}
//		
//	}

}
