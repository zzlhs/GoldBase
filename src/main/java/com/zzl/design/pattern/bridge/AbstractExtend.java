package com.zzl.design.pattern.bridge;

public class AbstractExtend extends Abstraction{

	public AbstractExtend(Implementor imple) {
		super(imple);
	}

	@Override
	void operation() {
		System.out.println("AbstractExtend...");
		implementor.OperationImpl();
	}

}
