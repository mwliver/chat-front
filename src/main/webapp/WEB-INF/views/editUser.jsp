<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/form.css" />" rel="stylesheet">

<title>Edycja danych użytkownika</title>
</head>
<body>

	<form:form  method="post"
		commandName="user" class="smart-green">
		<h1>
			Edycja danych użytkownika <span>Proszę wypełnić odpowiednie pola.</span>
		</h1>
		<font color = "red"><b>${info}</b></font>
		<font color = "red"><b></b></font>
		

		<label> <span>Imię :</span>
		<form:input type="text" path="name" /></label>
		
		<label> <span>Login :</span>
		<form:input type="text" path="login" /></label>
		
		<label> <span>Hasło :</span> <form:input type="text"
			path="password" placeholder="" />
		</label>

		<center><label> <span>&nbsp;</span> <input type="submit"
			class="button" value="Zapisz zmiany" /> </label>
			</br></br><a   class="button" href = <c:url value="/" />><span>Strona główna</span></a>
			<a   class="button" href = <c:url value="/user/list" />><span>Lista użytkowników</span></a>
			</center>
		
		
		
	</form:form>

</body>
</html>