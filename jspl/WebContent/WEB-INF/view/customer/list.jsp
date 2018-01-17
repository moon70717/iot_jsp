<%@page import="com.iot.test.vo.Customer"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<style>
*{
color:black;
text-decoration:none;
} 
</style>
<%
String rr=request.getParameter("orderby");
if(rr.equals("desc")){
	rr="asc";
}else{
	rr="desc";
}

%>
<body>
	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<th><a href="${root}/view/customer/list?order=customerId&orderby=<%=rr%>">customerId</a></th>
			<th><a href="${root}/view/customer/list?order=customerName&orderby=<%=rr%>">customerName</a></th>
			<th><a href="${root}/view/customer/list?order=city&orderby=<%=rr%>">city</a></th>
			<th><a href="${root}/view/customer/list?order=country&orderby=<%=rr%>">country</a></th>
		</tr>
		<c:if test="${customerList eq null}">
			<tr>
				<td colspan="4">고객리스트가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.customerId}</td>
				<td>${customer.customerName}</td>
				<td>${customer.city}</td>
				<td>${customer.country}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>