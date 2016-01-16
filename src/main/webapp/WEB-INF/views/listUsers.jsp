<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/table.css" />" rel="stylesheet">

<title>Zarządzanie użytkownikami</title>
</head>
<body>

	<div class="datagrid">
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>Imię</th>
					<th>Login</th>
					<th>Hasło</th>

				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="14"><div id="paging">
							<ul>
								<li><a href=<c:url value="/" />><span>Strona
											główna</span></a></li>
								<li><a href=<c:url value="/user/save" />><span>Dodaj
											użytkownika</span></a></li>
											<li><font color = "red"><b>${info}</b></font></li>


							</ul>
						</div>
				</tr>
			</tfoot>
			<c:forEach var="user" items="${users}">
				<tbody>
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.login}</td>
						<td>${user.password}</td>
						<td><a href=<c:url value="/user/delete?id=${user.id}" />
							title="Ostrzeżenie, ta operacja nie może zostać cofnięta !"><span>Usuń</span></a></td>
						<td><a href=<c:url value="/user/update?id=${user.id}" />
							title="Przenosi na stronę edycji"><span>Edytuj</span></a></td>


					</tr>
				</tbody>



			</c:forEach>


		</table>
	</div>


</body>
</html>