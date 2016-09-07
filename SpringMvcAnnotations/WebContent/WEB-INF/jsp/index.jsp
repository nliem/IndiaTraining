<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Food Home</title>
	</head>
	<body>
	
		<h1>herroooo</h1>
		
		<a href="addFood">Add a Food</a>
		<br/>
		<a href="addCustomer">Add a Customer</a>
		<br/>
		
		<form action = "addCustomer/findCustomer" method="get">
			<label>Customer Id</label>
			<input name="key" type="text"/>
			<br/>
			
			<input type="submit" value="find" />
		</form>
		
		<form action="addCustomer/showAll" method="get">
			<input type="submit" value="Show All" />
		</form>
		
		<a href="addCustomer/showAll">Show All Customer</a>
	
	</body>
</html>