package com.zzl.design.pattern.singleton;

public class DoubleCheck {
	// 注意 volatile的使用
	private static volatile DoubleCheck doubleCheck = null;
	
	private DoubleCheck() {
		
	}
	
	public static DoubleCheck getDoubleCheck() {
		if(doubleCheck == null) {
			synchronized (DoubleCheck.class) {
				if(doubleCheck == null) {
					doubleCheck = new DoubleCheck();
				}
			}
		}
		return doubleCheck;
	}
}
