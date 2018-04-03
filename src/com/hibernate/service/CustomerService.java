package com.hibernate.service;

import java.util.List;

import com.hibernate.dao.CustomerDao;
import com.hibernate.domain.Customer;

public class CustomerService {
	//保存客户
	public void saveCustomer(Customer c){
		new CustomerDao().save(c);
	}

	public List<Customer> findALl() {
		return new CustomerDao().findAll();
	}

	public List<Customer> findByName(String cust_name) {
		return new CustomerDao().findByName(cust_name);
	}
}
