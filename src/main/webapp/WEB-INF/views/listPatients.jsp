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
					<th>Nazwisko</th>
					<th>Adres</th>
					<th>Nazwa użytkownika</th>
					<th>Hasło</th>
					<th>Numer telefonu</th>
					<th>Email</th>
					<th>Opiekun</th>
					<th>Klasyfikacja przypadku</th>
					<th>Objawy</th>
					<th>Data ostatniej modyfikacji</th>
					<th>Usuń</th>
					<th>Edytuj</th>

				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="14"><div id="paging">
							<ul>
								<li><a href=<c:url value="/" />><span>Strona
											główna</span></a></li>
								<li><a href=<c:url value="/manage/patients/save" />><span>Dodaj
											pacjenta</span></a></li>
											<li><font color = "red"><b>${info}</b></font></li>


							</ul>
						</div>
				</tr>
			</tfoot>
			<c:forEach var="patient" items="${patients}">
				<tbody>
					<tr>
						<td>${patient.id}</td>
						<td>${patient.name}</td>
						<td>${patient.lastname}</td>
						<td>${patient.address}</td>
						<td>${patient.username}</td>
						<td>${patient.password}</td>
						<td>${patient.telephoneNumber}</td>
						<td>${patient.email}</td>
						<td>${patient.pernamentCarer.name} ${patient.pernamentCarer.lastname}</td>
						<td>${patient.patientClassification}</td>
						<td>${patient.aliments}</td>
						<td>${patient.lastModification}</td>
						<td><a href=<c:url value="/manage/patients/delete?id=${patient.id}" />
							title="Ostrzeżenie, ta operacja nie może zostać cofnięta !"><span>Usuń</span></a></td>
						<td><a href=<c:url value="/manage/patients/update?id=${patient.id}" />
							title="Przenosi na stronę edycji"><span>Edytuj</span></a></td>


					</tr>
				</tbody>



			</c:forEach>


		</table>
	</div>


</body>
</html>