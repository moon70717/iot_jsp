<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- person.jsp
no: , id: , name: , age: , gender :, address:
exam.jsp
person.jsp에서 넘겨준 저위의 구조를 가지고 파싱을 해서 추가를 해주면 되는데
no 버튼을 클릭할때마다 1++ -->


<script src="/js/jquery-3.2.1.js"></script>
<script>
	function getPersonInfo(){
		$.ajax({
			url:"./test3.jsp",
			type:"get",
			success:function(res){
				var person=JSON.parse(res);
				var str="아이디"+person.id;
				str+="이름"+person.name+"<br>";
				$("#result_div").append(str);
			}
		})
	}
</script>
<body>
<input type="button" value="가져오기" onclick="getPersonInfo()"/>
<div id="result_div"></div>
</body>
</html>