<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String no = request.getParameter("ni");
System.out.println(no);
String jsonStr="{\'no\':\'"+no+"\',\'id\':\'test\' , \'name\':\'테스트\' , \'gender\': \'asd\' , \'address\':\'sss\'}";
Gson gs = new Gson();
HashMap hm = gs.fromJson(jsonStr, HashMap.class);
System.out.println(hm);
jsonStr=gs.toJson(hm);
System.out.println(jsonStr);
out.println(jsonStr);
%>