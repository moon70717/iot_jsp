package com.iot.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.test.service.ClassService;
import com.iot.test.service.CustomerService;
import com.iot.test.service.MenuService;
import com.iot.test.service.UserService;
import com.iot.test.service.impl.ClassServiceImpl;
import com.iot.test.service.impl.CustomerServiceImpl;
import com.iot.test.service.impl.MenuServiceImpl;
import com.iot.test.service.impl.UserServiceImpl;

public class JspServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		CustomerService cs=new CustomerServiceImpl();
		MenuService ms = new MenuServiceImpl();
		String uri = req.getRequestURI();
		String root = req.getContextPath();
		uri = uri.replace("/jspl", "");
		System.out.println("root: " + root);
		ms.setMenuList(req);
		if (uri.indexOf("user/list") != -1) {
			UserService us = new UserServiceImpl();
			us.getUserList(req);
		} else if (uri.indexOf("class/list") != -1) {
			ClassService ci = new ClassServiceImpl();
			ci.getClassList(req);
		} else if (uri.indexOf("customer/list") != -1) {
			cs.setCustomerList(req);
			
		} else if (uri.indexOf("customer/insert")!=-1) {
			cs.insertCustomer(req);
		} else if(uri.indexOf("customer/delete")!=-1) {
			System.out.println("uri= "+uri);
			cs.deleteCustomer(req);
			uri="/view/customer/list";
			
		}
		req.setAttribute("rootPath", root);
		uri = "/WEB-INF" + uri + ".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		System.out.println("final uri: " + uri);
		rd.forward(req, res);
	}

}
