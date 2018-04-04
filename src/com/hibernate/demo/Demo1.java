package com.hibernate.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.Linkman;
import com.hibernate.domain.User;
import com.hibernate.utils.HibernateUtil;

public class Demo1 {
	@Test
	public void run1(){
		Session session = HibernateUtil.getSession();
		
		Transaction tr = session.beginTransaction();
		//Hibernate查询语句HQL
//		Query query = session.createQuery("from User where name = ?");
//		query.setString(0, "...");
//		Query query = session.createQuery("from User where name = aa and age = bb");
//		query.setString(aa, "...");
//		query.Integer(bb, "...");
//		List<User> list = query.list();
		
		//Criteria接口，适合做条件查询，面向对象
		//获取查询接口
		Criteria criteria = session.createCriteria(User.class);
		//Criteria是Hibernate提供的条件查询的对象，想传入条件使用工具类Restrictions,提供静态方法
		criteria.add(Restrictions.eq("name", "李健"));
		criteria.add(Restrictions.eq("age", 38));
		//有条件查询条件匹配的数据，没有条件查询所有
		List<User> list = criteria.list();
	}
	@Test
	public void run2(){
		//双向关联的方式保存客户
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		//创建一个客户
		Customer c1 = new Customer();
		c1.setCust_name("客户");
		//创建两个联系人
		Linkman l1 = new Linkman();
		l1.setLkm_name("联系人1");
		Linkman l2 = new Linkman();
		l2.setLkm_name("联系人2");
		
		//双向关联
		c1.getLinkmans().add(l1);
		c1.getLinkmans().add(l2);
		
		l1.setCustomer(c1);
		l2.setCustomer(c1);
		
		session.save(c1);
		session.save(l1);
		session.save(l2);
		tr.commit();
		
	}
	@Test
	public void run3(){
		//级联保存的方式保存客户
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		//创建一个客户
		Customer c1 = new Customer();
		c1.setCust_name("客户");
		//创建两个联系人
		Linkman l1 = new Linkman();
		l1.setLkm_name("联系人1");
		Linkman l2 = new Linkman();
		l2.setLkm_name("联系人2");
		//只需单向关联，在CUstomer配置文件中配置cascade属性为save-update，方向性
		c1.getLinkmans().add(l1);
		c1.getLinkmans().add(l2);
		session.save(c1);
		tr.commit();
	}
	@Test
	public void run4(){
		//级联保存的方式保存客户
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		//创建一个客户
		Customer c1 = new Customer();
		c1.setCust_name("客户");
		//创建两个联系人
		Linkman l1 = new Linkman();
		l1.setLkm_name("联系人1");
		Linkman l2 = new Linkman();
		l2.setLkm_name("联系人2");
		//只需单向关联，在Linkman配置文件中配置cascade属性为save-update，方向性
		l1.setCustomer(c1);
		l2.setCustomer(c1);
		session.save(l1);
		session.save(l2);
		tr.commit();
	}
}
