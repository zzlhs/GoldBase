package com.zzl.design.pattern.flyweight;

import java.util.HashMap;

public class FlywieghtFacority {
	
	private HashMap<String, Flyweight> flyweights = new HashMap<>();
	
	public Flyweight getFlyweight(String key) {
		
		Flyweight flyweight = flyweights.get(key);
		if(flyweight != null) {
			System.out.println(key  + "已经存在");
		}else {
			flyweight = new FlyweightImpl(key);
			flyweights.put(key, flyweight);
		}
		return flyweight;
	}

}
