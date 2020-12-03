package com.zzl.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestConcurrentMap {
	
	private final static String KEY = "123";
	
	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

			concurrentHashMap.put(KEY, 0);

//			map.put("123", 1);
			ExecutorService executorService = Executors.newCachedThreadPool();
			for(int i = 0 ; i< 1000;i++) {
				executorService.submit(new Runnable() {
					public void run() {
						concurrentHashMap.put(KEY, concurrentHashMap.get(KEY) + 1);
					}
				});
			}
			
//			try {
//				TimeUnit.SECONDS.sleep(30);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(concurrentHashMap.get(KEY));
		
//		System.out.println(map);
	}
}
