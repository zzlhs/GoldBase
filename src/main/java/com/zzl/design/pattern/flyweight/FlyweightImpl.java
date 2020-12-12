package com.zzl.design.pattern.flyweight;

public class FlyweightImpl implements Flyweight{
	
	private String key;
	
	public FlyweightImpl(String key) {
		this.key = key;
	}
	
	@Override
	public void operation(UnsharedConcreteFlyweight flyweight) {
		System.out.println("FlyweightImpl... " + flyweight.getInfo());
	}

}
