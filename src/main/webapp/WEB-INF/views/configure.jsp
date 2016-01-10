<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/mainPage.css" />" rel="stylesheet">
<title>Konfiguracja agenta dyspozytora</title>
</head>
<body>


	

	<div class="main">
		<h1>Agent dyspozytora</h1>
		<ul>
		
		Status agenta: <b><u>${status}</u></b><br>
		<br><br>
		Maksymalny czas oczekiwania na odpowiedź opiekuna w przypadku alarmu wynosi: <b><u>${time} minut.</u></b><br>
		Po tym czasie następuje przekierowanie alarmu na innego opiekuna.<br><br>
			<li><a href=<c:url value="/dispatcher/configure/updateAgent" />><span>Zmień ustawienia agenta</span></a></li>
			<br><br>
			
			<li><a href=<c:url value="/" />><span>Strona główna</span></a></li>



		</ul>
	</div>

</body>
</html>