<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Customer</title>
	</head>
	<body>
	
		<form:form action="#" method="post">
			<label>Customer Number</label>
			<form:input path="customerNumber" />
			<br/>
			
			<label>Name</label>
			<form:input path="customerName" />
			<br/>
			
			<label>Email</label>
			<form:input path="email" />
			<br/>
			
			<label>Phone Number</label>
			<form:input path="phoneNumber" />
			<br/>
			
			<input type="submit" value="Add" />
		</form:form>
	
	</body>
</html>