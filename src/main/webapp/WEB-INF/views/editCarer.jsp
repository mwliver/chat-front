<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/form.css" />" rel="stylesheet">

<title>Dodaj opiekuna</title>
</head>
<body>
	<form:form method="post" commandName="carer" class="smart-green">
		<h1>
			Edycja opiekuna <span>Proszę wypełnić wszystkie pola.</span>
		</h1>
		<font color="red"><b>${info}</b></font>

		<form:input type="hidden" path="id" />

		<label> <span>Imie :</span> <form:input type="text"
				path="name" /></label>

		<label> <span>Nazwisko :</span> <form:input type="text"
				path="lastname" /></label>

		<label> <span>Adres :</span> <form:input type="text"
				path="address" /></label>

		<label> <span>Nazwa użytkownika :</span> <form:input
				type="text" path="username" /></label>


		<label> <span>Hasło :</span> <form:input type="text"
				path="password" placeholder="" />
		</label>

		<label> <span>Numer telefonu :</span> <form:input
				path="telephoneNumber" type="text" />

		</label>

		<label> <span>Email :</span> <form:input path="email"
				type="text" />
		</label>

		<label> <span>Kwalifikacje :</span> <form:input path="qualifications"
				type="text" />
		</label>

		<label> <span>Dostępność :</span> <form:input path="availibility"
				type="text" />
		</label>

		<center>
			<label> <span>&nbsp;</span> <input type="submit"
				class="button" value="Edytuj opiekuna" />
			</label> </br> </br> <a class="button" href=<c:url value="/" />><span>Strona
					główna</span></a> <a class="button" href=<c:url value="/manage/carers/list" />><span>Lista
					Opiekunów</span></a>
		</center>
	</form:form>
</body>
</html>