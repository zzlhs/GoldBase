package com.zzl.pool.cp.sync;

public class Test {
	public static void main(String[] args) {
		Store store = new Store();
		
		for(int i = 0;i<5;i++) {
			new Thread(new Producer(store)).start();
		}
		
		for(int i = 0;i<2;i++) {
			new Thread(new Consumer(store)).start();
		}
	}
}
