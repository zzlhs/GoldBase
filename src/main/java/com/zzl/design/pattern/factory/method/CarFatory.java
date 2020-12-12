package com.zzl.design.pattern.factory.method;

public class CarFatory implements Factory{

	@Override
	public Transportation producer() {
		return new Car();
	}

}
