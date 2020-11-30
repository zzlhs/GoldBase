package com.zzl.pool.cp.sync;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
	
	private Store store;
	
	public Consumer(Store store) {
		this.store = store;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (store) {
				while(store.getList().size() <= 0) {
					System.out.println("消费者 " + Thread.currentThread().getName() + 
							" " + "仓库已空");
					try {
						store.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				store.getList().remove(0);
				System.out.println("消费者 " + Thread.currentThread().getName() + 
							" " + "消费... 此时仓库中有 " + store.getList().size() + 
							" 个商品");
				store.notifyAll();
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
}
