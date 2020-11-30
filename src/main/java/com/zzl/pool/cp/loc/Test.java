package com.zzl.pool.cp.loc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.zzl.pool.cp.sync.Store;

public class Test {
	
	
	public static void main(String[] args) {
		Store store = new Store();
		Lock reentrantLock = new ReentrantLock();
		Condition condition = reentrantLock.newCondition();
		
		for(int i = 0;i<5;i++) {
			new Thread(new Consumer(store, reentrantLock, condition))
				.start();
		}
		
		for(int i = 0;i<5;i++) {
			new Thread(new Producer(store, reentrantLock, condition))
				.start();
		}
	}
}
