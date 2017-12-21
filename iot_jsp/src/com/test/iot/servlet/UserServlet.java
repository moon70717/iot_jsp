package com.test.iot.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	public String getCommand(String uri) {
		int idx=uri.lastIndexOf(".do");
		if(idx!=-1) {
			return uri.substring(1,idx);
		}
		return "";
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		String uri=req.getRequestURI();
		String cmd =getCommand(uri);
		if(cmd.equals("list")) {
			
		}else if(cmd.equals("view")) {
			
		}else {
			cmd="/common/error";
		}
		cmd+=".jsp";
		RequestDispatcher rd=req.getRequestDispatcher(cmd);
		rd.forward(req, res);
		StringBuffer url=req.getRequestURL();
		/*PrintWriter out=res.getWriter();
		
		out.print("url: "+url+"<br>");
		out.print("uri: "+uri+"<br>");*/
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		out.print("adsadd");
	}
}
