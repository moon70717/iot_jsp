<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#grid1 {
	text-align: center;
}

#gird1 th, #grid1 td {
	border: 1px solid black;
}
</style>
<body>
	유저리스트
	<br>

	<table id="grid1" data-key="uiNo" class="table">
		<thead>
			<tr>
				<th class="text-center" data-field="uiNo,ro">번호</th>
				<th class="text-center" data-field="uiName,txt">이름</th>
				<th class="text-center" data-field="uiAge,txt">나이</th>
				<th class="text-center" data-field="uiId,ro">ID</th>
				<th class="text-center" data-field="uiRegdate,ro">가입일자</th>
				<th class="text-center" data-field="address,txt">주소</th>
				<th class="text-center" data-field="BTN">버튼</th>
			</tr>
		</thead>
		<tbody id="result_tb">
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.uiNo}</td>
					<td>${user.uiName}</td>
					<td>${user.uiAge}</td>
					<td>${user.uiId}</td>
					<td>${user.uiRegdate}</td>
					<td>${user.address}</td>
					<td>null</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<form>
		<input type="text" placeholder="search by name" name="uiName" /> 
		<input type="submit" value="search" />
	</form>

</body>
<script>
	function onSearch() {
		var el = "${userList}";// 따음표 붙여야됨
		var result_tb = $("#result_tb");
		result_tb.empty();
		var search = $("#searchT").val();
		var param = {
			search : search
		};
		param = "param=" + JSON.stringify(param);
		$.ajax({
			url : '/view/user/search',
			data : param,
			type : 'get',
			success : function(res) {
				var obj = JSON.parse(res);
				alert(obj.msg);
				if (obj.login == "ok") {

					str = '<c:forEach items="${userList}" var="user">';
					str += '<tr>';
					str += '<td>${user.uiNo}</td>';
					str += '<td>${user.uiName}</td>';
					str += '<td>${user.uiAge}</td>';
					str += '<td>${user.uiId}</td>';
					str += '<td>${user.uiRegdate}</td>';
					str += '<td>${user.address}</td>';
					str += '<td>null</td>';
					str += '</tr>';
					str += '</c:forEach>';
					result.html(str);
				}
			},
			error : function(xhr, status, error) {
				alert("ㄴㄴ");
			}
		});
	}
</script>
</html>