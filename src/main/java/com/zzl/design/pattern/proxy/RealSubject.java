package com.zzl.design.pattern.proxy;

public class RealSubject implements Subject{

	@Override
	public void desc() {
		System.out.println("真实subject...");
	}

}
