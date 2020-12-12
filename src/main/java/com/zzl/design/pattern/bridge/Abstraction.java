package com.zzl.design.pattern.bridge;

public abstract class Abstraction {
	
	protected Implementor implementor;
	
	protected Abstraction(Implementor imple) {
		this.implementor = imple;
	}
	
	abstract void operation();
}
