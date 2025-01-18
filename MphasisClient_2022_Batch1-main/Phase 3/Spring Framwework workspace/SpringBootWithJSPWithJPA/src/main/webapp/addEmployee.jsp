<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="storeEmployee">
<label>Name</label>
<input type="text" name="name1"><br/>
<label>Salary</label>
<input type="text" name="salary1"><br/>
<input type="submit" value="store employee">
<input type="reset" value="reset">
</form>
${requestScope.msg}<br/>
<a href="index.jsp">Index page</a>
</body>
</html>