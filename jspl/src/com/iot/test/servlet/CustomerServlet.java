package com.iot.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.test.service.CustomerService;
import com.iot.test.service.MenuService;
import com.iot.test.service.impl.CustomerServiceImpl;
import com.iot.test.service.impl.MenuServiceImpl;

public class CustomerServlet extends HttpServlet {

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

		CustomerService cs = new CustomerServiceImpl();
		MenuService ms = new MenuServiceImpl();
		String uri = req.getRequestURI();
		String root = req.getContextPath();
		
		if (uri.indexOf("customer/delete") != -1) {
			System.out.println("uri= " + uri);
			cs.deleteCustomer(req);
			uri = "/customer/list";
		} else if(uri.indexOf("customer/edit")!=-1) {
			cs.updateCustomer(req);
			uri = "/customer/list";
		}
		
		req.setAttribute("rootPath", root);
		uri = "/view" + uri;
		
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		System.out.println("customerServlet final uri: " + uri);
		rd.forward(req, res);
	}
}
