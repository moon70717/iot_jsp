<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="<%=rootPath%>/ui/css/sign.css" />

<body>
	<jsp:include page="/WEB-INF/view/common/header.jsp" flush="false" />

	<div class="container">
		<div class="login-card" style="">
			<h1>Sign-in</h1>
			<br>
			<form>
				<input type="text" id="uiName" name="uiName" placeholder="UserName">
				<input type="text" id="uiAge" name="uiAge" placeholder="UserAge">
				<input type="text" id="uiId" name="uiId" placeholder="UserId">
				<input type="password" id="uiPwd" name="uiPwd"
					placeholder="UserPassword"> <select name="ciNo" id="ciNo">
					<option value='example'>---select class---</option>
				</select> <input type="text" id="address" name="address"
					placeholder="address"> <input type="submit"
					class="login login-submit" id="singnBtn" value="Signin"
					onclick="signin()">
			</form>
		</div>
	</div>
</body>
<script>
        function signin() {
            //"uiName,uiAge,uiId,uiPwd,ciNo,address"
            var uiName = $("#uiName").val().trim();
            var uiAge = $("#uiAge").val().trim();
            var uiId = $("#uiId").val().trim();
            var uiPwd = $("#uiPwd").val().trim();
            var ciNo = $("#ciNo").val();
            var address = $("#address").val().trim();
            var param = {
                uiName: uiName,
                uiAge: uiAge,
                uiId: uiId,
                uiPwd: uiPwd,
                ciNo: ciNo,
                address: address
            };
            param = "param=" + JSON.stringify(param);
            $.ajax({
                url: '/user/signin',
                type: 'post',
                data: param,
                success: function(res) {
                    var obj = JSON.parse(res);
                    alert(obj.msg);
                    if (obj.result == "ok") {
                        location.href = "/view/user/login";
                    }
                },
                error: function(xhr, status, error) {
					
                }
            })
        }
        $(document).ready(function() {
            $.ajax({
                url: '/class/list',
                type: 'get',
                success: function(res) {
                    var list = JSON.parse(res);
                    var str = "";
                    for (var ci of list) {
                        str += "<option value='" + ci.ciNo + "'>" + ci.ciName + "</option>";
                    }
                    //document.getElementById("ciNo").insertAdjacentHTML("beforeend",str);
                    $("#ciNo").html(str);
                },
                error: function(xhr, status, error) {

                }
            });

        });

    </script>

</html>
