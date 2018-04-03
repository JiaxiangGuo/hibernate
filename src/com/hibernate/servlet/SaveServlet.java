package com.hibernate.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.domain.User;
import com.hibernate.service.UserService;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u1 = new User();
		u1.setName("测试1");
		User u2 = new User();
		u2.setName("测试2");
		
		new UserService().save(u1, u2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
