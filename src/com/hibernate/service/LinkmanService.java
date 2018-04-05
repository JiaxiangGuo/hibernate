package com.hibernate.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.hibernate.dao.CustomerDao;
import com.hibernate.dao.LinkmanDao;
import com.hibernate.domain.Customer;
import com.hibernate.domain.Linkman;
import com.hibernate.utils.HibernateUtil;

public class LinkmanService {

	public void saveLinkman(Long id, Linkman l) {
		//开启事务
		Session session = HibernateUtil.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			//查询客户
			Customer c = new CustomerDao().findCustomer(id);
			l.setCustomer(c);
			new LinkmanDao().saveLinkman(l);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		
		
	}

	public List<Linkman> findList(DetachedCriteria criteria) {
		//开启事务
		Session session = HibernateUtil.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			List<Linkman> list = new LinkmanDao().findList(criteria);
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
