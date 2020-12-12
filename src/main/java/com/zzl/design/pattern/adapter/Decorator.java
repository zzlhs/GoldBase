package com.zzl.design.pattern.adapter;

import com.zzl.design.pattern.decorator.Component;

public class Decorator implements Component{
	
	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}
	
	@Override
	public void operation() {
		component.operation();
	}

}
