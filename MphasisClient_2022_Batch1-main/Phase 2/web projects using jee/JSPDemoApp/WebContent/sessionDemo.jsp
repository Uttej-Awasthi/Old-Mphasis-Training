<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!int count=0; %>
<%
out.println("Count value is "+count);
out.println("<br/>Session id is "+session.getId());
if(session.isNew()){
	out.println("<br/> New Client");
}else {
	out.println("<br/> Old Client");
}
out.println("<br> Session Creation time "+new Date(session.getCreationTime()));
if(count%2==0){
	session.invalidate();
}
count++;
%>
</body>
</html>