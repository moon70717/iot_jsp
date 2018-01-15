package com.jspl.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspl.test.service.UserService;
import com.jspl.test.service.impl.UserServiceImpl;

public class JspServlet extends HttpServlet {
	UserService us = new UserServiceImpl();

	public String getCommand(String uri) {
		int idx = uri.lastIndexOf(".");
		if (idx != -1) {
			return uri.substring(0, idx);
		}
		return "";
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		String uri = req.getRequestURI();
		System.out.println("jsp servlet");
		uri = uri.replace("iot_jspl/", "");
		uri = "/WEB-INF" + uri + ".jsp";
		System.out.println(uri);
		if (uri.indexOf("user/list") != -1) {
			us.getUserList(req);
		}
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}
