
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
 
.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

.but {
	text-decoration: none;
	display: inline-block;
	padding: 2px 8px;
	margin: 1px; color : #FFFFFF;
	border: 1px solid #36752D;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #36752D
		), color-stop(1, #275420));
	background: -moz-linear-gradient(center top, #36752D 5%, #275420 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#36752D',
		endColorstr='#275420');
	background-color: #36752D;
	color: #FFFFFF;
}
 
#login-box {
	max-width: 500px;
	padding: 20px;
	background: #fff;
	color: #36752D;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-moz-border-radius: 10px;
	border: 1px solid #36752D;
	font: 20px Arial, Helvetica, sans-serif;
	text-align: center; font : 20px Arial, Helvetica, sans-serif;
	margin-left: auto;
	margin-right: auto;
	background: #F8F8F8;
}
</style>
</head>

<body onload='document.loginForm.username.focus();'>
 ${test}
	<div id="login-box">
	
 
		<h2>Zaloguj sie do Czatu</h2>
 
 
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
 
		<form name='loginForm'
		    action="<c:url value='/login' />" method='POST'>
 
		    <table align ="center">
			<tr>
				<td><b>Nazwa użytkownika: </b></td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td><b>Hasło:</b></td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
			        <td colspan='2' align="center"><br>
                                <input name="submit" type="submit" value="Zaloguj" class="but" />
                                </td>
			</tr>
		   </table>
 
		   <input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
 
</body>
</html>