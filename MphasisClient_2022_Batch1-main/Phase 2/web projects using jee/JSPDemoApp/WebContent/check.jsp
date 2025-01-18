<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<%@page import="java.sql.*" %>
<body>
<%!String email,password; %>
<%
response.setContentType("text/html");
email = request.getParameter("email");
password = request.getParameter("password");
if(email.equals("raj@gmail.com") && password.equals("123")){
	out.println("Successfully login");
	%>
	<jsp:forward page="home.jsp"></jsp:forward>
	<% 
}else {
	out.println("Failure try once again");
			%>
		<jsp:include page="login.jsp"></jsp:include>	
			<% 
}
%>
</body>
</html>