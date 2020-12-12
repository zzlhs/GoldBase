package com.zzl.design.pattern.adapter;

public class Adapter implements Target{
	
	private Adaptee adaptee = null;
	
	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	@Override
	public void targetMethod() {
		System.out.println("Adapter... ");
		adaptee.adapteeMethod();
	}

}
