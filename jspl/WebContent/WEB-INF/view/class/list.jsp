<%@page import="com.iot.test.vo.ClassInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

클래스리스트
	<table border="1">
			<tr>
				<th>이름</th>
				<th>나이</th>
			</tr>
			<c:forEach items="${classList}" var="class1">
				<tr>
					<td>${class1.ciName}</td>
					<td>${class1.ciDesc}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>