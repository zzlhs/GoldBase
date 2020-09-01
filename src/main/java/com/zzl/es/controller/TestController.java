package com.zzl.es.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public String test() {
		int i = 9 / 0;
		return "test";
	}
	
	@GetMapping("/testAOP")
	public String testAOP() {
		return "testAOP";
	}
}
