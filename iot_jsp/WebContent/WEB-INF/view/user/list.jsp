<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유저리스트</title>
<script>
    function f_insert(){
        alert("asfasfaf");
    }
</script>
<style>
    *{
        text-decoration: none;
    }    
</style>
</head>
<body>
<%


ArrayList<HashMap<String,Object>> userList=(ArrayList<HashMap<String,Object>>)request.getAttribute("list");

for(HashMap<String,Object> hm:userList){
	out.print(hm+"<br>");
}
%>
<form name="insert" method="get" action="">
    <input type="button" value="insertBtn" onclick="f_insert()">
</form>


</body>
</html>