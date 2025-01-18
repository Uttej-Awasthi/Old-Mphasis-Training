<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page errorPage="error.jsp" %>

<%
	int res=10/0;
	out.println("Value of res is "+res);

	
%>
</body>
</html>