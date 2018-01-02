<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	var car = {
		wheels : 4,
		engines : 1,
		steats : 5
	}
	
	function print(){
		var str="";
		for(var key in car){
			str+=key+":"+car[key]+"<br>";
		}
		var result=document.getElementById("result_div");
        result.innerHTML=str;
	}
</script>
<!-- 위에 사용된 car 변수를 사용하여 result_div에 자동차 휠 갯수: 엔진 갯수: 시트 갯수: 라는 html를 입력하시오-->
<body onload="print()">
<div id="result_div"></div>
</body>
</html>