<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	var AjaxObj = function(params) {
		this.url=params.url;
		this.val = function() {
			alert("유효성 검사 함수");
		}
		this.send = function() {
			alert(params.url + "로ajax 전송 함수");
			this.callback("호호우");
		}
		this.callback = params.func;
	}
	var func = function(re) {
		alert(re);
	};
	var ao = new AjaxObj({url:'./test.jsp',func:func});
	ao.send();
	ao.callback("asdss");
</script>

<body>
	<%
		
	%>
</body>

</html>
