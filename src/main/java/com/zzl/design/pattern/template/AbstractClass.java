package com.zzl.design.pattern.template;

public abstract class AbstractClass {
	
	public void TemplateMethod() {
		m1();
		m2();
		m3();
	}
	
	public void m1() {
		System.out.println("AbstractClass... -> m1 ");
	}
	
	public abstract void m2();
	
	public abstract void m3();

}
