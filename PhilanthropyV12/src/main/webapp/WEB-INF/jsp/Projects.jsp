<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<%@ include file="Header.jsp" %>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/scripts/Project.js"></script>
		<link href="${pageContext.request.contextPath}/resources/css/Projects.css" rel="stylesheet">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Philanthropy - PROJECTS</title>
	</head>
	
	<body>
	
		<h1 id="projectHeader">Project List</h1>
		
		<table id="projectTable" border="1">
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
					<td class = "link"><span class="viewDonor" data-pid="${project.getProjectId()}">View Donors</span>
				</tr>
			</c:forEach>
		
		</table>
		
		<div id="donorsDiv" style="display: none">
			<h2 id="donorHeader">Project Donors</h2>
			
			<div id="donors">
			
			</div>
		
		</div>
		
		<!-- 
			Nice table. Pretty looking.
			List of projects... 
			Column with link to view donors for the project.
		 -->
	
	</body>
</html>