<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	var obj = {
		func1 : function(res) {
			alert(res);
		},
		func2 : function(res) {
			alert(res);
		}
	}
	var func = function(obj) {
		this.callAllFunc = function() {
			obj.func1("t1");
			obj.func2("t2");
		}
	}
	var f = new func(obj);
	f.callAllFunc();

	var Car = function(param) {
		this.wheels = param.p1;
		this.engins = param.p2;
		this.seats = param.p3;
	}

	var c = new car({
		p1 : 1,
		p2 : 2,
		p3 : 3
	});
</script>
<body>

</body>
</html>