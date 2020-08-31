package com.zzl.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzl.es.pojo.Customer;
import com.zzl.es.pojo.SingleClass2;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBean {
	
	@Autowired
	private Customer customer;
	
	@Autowired
	private Customer Customer2;
	
	@Autowired
	private SingleClass2 SingleClass2;
	
	@Autowired
	private SingleClass2 SingleClass22;
	
	@Test
	public void testSingleBean() {
		System.out.println(SingleClass2);
		
		System.out.println(SingleClass22);
	}
	
	@Test
	public void testBean() {
		System.out.println(customer);
		
		System.out.println(Customer2);
	}
}
