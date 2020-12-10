package com.zzl.pool.cp.block;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
	
	private volatile boolean isRunning = true;
	
	private BlockingQueue<Object> queue;
	
	public Producer(BlockingQueue<Object> bq) {
		this.queue = bq;
	}
	
	@Override
	public void run() {
		while(isRunning) {
			
			try {
				TimeUnit.SECONDS.sleep(2);
				
				queue.put(1);
				System.out.println("生产者"+ Thread.currentThread().getName() +"生产了1个产品 此时仓库种有 " + queue.size() + " 个产品");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
		isRunning = false;
	}

}
