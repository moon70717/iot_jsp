package com.jspl.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jspl.test.service.UserService;
import com.jspl.test.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	UserService us=new UserServiceImpl();
	Gson gs = new Gson();

	public String getCommand(String uri) {
		int idx = uri.lastIndexOf("/");
		if (idx != -1) {
			return uri.substring(idx + 1);
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
		
		PrintWriter out=res.getWriter();
		String uri = (String) req.getRequestURI();
		System.out.println("user servlet");
		String cmd = getCommand(uri);
		System.out.println("cmd now : " + cmd);
		String name=req.getParameter("param");
		if (cmd.equals("search")) {
			/*us.getSearchList(req, name);*/
			out.println("ssda");
			
		}
	}
}




