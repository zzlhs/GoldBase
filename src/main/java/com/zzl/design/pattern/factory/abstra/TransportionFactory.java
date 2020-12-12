package com.zzl.design.pattern.factory.abstra;

import com.zzl.design.pattern.factory.method.Bus;
import com.zzl.design.pattern.factory.method.Car;
import com.zzl.design.pattern.factory.method.Transportation;

public class TransportionFactory implements Factory{

	@Override
	public Transportation producerCar() {
		return new Car();
	}

	@Override
	public Transportation producerBus() {
		return new Bus();
	}

}
