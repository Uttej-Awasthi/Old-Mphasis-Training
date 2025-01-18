<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Simple HTML Code</h1>
<%!int a,b,sum; %>
<%
	a=10;
	b=20;
	sum = a+b;
	//out.println("Welcome to JSP Page<br/>");
	out.println("sum of two number is "+sum);
%>
<%-- JSP Comments --%>
<br/>
<p>Sum of two number is <%=10+20 %></p>
<font color="red">Value of a is <%=a %> and <%=b %> and its sum is <%=sum %></font>
</body>
</html>