package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import com.hibernate.domain.Linkman;
import com.hibernate.utils.HibernateUtil;

public class LinkmanDao {

	public void saveLinkman(Linkman l) {
		Session session = HibernateUtil.getCurrentSession();
		session.save(l);
	}

	public List<Linkman> findList(DetachedCriteria criteria) {
		//查询数据
		List<Linkman> list = criteria.getExecutableCriteria(HibernateUtil.getCurrentSession()).list();
		return list;
	}

}
