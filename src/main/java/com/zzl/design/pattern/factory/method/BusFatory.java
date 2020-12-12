package com.zzl.design.pattern.factory.method;

public class BusFatory implements Factory{

	@Override
	public Transportation producer() {
		return new Bus();
	}

}
