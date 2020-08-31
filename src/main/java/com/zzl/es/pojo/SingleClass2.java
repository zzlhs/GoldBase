package com.zzl.es.pojo;

public class SingleClass2 {
	
	private static SingleClass2 instance = new SingleClass2(); 
			
	private SingleClass2() {
		
	}
	
	public static SingleClass2 getSingleClass2() {
		return instance;
	}
}
