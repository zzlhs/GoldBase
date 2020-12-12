package com.zzl.design.pattern.builder;

public class Director {
	private CarBuilder carBuilder;
	
	public Director(Builder builder) {
		this.carBuilder = (CarBuilder) builder;
	}
	
	public Car producer() {
		carBuilder.setName();
		carBuilder.setPrize();
		carBuilder.setWeight();
		return carBuilder.get();
	}

}
