package com.hibernate.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.User;
import com.hibernate.utils.HibernateUtil;

public class UserDao {
	public void save1(User u1){
		//获取session，从threadlocal中获取
		Session session = HibernateUtil.getCurrentSession();
		session.save(u1);
	}
	public void save2(User u2){
		//获取session，从threadlocal中获取
		Session session = HibernateUtil.getCurrentSession();
		session.save(u2);
	}
}
