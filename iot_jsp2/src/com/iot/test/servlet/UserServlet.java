package com.iot.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.iot.test.service.ClassService;
import com.iot.test.service.UserService;
import com.iot.test.service.impl.ClassServiceImpl;
import com.iot.test.service.impl.UserServiceImp;
import com.iot.test.vo.UserClass;

public class UserServlet extends HttpServlet {
	UserService us = new UserServiceImp();
	ClassService cs=new ClassServiceImpl();
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
		System.out.print("encode: "+ req.getCharacterEncoding());
		PrintWriter out=res.getWriter();
		String uri = (String) req.getRequestURI();
		System.out.println("user servlet");
		String cmd = getCommand(uri);
		System.out.println("cmd now : " + cmd);
		if (cmd.equals("login")) {
			HashMap<String, Object> hm = us.login(req);
			out.print(gs.toJson(hm));
		} else if(cmd.equals("logout")) {
			us.logout(req);
			RequestDispatcher rd=req.getRequestDispatcher("/view/user/login");
			rd.forward(req, res);
		} else if(cmd.equals("signin")) {
			System.out.print("출발합니다 "+req.getParameter("param"));
			us.signin(req);
			out.print(req.getAttribute("resStr"));
		} else if(cmd.equals("list")) {
			ArrayList<UserClass> userList=us.getUserList();
			out.print(gs.toJson(userList));
		} else if(cmd.equals("delete")) {
			out.println(us.deleteUser(req));
		} else if(cmd.equals("update")) {
			System.out.println("update from servlet");
			out.println(us.updateUser(req));
		}
	}
}
