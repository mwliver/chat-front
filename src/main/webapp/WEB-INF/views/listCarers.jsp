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
					<th>imie</th>
					<th>Nazwisko</th>
					<th>Adres</th>
					<th>Nazwa użytkownika</th>
					<th>Hasło</th>
					<th>Numer telefonu</th>
					<th>Email</th>
					<th>Kwalifikacje</th>
					<th>Dostepność</th>
					<th>Data ostatniej modyfikacji</th>
					<th>Usuń</th>
					<th>Edytuj</th>

				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="13"><div id="paging">
							<ul>
								<li><a href=<c:url value="/" />><span>Strona
											główna</span></a></li>
								<li><a href=<c:url value="/manage/carers/save" />><span>Dodaj
											opiekuna</span></a></li>
											<li><font color = "red"><b>${info}</b></font></li>


							</ul>
						</div>
				</tr>
			</tfoot>
			<c:forEach var="carer" items="${carers}">
				<tbody>
					<tr>
						<td>${carer.id}</td>
						<td>${carer.name}</td>
						<td>${carer.lastname}</td>
						<td>${carer.address}</td>
						<td>${carer.username}</td>
						<td>${carer.password}</td>
						<td>${carer.telephoneNumber}</td>
						<td>${carer.email}</td>
						<td>${carer.qualifications}</td>
						<td>${carer.availibility}</td>
						<td>${carer.lastModification}</td>
						<td><a href=<c:url value="/manage/carers/delete?id=${carer.id}" />
							title="Ostrzeżenie, ta operacja nie może zostać cofnięta !"><span>Usuń</span></a></td>
						<td><a href=<c:url value="/manage/carers/update?id=${carer.id}" />
							title="Przenosi na stronę edycji"><span>Edytuj</span></a></td>

					</tr>
				</tbody>
			</c:forEach>


		</table>
	</div>


</body>
</html>