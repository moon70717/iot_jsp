package com.test.iot.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.iot.service.UserService;
import com.test.iot.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	UserService us = new UserServiceImpl();

	public String getName(String uri) {
		int idx = uri.substring(1, uri.length()).indexOf("/");
		if (idx != 1) {
			return uri.substring(1, idx + 1);
		}
		return "";
	}

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
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String cmd = getCommand(uri);
		String name = getName(uri);
		if (cmd.equals("list")) {
			req.setAttribute("list", us.getUserList(name));
		} else if (cmd.equals("insert")) {
			int i = 1;
			LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();
			hm.put("UINAME", "홍길동");
			hm.put("UIAGE", 33);
			hm.put("UIID", "hoong");
			hm.put("UIPWD", "hoong");
			hm.put("CINO", 3);
			hm.put("address", "서울");
			req.setAttribute("insert", us.executeUpdate(i, hm, name));
		} else if (cmd.equals("delete")) {
			int i = 2;
			LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();
			hm.put("uino", 3);
			req.setAttribute("delete", us.executeUpdate(i, hm, name));
		} else if (cmd.equals("update")) {
			int i = 3;
			LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();
			hm.put("address", "부산");
			hm.put("uino", 5);
			req.setAttribute("update", us.executeUpdate(i, hm, name));
		} else {
			cmd = "/WEB-INF/view/common/error";
		}
		uri = "/WEB-INF/view" + uri + ".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}
