package com.zzl.design.pattern.bridge;

public class Test {

	public static void main(String[] args) {
		Implementor impl = new ImplementorImpl();
		AbstractExtend absExtend = new AbstractExtend(impl);
		absExtend.operation();
	}

}
