package com.zzl.design.pattern.factory.abstra;

import com.zzl.design.pattern.factory.method.Transportation;

public interface Factory {
	
	Transportation producerCar();
	
	Transportation producerBus();
	
}
