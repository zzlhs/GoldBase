package com.zzl.es.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzl.es.pojo.Customer;

public interface CustomerDao extends JpaRepository<Customer, String>{

}
