package com.test.iot.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.iot.service.ClassService;
import com.test.iot.service.impl.ClassServiceImpl;

public class ClassServlet extends HttpServlet {

	ClassService ci = new ClassServiceImpl();

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
			req.setAttribute("list", ci.getUserList());
		} else if (cmd.equals("insert")) {
			int i = 1;
			LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();
			hm.put("CINAME", "클래스1");
			hm.put("CIDSCE", "클래스1");
			req.setAttribute("insert", ci.executeUpdate(i, hm));
		} else if (cmd.equals("delete")) {
			int i = 2;
			LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();
			hm.put("CINO", 3);
			req.setAttribute("delete", ci.executeUpdate(i, hm));
		} else if (cmd.equals("update")) {
			int i = 3;
			LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();
			hm.put("CIDSCE", "바뀐이름");
			hm.put("CINO", 5);
			req.setAttribute("update", ci.executeUpdate(i, hm));
		} else {
			cmd = "/WEB-INF/view/common/error";
		}
		uri = "/WEB-INF/view" + uri + ".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}
