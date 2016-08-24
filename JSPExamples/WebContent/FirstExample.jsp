<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My First JSP</title>
</head>
<body>

	<% out.println("Welcome to JSP Programming!"); %>
	
	<%! String instanceName = "Ramesh"; %> <%--Global Declaration... at the class level --%>
	
	<%String localName = "Ganesh"; %> <%--Local Declaration ... to Service Method --%>
	
	<%= instanceName %>
	<%= localName %>

</body>
</html>