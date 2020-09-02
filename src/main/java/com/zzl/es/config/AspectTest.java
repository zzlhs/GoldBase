package com.zzl.es.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class AspectTest {
	
	
	@Pointcut("execution(* com.zzl.es.controller.*.*(..) )")
	public void pointCut() {}
	
	@Around("pointCut()")
	public String handleControllerMethod(ProceedingJoinPoint pjp){
		return "";
	}
}
