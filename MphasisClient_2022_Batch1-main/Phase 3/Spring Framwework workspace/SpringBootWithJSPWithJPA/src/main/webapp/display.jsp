<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>All Employee Details</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
		</tr>
		<core:forEach items="${requestScope.listOfEmployee}" var="emp">
			<tr>
			<td><core:out value="${emp.getId()}"></core:out> </td>
			<td><core:out value="${emp.getName()}"></core:out> </td>
			<td><core:out value="${emp.getSalary()}"></core:out> </td>
			</tr>
		</core:forEach>
	</table>
	<br/>
	<a href="index.jsp">Index Page</a>
</body>
</html>