<%@page import="java.util.List"%>
<%@page import="com.iot.test.vo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<%
	String name = request.getParameter("uiName");
	if (name == null) {
		name = "";
	}
	String searchType = request.getParameter("searchType");
	if (searchType == null) {
		searchType = "";
	}
%>
<body>
	<form>
	<select name="selectB">
	<option value="name" <%=searchType %>>이름</option>
	<option value="age" <%=searchType %>>나이</option> 
	<option value="address" <%=searchType %>>주소</option>
	</select>
		<input type="text" placeholder="입력하세요" name="uiName" id="input" value="<%=name %>" /> 
		<!-- <input type="submit" value="찾기" /> -->
		<button>찾기</button>
		<br>
	</form>
	<h4>유저리스트</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.uiName}</td>
				<td>${user.uiAge}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
