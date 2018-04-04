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

import com.hibernate.domain.Linkman;
import com.hibernate.service.CustomerService;
import com.hibernate.service.LinkmanService;

/**
 * 添加联系人
 */
@WebServlet("/addLinkman")
public class AddLinkmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//获取参数
		Map<String, String[]> map = request.getParameterMap();
		Long id = Long.parseLong(map.get("cust_id")[0]);
		//封装数据
		Linkman l = new Linkman();
		try {
			BeanUtils.populate(l, map);
			new LinkmanService().saveLinkman(id, l);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
