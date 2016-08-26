<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Using Java Bean</title>
		<link type = "text/css" href = "Style/style.css" rel = "stylesheet" />
	</head>
	<body>
	
		<jsp:useBean id = "donor" class = "application.Donor" scope = "session" />
		
		<jsp:setProperty property = "*" name = "donor"/>
		
		<!-- Forward instatiated/populated bean to servlet? -->
		
		<jsp:forward page="/Writer">
			<jsp:param value="donor" name="donorBean"/> 
		</jsp:forward>
		
		
		
		<h2>Thank you for registering as a donor!</h2>
		
		<hr/>
		
		<br/>
		<label>Name:</label>
		<jsp:getProperty property="donorName" name="donor"/>
		<br/>
		
		<label>Email:</label>
		<jsp:getProperty property="email" name="donor"/>
		<br/>
		
		<label>Mobile Number:</label>
		<jsp:getProperty property="mobileNumber" name="donor"/>
		<br/>
	
	</body>
</html>