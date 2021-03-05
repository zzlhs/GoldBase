package com.zzl.es.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class Test {
	
	public static void main(String[] args) {
		GenericObjectPool<Car> carPool = 
				new GenericObjectPool<Car>(new CarOilFactory(), new GenericObjectPoolConfig<Car>());
		Car car = null;
		try {
			car = carPool.borrowObject();
			car.run();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(car != null) {
				carPool.returnObject(car);
			}
		}
	}
}
