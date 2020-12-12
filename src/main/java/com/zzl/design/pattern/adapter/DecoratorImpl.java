package com.zzl.design.pattern.adapter;

import com.zzl.design.pattern.decorator.Component;

public class DecoratorImpl extends Decorator{

	public DecoratorImpl(Component component) {
		super(component);
	}
	
	@Override
	public void operation() {
		super.operation();
		System.out.println("DecoratorImpl 附加操作...");
	}

}
