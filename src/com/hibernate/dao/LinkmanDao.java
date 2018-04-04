package com.hibernate.dao;

import org.hibernate.Session;

import com.hibernate.domain.Linkman;
import com.hibernate.utils.HibernateUtil;

public class LinkmanDao {

	public void saveLinkman(Linkman l) {
		Session session = HibernateUtil.getCurrentSession();
		session.save(l);
	}

}
