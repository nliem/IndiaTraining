<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Error</title>
		<link rel = "stylesheet" type = "text/css" href = "Style/Suplemental.css" />
	</head>
	
	<%@include file = "Header.jsp" %>
	
	<body>
		<h1 id = "errorHeader" style = "color:red">Uh oh. Something went wrong!</h1>
		
		<h4>Something went wrong processing your request. Please return home.</h4>
		
		<img src="Images/crash.jpg" id = "image">
	</body>
</html>