package com.zzl.pool.cp;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
	
	private Store store;
	
	public Producer(Store store) {
		this.store = store;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (store) {
				while(store.getList().size() >= Store.SIZE) {
					System.out.println("生产者 " + Thread.currentThread().getName() + 
							" " + "仓库已满");
					try {
						store.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				store.getList().add(1);
				System.out.println("生产者 " + Thread.currentThread().getName() + 
							" " + "生产... 此时仓库中有 " + store.getList().size() + 
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
