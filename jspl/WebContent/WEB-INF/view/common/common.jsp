<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<c:set var="root" value="${rootPath}" />
<nav id="nav">
	<c:forEach items="${menuList}" var="menuL">
		<a href="${rootPath}/${menuL.mUrl}" title="${menuL.mDesc}">${menuL.mName}</a>
		<br />
	</c:forEach> 
</nav>
   