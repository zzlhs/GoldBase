package com.zzl.pool.cp.block;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
	
	private volatile boolean isRunning = true;
	
	private BlockingQueue<Object> queue;
	
	public Consumer(BlockingQueue<Object> bq) {
		this.queue = bq;
	}
	
	@Override
	public void run() {
		while(isRunning) {
			
			try {
				TimeUnit.SECONDS.sleep(2);
				
				queue.take();
				System.out.println("消费者"+ Thread.currentThread().getName() +"消费了1个产品 此时仓库种有 " + queue.size() + " 个产品");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
		isRunning = false;
	}
}
