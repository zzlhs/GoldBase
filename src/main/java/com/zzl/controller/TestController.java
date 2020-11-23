package com.zzl.controller;


public class TestController {
	
	public static void main(String[] args) {
//		System.out.println("123");
//		new Class<?>[] {TestController.class};
		Class<?>[] types = new Class<?>[] { TestController.class, String[].class };
		
		Class clazz = null;
		try {
			int len = Thread.currentThread().getStackTrace().length;
			System.out.println(len);
			StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
			System.out.println(stackTrace.length);
			System.out.println(stackTrace[0]);
			for (StackTraceElement stackTraceElement : stackTrace) {
				if ("main".equals(stackTraceElement.getMethodName())) {
					System.out.println("main");
					clazz = Class.forName(stackTraceElement.getClassName());
				}
			}
		}
		catch (Exception ex) {
			// Swallow and continue
		}
		System.out.println(clazz);
	}
	public void m1() {
//		System.setProperty(key, value)
		
		
	}
}
