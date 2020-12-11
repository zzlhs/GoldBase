package com.zzl.design.pattern.singleton;

public class LazySingleton {
	
	private static LazySingleton lazySingleton = null;
	
	private LazySingleton() {
		
	}
	
	public static LazySingleton getLazySingleton() {
		if(lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

}
