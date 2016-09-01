<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
	</head>
	
	<%@include file = "Header.jsp" %>
	
	<body>
	
		<h1 id = "confirmationHeader">Your booking is confirmed!</h1>
		
		<h4 id = "subHeader">Please wait, and your cab will arrive shortly. Your booking details are listed below.</h4>
		
		<br/>
		<hr/>
		
		<div id = "bookingInformation">
			${completeBooking.toString()}
		</div>
	
	</body>
</html>