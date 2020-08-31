package com.zzl.es.pojo;

public class SingleClass {
	
	private static SingleClass singleClass = null;
	
	private SingleClass() {
		
	}
	
	public static SingleClass getSingleClass() {
		if(singleClass == null)
			singleClass = new SingleClass();
		return singleClass;
	}
}
