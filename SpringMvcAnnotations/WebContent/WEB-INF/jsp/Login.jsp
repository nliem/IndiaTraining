<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
	
		<c:out value="Language"/>
		<a href="?lang=en">English</a>
		<a href="?lang=fr">French</a>
		<a href="?lang=de">German</a>
		
		<h1>Spring MVC Application</h1>
		
	
		<spring:message	code="lbl.button.submit" var="btnText" />
	
		<form:form action="" method="post">
			<label><spring:message code="lbl.userName" /></label>
			<form:input path="username" />
			
			<label><spring:message code="lbl.password" /></label>
			<form:input path="password" />
			
			<label><spring:message code="lbl.phonenumber" /></label>
			<form:input path="telephoneNumber" />
			
			<input type="submit" value="${btnText}" />
		</form:form>
	
	</body>
</html>