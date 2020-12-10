package com.zzl.pool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 控制某个方法被最多并发的次数
 * @author zzl
 *
 */

public class SemaphoreTest implements Runnable{
	private Semaphore semaphore;
	
	
	
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(5);
		for(int i = 0 ;i<50;i++) {
			new Thread(new SemaphoreTest(semaphore)).start();
		}
	}
	
	public SemaphoreTest(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		
//		test();
		
		try { 
			semaphore.acquire();
		  	System.out.println(Thread.currentThread().getName() + " 执行...");
		  	TimeUnit.SECONDS.sleep(60);
		  	System.out.println(Thread.currentThread().getName() + " 执行结束..."); 
		  	semaphore.release();
		} catch(InterruptedException e) { 
			e.printStackTrace(); 
		}
		 
	}
	
	private void test(){  
	    try {  
	    	semaphore.acquire();  
	    } catch (InterruptedException e) {  
	        e.printStackTrace();  
	    }  
	    System.out.println(Thread.currentThread().getName() + " enter...");  
	    try {  
	        Thread.sleep(5000);  
	    } catch (InterruptedException e) {  
	        e.printStackTrace();  
	    }  
	    System.out.println(Thread.currentThread().getName() + " exit...");  
	    semaphore.release();  
	}  
}
