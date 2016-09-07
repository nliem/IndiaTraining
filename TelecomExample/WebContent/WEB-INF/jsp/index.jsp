<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ramesh Telecom</title>
	</head>
	
	<body>
	
		<h1>Welcome to Ramesh Telecom!</h1>
		
		<a href="request">Submit a Request</a>
		
		<br/>
		
		View requests of type: 
		<form action="request/findRequests" method="get">
			<select name="type">
				<option value="TECHNICAL">Technical</option>
				<option value="PAYMENT RELATED">Payment Related</option>
				<option value="SPECIAL OFFERS">Special Offers</option>
			</select>
		
			<input type="submit" value="View" />
		</form>
	
	</body>
</html>