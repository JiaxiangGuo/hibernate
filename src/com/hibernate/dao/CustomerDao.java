package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.Customer;
import com.hibernate.utils.HibernateUtil;

public class CustomerDao {
	//保存客户
	public void save(Customer c) {
		//获取session
		Session s = HibernateUtil.getSession();
		//开启事务
		Transaction transaction = s.beginTransaction();
		//保存用户
		s.save(c);
		//提交事务
		transaction.commit();
		//关闭资源
		s.close();
	}

}
