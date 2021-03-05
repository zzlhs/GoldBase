package com.zzl.es.pool;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Car {
	private Integer oilService = 100;
	
	void run() {
		log.info("行驶前油量：{}", oilService);
		oilService -= 20;
		log.info("行驶后油量：{}", oilService);
	}
}
