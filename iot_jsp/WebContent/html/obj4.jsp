<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="/js/jquery-3.2.1.js"></script>
<script>
	function checkValue() {
		// id,pwd,name이라는 변수를 가지고있는 var user를 선언하여 화면에있는 
		// 각 id의 값들과 일치하는 element의 값을 저장
		// console.log로 출력하는 예제를 작성해주세요
		var user = {
			id : "",
			pwd : "",
			name : ""
		}
		for ( var key in user) {
			var obj = document.getElementById(key);
			user[key] = obj.value;
		}
		console.log(user);

		var data = "param=" + encodeURIComponent(JSON.stringify(user));
		$.ajax({
			url : "./test.jsp",
			data : data,
			type : "get",
			success : function(res) {
				var objs = JSON.parse(res);
				var str="";
				for(var obj in objs){
					str+=obj+":"+objs[obj]+"<br>";
				}
				document.getElementById("result_div").innerHTML=str;
				
			},
			error : function(xhr, status, error) {
				$("#result_div").html(xhr.responseText);
			}
		});
	}
</script>
<body>
	<input type="text" id="id" />
	<input type="text" id="pwd" />
	<input type="text" id="name" />
	<input type="button" value="값 확인" onclick="checkValue()" />
	<div id="result_div"></div>
</body>
</html>