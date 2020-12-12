package com.zzl.design.pattern.builder;

public class CarBuilder implements Builder{
	
	private Car car;
	
	public CarBuilder() {
		car = new Car();
	}
	
	@Override
	public void setName() {
		car.setName("小汽车");
	}

	@Override
	public void setPrize() {
		car.setPrize(20);
	}

	@Override
	public void setWeight() {
		car.setWeight(2000);
	}

	@Override
	public Car get() {
		return car;
	}

}
