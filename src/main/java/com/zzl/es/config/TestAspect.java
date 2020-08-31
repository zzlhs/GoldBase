package com.zzl.es.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-99) // Aspect的执行顺序，数值越小越先执行
@Component
public class TestAspect {
	
	
	public void before() {
		
	}
}
