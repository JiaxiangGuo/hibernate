package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.domain.Customer;

/*
 * 测试hibernate
 */
public class Demo1 {
	
	/*
	 * 测试保存客户
	 */
	@Test
	public void testSave() {
		//1.加载配置文件
		Configuration config = new Configuration();
		//1.1默认加载src目录下的hibernate.cfg.xml的配置文件
		config.configure();
		//2.创建sessionFactory对象,生成session对象
		SessionFactory sf = config.buildSessionFactory();
		//3.创建session对象
		Session session = sf.openSession();
		
		//4.开启事务
		Transaction transation = session.beginTransaction();
		//5.编写保存的代码
		Customer customer = new Customer();
		customer.setCust_name("测试");
		customer.setCust_level("3");
		customer.setCust_phone("12345678945");
		//5.1保存数据，操作对象就相当于操作数据库的表结构
		session.save(customer);
		//6.提交事务
		transation.commit();
		//7.释放资源
		session.close();
		sf.close();
	}
}
