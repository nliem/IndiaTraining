<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ramesh Taxi</title>
	</head>
	
	<body>
		
		<jsp:useBean id = "booking" class = "booking.Booking" scope = "session" />
		
		<jsp:setProperty property="*" name="booking"/>
		
		<jsp:forward page = "/BookNow">
			<jsp:param value = "booking" name = "bookingBean" />
		</jsp:forward> 
	</body>
</html>