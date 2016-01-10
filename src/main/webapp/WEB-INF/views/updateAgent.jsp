<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/form.css" />" rel="stylesheet">

<title>Konfiguracja agenta dyspozytora</title>
</head>
<body>
	<form:form method="post" commandName="agent" class="smart-green">
		<h1>
			Edycja ustawień agenta dyspozytora <span>Proszę wypełnić odpowiednie pola.</span>
		</h1>
		<font color="red"><b>${info}</b></font>

		<form:input type="hidden" path="id" />

		<label> <span>Agent aktywny :</span>
		<form:select path="active" id = "active">
				
                    <option  value="true">Tak</option>
                    <c:choose>
                    <c:when test="${agent.active ne true}">
                <option value="false" selected="true">Nie</option>
            </c:when>
            <c:otherwise>
                <option value="false">Nie</option>
                </c:otherwise>
                </c:choose>
   
			</form:select></label>

		<label> <span>Maksymalny czas bezczynności opiekuna w minutach:</span> <form:input type="text"
				path="reassignCarerTime" /></label>


		<center>
			<label> <span>&nbsp;</span> <input type="submit"
				class="button" value="Zmień ustawienia" />
			</label> </br> </br> <a class="button" href=<c:url value="/" />><span>Strona
					główna</span></a> <a class="button" href=<c:url value="/dispatcher/configure" />><span>Strona statusu agenta</span></a>
		</center>
	</form:form>
</body>
</html>