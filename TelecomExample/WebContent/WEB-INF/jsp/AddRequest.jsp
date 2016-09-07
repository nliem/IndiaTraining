<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ramesh Telecom</title>
	</head>
	
	<body>
	
		<h2>Please fill out information about your request.</h2>
		
		<hr/>
		
		<form:form action="#" method="post">
			<label>Request Id</label>
			<form:input path="requestId" />
			<span><form:errors path="requestId" /></span>
			<br/>
			
			<label>Customer Id</label>
			<form:input path="customerId" />
			<span><form:errors path="customerId"/></span>
			<br/>
			
			<label>Request Type</label>
			<form:select items="${requestTypes}" path="requestType" />
			<br/>
			
			<label>Description</label>
			<form:textarea path="description"/>
			<br/>
			
			<input type="submit" value="Submit" />
			
		</form:form>
	
	</body>
</html>