<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication Page</title>
</head>
<center>
<h2>Login Page</h2>
<body>
<h3> Welcome to the authentication page</h3>

<form:form action="Auth" method="post" commandName="login">
	<label for="username"> Username:</label>
	<input name="username" id="username" type="text" placeholder="Username" required/>
	<br><br>
	<label for="password">Password:</label>
	<input name="password" id="password" type="password" placholder="Password" required/>
	<br><br>
	<input type="submit" name="Submit"/>
</form:form>
</center>
</body>
</html>