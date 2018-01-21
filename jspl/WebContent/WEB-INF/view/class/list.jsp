<%@page import="com.iot.test.vo.ClassInfo"%>
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
<%
String name=request.getParameter("ciName");
if(name==null){
	name="";
}
%>
<body>
<form>
		<input type="text" placeholder="이름을 입력하세요" name="ciName" id="input" value="<%=name%>"/>
		<input type="submit" value="찾기" /><br>
	</form>
클래스리스트
	<table border="1">
			<tr>
				<th>번호</th>
				<th>반 이름</th>
				<th>반 설명</th>
			</tr>
			<c:forEach items="${classList}" var="class1">
				<form id="${class1.ciNo}">
				<tr>
					<td><input type="text" value="${class1.ciNo}"
						name="ciNo" readonly /></td>
					<td><input type="text" value="${class1.ciName}" name="ciName"/></td>
					<td><input type="text" value="${class1.ciDesc}" name="ciDesc"/></td>
					<td><input type="submit" value="del" name="type"
						onclick="onBtn('del','${class1.ciNo}')" /> 
						<input type="submit" value="edit" name="type" onclick="onBtn('edit','${class1.ciNo}')"/></td>
				</tr>
				</form>
			</c:forEach>
	</table>
	
	
</body>
</html>