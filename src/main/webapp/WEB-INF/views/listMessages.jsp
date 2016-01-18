<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/table.css" />" rel="stylesheet">

<title>Czat</title>
</head>
<body>
	<div class="datagrid">
		<h2>Wiadomości</h2>

        <table>
            <tbody>
		        <c:forEach var="message" items="${messages}">
        		    <tr>
        			    <td>${message.createDate} :  ${message.text}</td>
        			</tr>
                </c:forEach>
       		</tbody>
        </table>

		<form name='messageForm'
		    action="<c:url value='/message/save' />" method='POST'>

		    <table>
			<tr>
				<td><b>Wiadomość: </b>

				<input type='text' name='text' value=''></td>
			</tr>
			        <td colspan='2' align="center"><br>
                                <input name="submit" type="submit" value="Wyślij" class="button" />

                    <a class="button" href=<c:url value="/" />><span>Strona
                    					główna</span></a>
                    </td>
			</tr>
		   </table>

		   <input type="hidden"
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>