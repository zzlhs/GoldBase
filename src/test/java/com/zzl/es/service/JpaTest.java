package com.zzl.es.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzl.es.pojo.Customer;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JpaTest {
	
	@Autowired
	private CustomerService customerService;

	@Test
	public void add() {
		Customer customer = new Customer();
		customer.setCustName("测试名字");
		Customer returnCustomer = customerService.addCustomer(customer);
		System.out.println("---》 " + returnCustomer);
	}
	
	
}
