package com.zzl.pool;

import java.util.concurrent.TimeUnit;

public class TestSynchronized {
	
	final Object object = new Object();
	public static void main(String[] args) {
		TestSynchronized test =  new TestSynchronized();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					test.m1();
				}
			}
		});
		t1.setPriority(10);
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				test.m1();
			}
		});
		t2.setPriority(10);
		t2.start();
	}
	public void m1() {
		synchronized (object) {
			while(true) {
				System.out.println(Thread.currentThread() + " m1()...");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public synchronized void m2() {
		while(true) {
			System.out.println(Thread.currentThread() + " m2()...");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
