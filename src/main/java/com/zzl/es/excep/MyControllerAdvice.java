package com.zzl.es.excep;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {
	
	
	@ExceptionHandler(value = Exception.class)
	public Map errHandler(Exception ex) {
		Map map = new HashMap<>();
		map.put("code", "404");
		map.put("msg", ex.getMessage());
		return map;
	}
}
