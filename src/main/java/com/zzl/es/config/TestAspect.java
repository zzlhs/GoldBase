package com.zzl.es.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@Order(-99) // Aspect的执行顺序，数值越小越先执行
@Component
public class TestAspect {
	
	@Pointcut("execution(* com.zzl.es.controller..*.*(..) )")
	public void pointCut() {
		
	}
	
	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		
		System.out.println("before is coming!!");
	}
	
	@After("pointCut()")
	public void after(JoinPoint joinPoint) {
		System.out.println("after is coming!!");
	}
	
	@AfterReturning(pointcut = "pointCut()", returning = "returnVal")
	public void afterReturn(JoinPoint joinPoint, Object returnVal) {
		System.out.println("afterReturning is coming " + returnVal);
	}
	
	@AfterThrowing(pointcut = "pointCut()", throwing = "error")
	public void afterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("afterThrowing is coming " + error);
	}
	
	@Around("pointCut()")
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("around is comint!!  start ");
		
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("around is comint!!  end ");
	}
	
	
	
	
	
	
	
	
}
