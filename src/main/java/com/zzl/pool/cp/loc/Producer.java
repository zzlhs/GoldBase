package com.zzl.pool.cp.loc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import com.zzl.pool.cp.sync.Store;

public class Producer implements Runnable{
	
	private Store store;
	
	private Lock lock; 
	
	private Condition condition;
	
	public Producer(Store store, Lock lock ,  Condition condition) {
		this.store = store;
		this.lock = lock;
		this.condition = condition;
	}
	
	@Override
	public void run() {
		while(true) {
			lock.lock();
			try {
				while(store.getList().size() >= store.SIZE) {
					System.out.println("生产者 " + Thread.currentThread().getName() + 
							" " + "仓库已空");
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				store.getList().add(1);
				System.out.println("生产者 " + Thread.currentThread().getName() + 
						" " + "生产... 此时仓库中有 " + store.getList().size() + 
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
