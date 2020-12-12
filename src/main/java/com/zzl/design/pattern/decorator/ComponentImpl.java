package com.zzl.design.pattern.decorator;

public class ComponentImpl implements Component{
	
	public ComponentImpl() {
		
	}
	
	@Override
	public void operation() {
		System.out.println("ComponentImpl...");
	}

}
