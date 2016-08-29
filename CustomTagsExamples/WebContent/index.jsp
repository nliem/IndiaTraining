<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<%@ taglib uri="/META-INF/MyTags.tld" prefix="mt"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<c:set value = "c:out test" var = "message" scope = "page" />

		<mt:greet message = "${message}" />
		
		<c:out value = "${message}" />
	
	</body>
</html>