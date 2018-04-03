package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	//查询所有用户
	public List<Customer> findAll() {
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		tr.commit();
		session.close();
		return list;
	}
	//通过客户名称模糊查询
	public List<Customer> findByName(String cust_name) {
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		List<Customer> list = criteria.list();
		tr.commit();
		session.close();
		return list;
	}

}
