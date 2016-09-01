<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Header</title>
		<link rel = "stylesheet" type = "text/css" href = "Style/Header.css" />
		<%@taglib uri = "http://java.sun.com/jsp/jstl/core"	prefix = "c" %>
	</head>
	
	<body>
		<h2 id = "ramesh">Ramesh Taxi Company</h2>
		
		<c:choose>
			
			<c:when test = '${sessionUser == null}'>
				<h4>Welcome, Guest.</h4>
			</c:when>
			
			<c:otherwise>
				<h4 id = "welcome"><c:out value = "Welcome, ${sessionUser}" /></h4>
			</c:otherwise>
		</c:choose> 
		
		
		<div id = "headerBar">
			<a href = "index.jsp">Home</a>
			<a href = "UnderConstruction.jsp">About Us</a>
			<a href = "UnderConstruction.jsp">Our Prices</a>
			<a href = "UnderConstruction.jsp">Image Gallery</a>
			<a href = "UnderConstruction.jsp">Contact</a>
			<a href = "Booking.jsp">Book a Cab</a>
			<a href = "Logout" id = "logout">Logout</a>
		</div>	
	
	</body>
</html>