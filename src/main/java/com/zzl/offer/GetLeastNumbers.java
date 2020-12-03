package com.zzl.offer;

import java.util.concurrent.TimeUnit;

public class GetLeastNumbers {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
