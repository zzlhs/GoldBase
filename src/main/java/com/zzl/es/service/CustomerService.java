package com.zzl.es.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzl.es.dao.CustomerDao;
import com.zzl.es.pojo.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	
	public Customer addCustomer(Customer customer) {
		return customerDao.save(customer);
	}
	
	/**
	 * jpa根据entity的id来修改
	 * @param customer
	 * @return
	 */
	public Customer uppdateCustomer(Customer customer) {
		return customerDao.save(customer);
	}
	
	public void deleteCustomerById(Long id) {
		customerDao.deleteById(id+"");
	}
	
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public Customer findAllById(Long id) {
		return customerDao.findById(id+"").get();
	}
	
//	public List<Customer> findAllByName(String name) {
//	}
	
}
