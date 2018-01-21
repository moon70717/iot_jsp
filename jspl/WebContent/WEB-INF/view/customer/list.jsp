<%@page import="com.iot.test.vo.Customer"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	color: black;
	text-decoration: none;
}

.noo {
	display: none
}

th, td, input {
	min-width: 60px;
	max-width: 120px;
	white-space: nowrap;
}

button {
	width: 50%
}

td>input[type="submit"] {
	width: 50%;
	min-width: 37px;
}
</style>
</head>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<body>
	<form>
		<input type="text" name="search" id="search" placeholder="이름을 입력하세요"
			value="${search}" /><input type="submit" value="검색" onclick="ch()"
			name="name" /> <input type="text" name="orderStr"
			value="${orderStr}" class="noo" /> <input type="text" name="order"
			value="${order}" class="noo" />
	</form>

	<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<th><a
					href="${root}/view/customer/list?order=customerId&orderStr=${orderStr}">customerId</a></th>
				<th><a
					href="${root}/view/customer/list?order=customerName&orderStr=${orderStr}">customerName</a></th>
				<th><a
					href="${root}/view/customer/list?order=city&orderStr=${orderStr}">city</a></th>
				<th><a
					href="${root}/view/customer/list?order=country&orderStr=${orderStr}">country</a></th>
				<th>설정</th>
			</tr>
			<c:if test="${customerList eq null}">
				<tr>
					<td colspan="5">고객리스트가 없습니다</td>
				</tr>
			</c:if>

			<c:forEach items="${customerList}" var="customer">
				<form id="${customer.customerId}">
				<tr>
					<td><input type="text" value="${customer.customerId}"
						name="cuId" readonly /></td>
					<td><input type="text" value="${customer.customerName}" name="cuName"/></td>
					<td><input type="text" value="${customer.city}" name="city"/></td>
					<td><input type="text" value="${customer.country}" name="country"/></td>
					<td><input type="submit" value="del" name="type"
						onclick="onBtn('del','${customer.customerId}')" /> 
						<input type="submit" value="edit" name="type" onclick="onBtn('edit','${customer.customerId}')"/></td>
				</tr>
				</form>
			</c:forEach>
	</table>

	<a href="${root}/view/customer/insert">고객 정보 추가</a>

</body>
<script>
	function onBtn(ac,no){
		var act=""
		if(ac=='del'){
			act="${rootPath}/customer/delete";
		}else{
			act="${rootPath}/customer/edit";
		}
		var tb=$("#"+no);
		tb.attr("action", act);
	}
</script>
</html>