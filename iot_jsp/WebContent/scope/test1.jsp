<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setAttribute("msg", "test1에서 세팅된값");
session.setAttribute("msg","test1에서 세팅된 세션값");
application.setAttribute("msg","test1에서 세팅된 어플리케이션값");
RequestDispatcher rd=request.getRequestDispatcher("./test2.jsp");
rd.forward(request,response);
%>