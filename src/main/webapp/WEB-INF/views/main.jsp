<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/mainPage.css" />" rel="stylesheet">
<title>Czat</title>
</head>
<body>
<security:authorize access="hasRole('SUPERADMIN')">

	<div class="main">
		<h1>Czat</h1>
		<ul>
			<li><a href=<c:url value="/message/list" />><span>Wejście do czatu</span></a></li>
			<br>
			<li><a href=<c:url value="/user/list" />><span>Zarządzanie użytkownikami</span></a></li>

			<br>
			<br>
			<li><a href=<c:url value="/logout" />><span>Wyloguj</span></a></li>
		</ul>
	</div>
</security:authorize>
</body>
</html>