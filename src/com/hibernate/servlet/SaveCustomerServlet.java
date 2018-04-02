package com.hibernate.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.hibernate.domain.Customer;
import com.hibernate.service.CustomerService;

/**
 * 添加用户控制器
 */
@WebServlet("/saveCustomer")
public class SaveCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//获取数据
		Map<String, String[]> map = request.getParameterMap();
		Customer c = new Customer();
		
		try {
			//封装数据
			BeanUtils.populate(c, map);
			//调用业务层
			new CustomerService().saveCustomer(c);
			System.out.println("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
