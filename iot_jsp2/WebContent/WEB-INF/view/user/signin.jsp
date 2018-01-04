<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	$(document).ready(function(){
        $("#nav_li_1").removeClass("active");
        $("#nav_li_3").addClass("active");
        $.ajax({
            url:'/class/list',
            type:'get',
            success:function(res){
                var obj=JSON.parse(res);
                var str="";
                for(var v of obj){
                    $("#cino").append('<option value="">'+v.ciName+'</option>');
                    //str+='<option value="">'+v.ciName+'</option>'
                    
                }
                //document.getElementById("ciNo").insertAdjacentHTML("beforeend",str);
            },
            error:function(xhr,status,error){
            	
            }
        })
    })
</script>
<body>
	<jsp:include page="/WEB-INF/view/common/header.jsp" flush="false"></jsp:include>
	<div class="container">
	<img src="http://i.huffpost.com/gen/4127522/thumbs/o-THE-570.jpg" alt="">
		<table class="table">
			<tr>
				<th>이름</th>
				<td><input type="text" id="uiName" name="uiName"
					class="form-control" placeholder="NAME" autofocus /></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" id="uiAge" name="uiage"
					class="form-control" placeholder="AGE" /></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="uiId" name="uiId"
					class="form-control" placeholder="ID" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" id="uiPwd" name="uiPwd"
					class="form-control" placeholder="PWD" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" id="address" name="address"
					class="form-control" placeholder="ADDRESS" /></td>
			</tr>
			<tr>
				<th>반</th>
				<td><select name="cino" id="cino" class="form-control">
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button"
					class="btn btn-lg btn-primary btn-block" id="singnBtn"
					value="Signin" onclick="" /></td>
			</tr>
		</table>
	</div>

</body>
</html>