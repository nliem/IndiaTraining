<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ReadValues.jsp</title>
	</head>
	
	<body>
	
		<div style = "float:right;">
			<p>
				Currently Logged in as: ${currUser}
			
			</p>
		</div>
	
		<p>Is New Session? </p> <%=session.isNew() %>
		<p>Session ID </p> <%= session.getId() %>
	
		<% 
			String username = request.getParameter("userName");
			pageContext.setAttribute("currUser", username, PageContext.SESSION_SCOPE);
			
		%>
		
		<ol>
			<li><a href = "ShowDetails.jsp">Show Details</a></li>
			<li><a href = "#">Contact</a></li>
		</ol>
	</body>
</html>