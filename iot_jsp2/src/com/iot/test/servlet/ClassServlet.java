package com.iot.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.iot.test.service.ClassService;
import com.iot.test.service.impl.ClassServiceImpl;
import com.iot.test.vo.ClassInfo;

public class ClassServlet extends HttpServlet {
	ClassService cs = new ClassServiceImpl();
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
		String cmd = getCommand(uri);
		System.out.println("ClassServlet");
		System.out.println("cmd : " + cmd);
		if (cmd.equals("list")) {
			ArrayList<ClassInfo> classList = cs.getClassList();
			System.out.println("ciNo get "+classList.get(0).getCiNo());
			System.out.println("ci get "+classList.toString());
			out.print(gs.toJson(classList));
		} else if(cmd.equals("delete")) {
			out.println(cs.deleteClass(req));
		} else if(cmd.equals("update")) {
			System.out.println("update from servlet");
			out.println(cs.updateClass(req));
		} else if(cmd.equals("insert")) {
			System.out.println("insert from servelt");
			out.println(cs.openClass(req));
		}
	}
}
