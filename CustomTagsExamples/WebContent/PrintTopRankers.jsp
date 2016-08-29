<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "domain.StudentRanks"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h1>Top Rankers</h1>
		
		<!--  
		<c:set var="department" value="CS" scope="request"/>
		-->
		
		<table border="2px">
			<tr>
				<td>Student Id</td>
				<td>Student Name</td>
				<td>Mark</td>
				<td>Rating</td>
			</tr>
				
			<c:forEach items = "${requestScope.rankList}" var = "student">
				
				<tr>
					<td><c:out value = "${student.getId()}" /> </td>
					<td><c:out value = "${student.getName()}" /> </td>
					<td><c:out value = "${student.getMark()}" /> </td>
					<td>
					<c:choose>
						<c:when test="${student.getMark() > 90}">
							<c:out value = "*****" />
						</c:when>
						<c:when test="${student.getMark() <= 90 && student.getMark() > 80}">
							<c:out value = "****" />
						</c:when>
						<c:when test="${student.getMark() <= 80 && student.getMark() > 70}">
							<c:out value = "***" />
						</c:when>
						<c:when test="${student.getMark() <= 70 && student.getMark() > 60}">
							<c:out value = "**" />
						</c:when>
						<c:when test="${student.getMark() <= 60 && student.getMark() > 50}">
							<c:out value = "*" />
						</c:when>
						<c:otherwise>
							<c:out value = "0" />
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
				
			</c:forEach>
		
		</table>
		
		
		
		
	</body>
</html>