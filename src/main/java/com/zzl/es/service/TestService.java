package com.zzl.es.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	
	public void testMethod() {
		System.out.println("success in service");
	}
	
	public String testAop() {
		return "测试SpringAOP";
	}
}