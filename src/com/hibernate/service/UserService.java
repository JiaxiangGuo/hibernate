package com.hibernate.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.dao.UserDao;
import com.hibernate.domain.User;
import com.hibernate.utils.HibernateUtil;

public class UserService {
	public void save(User u1, User u2){
		UserDao dao = new UserDao();
		//获取session
		Session session = HibernateUtil.getCurrentSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		try {
			
			dao.save1(u1);
			
			//int a = 1/0;
			
			dao.save2(u2);
			//提交事务
			tr.commit();
			
		} catch (Exception e) {
			//问题出现，事务回滚
			tr.rollback();
		}finally{
			//自己释放资源，不用手动释放
		}
		
	}
}
