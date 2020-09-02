package com.zzl.es.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzl.es.service.TestService;

@RestController
public class TestController {
	
	private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/test")
	public String test() {
		logger.info("test 测试");
		
		testService.testMethod();
		return "test";
	}
}
