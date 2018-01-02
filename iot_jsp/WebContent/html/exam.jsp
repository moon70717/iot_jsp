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
	var no=0;
	function getPersonInfo(){
		
		$.ajax({ 
			url:"./person.jsp",
			data:{"ni":no},
			type:"get",
			success:function(res){
				var person=JSON.parse(res);
				var str="아이디: "+person.id;
				str+="이름: "+person.name+"<br>";
				str+="no: "+person.no+"<br>";
				str+="gender: "+person.gender+"<br>";
				$("#result_div").append(str);
				no=no+1;
			}
		})
		
	}
</script>
<body>
	<input type="button" value="가져오기" onclick="getPersonInfo()" />
	<div id="result_div"></div>
</body>
</html>