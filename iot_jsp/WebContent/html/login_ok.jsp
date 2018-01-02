<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (request.getParameter("user_id"));
		String pwd = request.getParameter("user_pwd");
		String name = request.getParameter("user_name");
		String msg = "test님 로그인에 성공하셨습니다";
		if (id.equals("test")) {
			if (!pwd.equals("r1r2")) {
				msg = "pwd가 틀렸습니다";
			}
		} else {
			msg = "id가 틀렸습니다";
		}
		out.println(msg);
	%>
</body>
</html>