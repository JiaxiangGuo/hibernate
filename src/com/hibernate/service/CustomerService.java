package com.hibernate.service;

import com.hibernate.dao.CustomerDao;
import com.hibernate.domain.Customer;

public class CustomerService {
	//保存客户
	public void saveCustomer(Customer c){
		new CustomerDao().save(c);
	}
}
