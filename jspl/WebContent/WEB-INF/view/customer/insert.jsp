<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객 정보 추가</title>
</head>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<body>
<h1>고객 정보 추가</h1>
	${result} <br/>
	<form>
		<!-- <input type="text" name="customerId" placeholder="customerId"/> --> <input type="text" name="customerName" placeholder="customerName"/> 
		<input type="text" name="city" placeholder="city"/> <input type="text" name="country" placeholder="country"/> 
		<input type="submit" value="추가"/>
	</form>
</body>
</html>