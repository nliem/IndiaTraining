<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Error</title>
	</head>
	
	<body>
		<h2 style="color:red"><span>${message}</span></h2>
		Error cause: ${cause}
		<br/>
		
		Exception class: ${exceptionClass}
		<br/>
		
		Request uri: ${rqeuestUri}
		<br/>
	</body>
</html>