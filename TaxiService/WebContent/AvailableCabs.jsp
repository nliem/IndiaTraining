<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	</head>
	
	<%@include file = "Header.jsp" %>
	
	<body>
	
		<h1 id = "availableCabsHeader">
			<c:out value = "Cabs Available in ${location}" />
		</h1>
		
		<table id = "availableCabsTable" border = "1">
			<tr id = "labelRow">
				<td>Cab Number</td>
				<td>Cab Type</td>
				<td>Driver Name</td>
				<td>Book This Cab</td>
			</tr>
		
			<c:forEach items = "${taxis}" var = "taxi">
				<tr>
					<td><c:out value = "${taxi.getCabnumber()}" /></td>
					<td><c:out value = "${taxi.getCabtype()}" /></td>
					<td><c:out value = "${taxi.getDrivername()}"/></td>
					<td><a href = "BookCab?cabNumber=${taxi.getCabnumber()}">Book</a></td>
				</tr>
			
			</c:forEach>
		
		</table>
		
	
	</body>
</html>