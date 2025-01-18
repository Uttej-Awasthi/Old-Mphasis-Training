<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login Page</h2>
<form action="checkUser" method="post">
	<label>UserName</label>
	<input type="text" name="user" required="required"><br/>
	<label>Password</label>
	<input type="password" name="pass" required="required"><br/>
	<input type="submit" value="submit">
	<input type="reset" value="reset">
</form>
</body>
</html>