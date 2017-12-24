<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/view/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유저입력</title>
</head>
<body>
<%
int result=(Integer)request.getAttribute("insert");
if(result==1){
	out.print("입력성공!<br>");
}
ArrayList<HashMap<String,Object>> userList=(ArrayList<HashMap<String,Object>>)request.getAttribute("list");
for(HashMap<String,Object> hm:userList){
	out.print(hm+"<br>");
}
%>
</body>
</html>