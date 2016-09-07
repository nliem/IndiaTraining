<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="../resources/scripts/Script.js" type="text/javascript"></script>
		<link href="../resources/css/Style.css" type="text/css" rel="stylesheet"/>
		<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show All Customers</title>
	</head>
	
	<body>
		<table class="tableStyle">
			<c:forEach items="${customerList}" var="cust">
				<spring:url value="customer/${cust.customerNumber}" var="url" htmlEscape=""/>
			
				<tr>
					<td><a href="${url}">${cust.customerNumber}</a></td>
					<td><c:out value="${cust.customerName}" /></td>
					<td><c:out value="${cust.phoneNumber}" /></td>
				</tr>
			
			
			<!--
			<c:out value="${cust}" />
			<br/>  -->
				</c:forEach>
		</table>
	</body>
</html>