package com.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static final Configuration CONFIG;
	public static final SessionFactory FACTORY;
	static{
		CONFIG = new Configuration().configure();
		FACTORY = CONFIG.buildSessionFactory();
	}
	
	public static Session getSession(){
		return FACTORY.openSession();
	}
	public static Session getCurrentSession(){
		//从ThreadLocal类中获取session对象
		return FACTORY.getCurrentSession();
	}
}
