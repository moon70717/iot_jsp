<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String jsonStr="{\"id\":\"test\",\"name\":\"테스트\"}";
Gson gs = new Gson();
HashMap hm = gs.fromJson(jsonStr, HashMap.class);
System.out.print(hm);
jsonStr=gs.toJson(hm);
System.out.print(jsonStr);
out.println(jsonStr);
%>