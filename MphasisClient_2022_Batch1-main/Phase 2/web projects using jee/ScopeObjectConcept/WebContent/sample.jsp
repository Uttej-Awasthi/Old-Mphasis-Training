<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//Object obj = request.getAttribute("obj");
Object obj = session.getAttribute("obj");
Integer i = (Integer)obj;
int a = i.intValue();
out.println("<br/> This is JSP page");
out.println("<br/>Value of a "+a);
%>
</body>
</html>