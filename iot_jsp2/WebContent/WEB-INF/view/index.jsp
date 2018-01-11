
<%
	if (user == null) {
		//response.sendRedirect("/view/user/login");
	} else {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IOT_TEST</title>
</head>

<body>
	<jsp:include page="/WEB-INF/view/common/header.jspf" flush="false" />
	<div class="container">

		<div class="starter-template">
			<h1 id="welcome_msg">
				<%=user.getUiName()%>님 환영합니다.
			</h1>
		</div>
	</div>
	<back>
	<div class="video-background">

		<div class="video-foreground">
			<iframe
				src="https://www.youtube.com/embed/XGGooAlUAyg?controls=0&showinfo=0&autoplay=1&loop=1"
				frameborder="0" allowfullscreen></iframe>
		</div>

	</div>
	</back>
</body>

</html>
<%
	}
%>
