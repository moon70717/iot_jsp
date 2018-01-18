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
}
button{
width:50%
}
</style>
</head>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<body>
	<form>
		<input type="text" name="search" id="search" placeholder="이름을 입력하세요"
			value="${search}" /><input type="submit" value="검색" onclick="ch()" name="name"/>
		<input type="text" name="orderStr" value="${orderStr}" class="noo" />
		<input type="text" name="order" value="${order}" class="noo" />
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
			<tr>
				<td>${customer.customerId}</td>
				<td>${customer.customerName}</td>
				<td>${customer.city}</td>
				<td>${customer.country}</td>
				<td><button onclick="deleteCus(${customer.customerId})">삭제</button><button>수정</button></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${root}/view/customer/insert">고객 정보 추가</a>

</body>
<script>   
function deleteCus(cuId) {
    var isDelete = confirm(cuId + "를 삭제하시겠습니까?");
    var param = "cuId=" + cuId;
    alert(cuId);
    if (isDelete) {
        $.ajax({
            url: '${root}/view/customer/delete',
            data: cuId,
            type: 'post',
            success: function() {
                alert("${result}");
                location.reload();
            },
            error: function(xhr, status, error) {

            }
        });
    }
}
</script>
</html>