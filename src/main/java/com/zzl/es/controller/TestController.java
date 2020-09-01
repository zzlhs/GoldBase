package com.zzl.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzl.es.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/test")
	public String test() {
		
		testService.testMethod();
		return "test";
	}
}
