<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ramesh Telecom</title>
	</head>
	
	<%@ include file="Header.jsp" %>
	
	<body>
		<h1>Request Successfully Submitted!</h1>
	
		${command}
		
		<a href="/TelecomExample">GO HOME</a>
	</body>
</html>