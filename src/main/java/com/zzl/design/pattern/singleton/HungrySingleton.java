package com.zzl.design.pattern.singleton;

public class HungrySingleton {
	
	private static HungrySingleton hungrySingleton = new HungrySingleton();
	
	private HungrySingleton(){}
	
	public static HungrySingleton getHungrySingleton() {
		return hungrySingleton;
	}
}
