<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Philanthropy - PROJECTS</title>
	</head>
	<body>
	
		<h1 style="color:red;">PROJECTS PROJECTS PROJECTS PROJECTS PROJECTS </h1>
		
		<table id="projectTable">
			<tr id="labelRow">
				<td>Project Id</td>
				<td>Project Name</td>
				<td>Project Budget</td>
				<td>Amount Collected</td>
				<td>Donors</td>
			</tr>
			
			<c:forEach items="${projects}" var="project">
				<tr>
					<td><c:out value="${project.getProjectId()}"></c:out></td>
					<td><c:out value="${project.getProjectName()}" /></td>
					<td><fmt:formatNumber value="${project.getProjectBudget()}" type="currency" /></td>
					<td><fmt:formatNumber value="${project.getAmountCollected()}" type="currency" /></td>
					<td><a href="DonorList?projectId=${project.getProjectId()}">Donor List</a></td>
				</tr>
			</c:forEach>
		
		</table>
		
		<!-- 
			Nice table. Pretty looking.
			List of projects... 
			Column with link to view donors for the project.
		 -->
	
	</body>
</html>