<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Employee using Spring Form</h2>
<spring:form action="insertEmployee" modelAttribute="emp" method="post">
<spring:label path="name">Name</spring:label>
<spring:input path="name"/><br/>
<spring:label path="salary">Salary</spring:label>
<spring:input path="salary"/><br/>
<input type="submit" value="submit"/>
<input type="reset" value="reset"/>
</spring:form><br/>
${requestScope.msg}<br/>
<a href="index.jsp">Index page</a>
</body>
</html>