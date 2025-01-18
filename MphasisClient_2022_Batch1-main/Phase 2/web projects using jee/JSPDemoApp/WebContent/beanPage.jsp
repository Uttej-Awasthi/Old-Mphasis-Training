<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Set the value for JavaBean using Scriptlet tag and get the value</h2>
<%
	Employee emp = new Employee();
	emp.setId(100);
	emp.setName("Ravi");
	emp.setSalary(12000);
	out.println("<br/>id is "+emp.getId());
	out.println("<br/>name is "+emp.getName());
	out.println("<br/>salary is "+emp.getSalary());
%>
<h2>Set the value for JavaBean class using jsp action tag</h2>

<jsp:useBean id="emp1" class="com.bean.Employee">
<jsp:setProperty property="id" name="emp1" value="101"/>
<jsp:setProperty property="name" name="emp1" value="Ramesh"/>
<jsp:setProperty property="salary" name="emp1" value="14000"/>
</jsp:useBean>
Id is : <jsp:getProperty property="id" name="emp1"/><br/>
Name is : <jsp:getProperty property="name" name="emp1"/><br/>
Salary is : <jsp:getProperty property="salary" name="emp1"/><br/>

</body>
</html>