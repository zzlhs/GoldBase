package com.zzl.es.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarOilFactory implements PooledObjectFactory<Car>{

	@Override
	public PooledObject<Car> makeObject() throws Exception {
		return new DefaultPooledObject<Car>(new Car());
	}

	@Override
	public void destroyObject(PooledObject<Car> p) throws Exception {
		log.info("报废一辆小汽车");
	}

	@Override
	public boolean validateObject(PooledObject<Car> p) {
		return p.getObject().getOilService() > 0;
	}

	@Override
	public void activateObject(PooledObject<Car> p) throws Exception {
		p.getObject().setOilService(100);
		log.info("给一辆小汽车加油到: 100");
	}

	@Override
	public void passivateObject(PooledObject<Car> p) throws Exception {
		log.info("小汽车剩余油量: {}", p.getObject().getOilService());
	}

}
