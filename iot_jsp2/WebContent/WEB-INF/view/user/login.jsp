<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <link rel="stylesheet" href="<%=rootPath%>/ui/css/sign.css" />
    <body>
        <jsp:include page="/WEB-INF/view/common/header.jsp" flush="false" />
        <div class="result_div"></div>
        <div class="container">
            <div class="login-card">
                    <h1>Log-in</h1><br>
                    <form>
                        <input type="text" id="userId" name="userId" placeholder="UserId">
                        <input type="password" id="userPwd" name="userPwd" placeholder="Password">
                        <input type="button" id="loginBtn" class="login login-submit" value="login" onclick="checkValue()">
                    </form>

                    <div class="login-help">
                        <a href="/view/user/signin">Register</a>
                    </div>
                </div>
        </div>
    </body> 
    <script>
        function checkValue() {
            var objs = $(".container");
            var userId = $("#userId").val().trim();
            var userPwd = $("#userPwd").val().trim();
            if (userId.length < 3) {
                alert("유저아이디 확인해!!");
                $("#userId").focus();
                return;
            }
            if (userPwd.length < 3) {
                alert("비밀번호 확인해!!");
                $("#userPwd").focus();
                return;
            }
            var param = {
                uiId: userId,
                uiPwd: userPwd
            };

            param = "param=" + encodeURIComponent(JSON.stringify(param));
            $.ajax({
                url: '<%=rootPath%>/user/login',
                data: param,
                type: 'get',
                success: function(res) {
                    var obj = JSON.parse(res);
                    alert(obj.msg);
                    if (obj.login == "ok") {
                        location.href = "<%=rootPath%>/";
                    }
                },
                error: function(xhr, status, error) {
                	alert("ㄴㄴ");
                }
            })
        }

    </script>

    </html>
