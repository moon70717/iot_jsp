<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:forEach items="${menuList}" var="menuL">
	<a href="<%=request.getContextPath() %>/view${menuL.mUrl}" title="${menuL.mDesc}">${menuL.mName}</a>
	<br/>
</c:forEach>