<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/view/common/common.jsp"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>login</title>
        </head>
        <link rel="stylesheet" href="/ui/css/sign.css" />
        <script>
            function checkValue() {
                var userId = $("#userId").val().trim();
                var userPwd = $("#userPwd").val().trim();
                if (userId.length < 2) {
                    alert("유저아이디를 확인하세요");
                    $("#userId").focus();
                    return;
                } else if (userPwd.length < 2) {
                    alert("유저 비밀번호를 확인하세요");
                    $("#userPwd").focus();
                    return;
                }
                var param = {
                    uiId: userId,
                    uiPwd: userPwd
                };
                param = "param=" + encodeURIComponent(JSON.stringify(param));
                $.ajax({
                	url:"<%=rootPath%>/user/login",
                    data: param,
                    type: 'get',
                    success: function(res) {
                        var obj = JSON.parse(res);
                        alert(obj.msg);
                        if (obj.login == "ok") {
                            location.href = "/";
                        }
                    }
                });
            }
            $(function() {
                $(".starter-template").keydown(function(event) {
                    if (event.keyCode == 13) {
                        checkValue();
                    }
                });
            });

        </script>

        <body>
            <jsp:include page="/WEB-INF/view/common/header.jsp" flush="false" />
            <div class="container">
                <div class="starter-template">

                    <form class="form-signin">
                        <h2 id="hText2" class="form-signin-heading">로그인</h2>

                        <label for="inputEmail" class="sr-only">ID</label> <input type="text" id="userId" name="userId" class="form-control" placeholder="ID" value="hong" autofocus> <label for="inputPassword" class="sr-only">Password</label> <input type="password" id="userPwd" name="userPwd" class="form-control" placeholder="Password" value="hongP"> <input class="btn btn-lg btn-primary btn-block" type="button" id="loginBtn" value="Login" onclick="checkValue()">
                    </form>
                </div>
            </div> 
            <a href="<%=rootPath%>/view/user/signin">회원가입</a>
        </body>

        </html>
