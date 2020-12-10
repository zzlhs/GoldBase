package com.zzl.pool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CycleBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
		while(true) {
			for(int i = 0;i<4;i++) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							TimeUnit.SECONDS.sleep(1);
							try {
								System.out.println(Thread.currentThread().getName() + " 开始等待...");
								cyclicBarrier.await();
								System.out.println(Thread.currentThread().getName() + " 执行结束...");
							} catch (BrokenBarrierException e) {
								e.printStackTrace();
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				}).start();
			}
			
			
			try {
				System.out.println(Thread.currentThread().getName() + " 开始等待...");
				TimeUnit.SECONDS.sleep(5);
				cyclicBarrier.await();
				System.out.println(Thread.currentThread().getName() + " 执行结束...");
				cyclicBarrier.reset();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}

}
