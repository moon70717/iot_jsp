<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IOT</title>
<style>
* {
	text-decoration: none;
}

a {
	color: blue;
}
</style>
</head>
<body>
	안녕하세요
	<br>
	<a href="/iot.do">유저리스트</a>
	<br>
	<%
		String realPath = application.getRealPath(request.getRequestURI());
		realPath = realPath.substring(0, realPath.lastIndexOf(System.getProperty("file.separator")));
		out.println(realPath);
	%>
</body>
</html>