<%-- <%@page import="com.sun.deploy.nativesandbox.comm.Response"%> --%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String rootPath = request.getContextPath();
	Map<String, String> menuMap = new HashMap<String, String>();
	menuMap.put("UserList", rootPath+"/view/user/list");
	menuMap.put("Home", rootPath);
	
%>
<c:set var="menuMap" value="<%=menuMap%>" scope="page" />
<c:set var="title" value="JSTL TEST" scope="page" />
<c:forEach items="${menuMap }" var="menu">
	<a href="${menu.value }">${menu.key }</a>
</c:forEach>
<br>
