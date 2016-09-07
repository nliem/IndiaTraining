<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Food</title>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	</head>
	<body>
	
		<form:form action="#" method="post">
			<label>Food Code</label>
			<form:input path="foodCode"/>
			<span style="color:red"><form:errors path="foodCode" /></span>
			<br/>
			
			<label>Description</label>
			<form:input path="description" />
			<span style="color:red"><form:errors path="description" /></span>
			<br/>
			
			<label>Price</label>
			<form:input path="price" />
			<br/>
			
			<label>Cuisine</label>
			<form:select items="${refData}" path="cuisine" />
			<br/>
			
			<input type="submit" value="Add"/>
		</form:form>
	
	</body>
</html>