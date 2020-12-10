package com.zzl.pool.cp.block;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


public class BlockQueueExample {
	public static void main(String[] args) {
		BlockingQueue<Object> queue = new LinkedBlockingDeque<Object>(10);
		
		for(int i = 0;i<5;i++) {
			new Thread(new Consumer(queue))
				.start();
		}
		
		for(int i = 0;i<3;i++) {
			new Thread(new Producer(queue))
				.start();
		}
	}
}
