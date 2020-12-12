package com.zzl.design.pattern.adapter;

public class Test {
	public static void main(String[] args) {
		Adaptee adaptee = new Adaptee();
		
		Adapter adapter = new Adapter(adaptee);
		adapter.targetMethod();
	}
}
