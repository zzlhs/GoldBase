package com.zzl.pool.cp.loc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import com.zzl.pool.cp.sync.Store;

public class Consumer implements Runnable{
	
	private Store store;
	
	private Lock lock; 
	
	private Condition condition;
	
	public Consumer(Store store, Lock lock ,  Condition condition) {
		this.store = store;
		this.lock = lock;
		this.condition = condition;
	}
	
	@Override
	public void run() {
		while(true) {
			lock.lock();
			try {
				while(store.getList().size() <= 0) {
					System.out.println("消费者 " + Thread.currentThread().getName() + 
							" " + "仓库已空");
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				store.getList().remove(0);
				System.out.println("消费者 " + Thread.currentThread().getName() + 
						" " + "消费... 此时仓库中有 " + store.getList().size() + 
						" 个商品");
				condition.signalAll();
			}finally {
				lock.unlock();
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
