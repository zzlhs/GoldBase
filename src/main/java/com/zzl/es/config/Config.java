package com.zzl.es.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.zzl.es.pojo.Customer;
import com.zzl.es.pojo.SingleClass2;

@Configuration
public class Config {
	
	
	@Bean
	@Scope("prototype")
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setAge(18);
		customer.setName("zzl");
		customer.setSex(1);
		return customer;
	}
	
	@Bean
	@Scope("prototype")
	public SingleClass2 getSingle() {
		return SingleClass2.getSingleClass2();
	}
}
