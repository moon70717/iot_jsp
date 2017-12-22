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
		if (cmd.equals("list")) {
			req.setAttribute("list", us.getUserList());
		} else if (cmd.equals("insert")) {
			String sql="INSERT INTO USER_INFO(UINAME,UIAGE,UIID,UIPWD,CINO,uiregdate,address) " + 
					"VALUES ('갑길동',33,'ttestㄴㄴ','GGGㄴㄴ',3,Now(),'서울')";
			LinkedHashMap<String, Object> hm=new LinkedHashMap<String, Object>();
			req.setAttribute("insert", us.executeUpdate(sql,null));// 여기도 일단 받는값 없으니 이렇게 임시로 채움
		} else if (cmd.equals("delet")) {
			String sql="delete from user_info where uino=33";
			LinkedHashMap<String, Object> hm=new LinkedHashMap<String, Object>();
			req.setAttribute("insert", us.executeUpdate(sql,null));// 여기도 일단 받는값 없으니 이렇게 임시로 채움
		} 
		
		else {
			cmd = "/WEB-INF/view/common/error";
		}
		uri = "/WEB-INF/view" + uri + ".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}
