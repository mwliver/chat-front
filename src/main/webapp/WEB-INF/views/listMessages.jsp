<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/table.css" />" rel="stylesheet">

<title>Czat</title>
</head>
<body>

	<div class="datagrid">

	<form name='messageForm' action="<c:url value='/message' />" method='POST'>
		<table>
			<c:forEach var="message" items="${messages}">
				<tbody>
					<tr>
						<td>${message.text}</td>
					</tr>
				</tbody>
			</c:forEach>

            <tfoot>

			    <tr>
                    <td><b>Wiadomość: </b></td>
            		<td><input type='text' name='message' value=''></td>
            	</tr>

				<tr>
					<td colspan="13"><div id="paging">
					        <ul>
                    		    <li>

                    		    <a href=<c:url value="/message/save" />><span>Wyślij</span></a>

                    		    </li>
                    		</ul>

							<ul>
								<li><a href=<c:url value="/" />><span>Strona główna</span></a></li>
							</ul>
						</div>
				</tr>
			</tfoot>
		    </table>
	    </form>
	</div>


</body>
</html>