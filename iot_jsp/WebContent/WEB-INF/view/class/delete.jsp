<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>반 삭제</title>
</head>
<body>
<%
int result=(Integer)request.getAttribute("delete");
if(result==1){
	out.print("제거성공!<br>");
}
ArrayList<HashMap<String,Object>> userList=(ArrayList<HashMap<String,Object>>)request.getAttribute("list");
for(HashMap<String,Object> hm:userList){
	out.print(hm+"<br>");
}
%>
</body>
</html>