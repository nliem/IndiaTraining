<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ramesh Telecom</title>
	</head>
	<body>
	
		<h1>Request List</h1>
		
		<table>
			<c:forEach items="${requestList}" var="request">
				${request}
				<br/>
			</c:forEach>
		</table>
		
		<a href="/TelecomExample">GO HOME</a>
		
	</body>
</html>