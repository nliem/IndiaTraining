<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ramesh Taxi</title>
		<link rel = "stylesheet" href = "Style/Main.css" type = "text/css" />
	</head>
	
	<%@include file = "Header.jsp" %>
	
	<body>
	
		<div id = "leftSide">
		
			<h2 id = "loginSpan">User Login</h2>
			<form action = "Validate.jsp" id = "login">
			
				<table border="1" id = "formTable" >
					<tr>
						<td><label for = "email">Email</label></td>
						<td><input type = "email" required name = "email" id = "email"></td>
					</tr>
					
					<tr>
						<td><label for = "password">Password</label></td>
						<td><input type = "password" required name = "password" id = "password"></td>
					</tr>
					
					<tr>
						<td><label for = "city">City</label></td>
						<td>
							<select id = "city" name = "city">
								<option value = "Chicago">Chicago</option>
								<option value = "Honolulu">Honolulu</option>
								<option value = "Toronto">Toronto</option>
								<option value = "Boston">Boston</option>
								<option value = "Gurgaon">Gurgaon</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td><input type = "button" id = "btnReset" value = "Reset">
						<td><input type = "submit" value = "Login" id = "btnSubmit" /></td>
					</tr>
				</table>
			</form>
		
		
		</div>
		
		
		<div id = "rightSide">
		
			<div id = "text">
				<p>Welcome to Ramesh Taxi Company!</p>
			
				<p>The Ramesh Taxi Company, formerly known as "City Radio Taxis", has been operating since 1998.</p>
				
				<p>The Ramesh Taxi Company (RTC), is a locally owned and operated family business,
					servicing Chennai and the Bengaluru, Mumbai, and National Capital Region of 
					Noida, Gurgaon, and Delhi. </p>
					
				<p>The RTC experienced, friendly, and efficient team are committed to providing exceptional
					customer service for all end users.</p>
			</div>
		
		</div>
	
	</body>
</html>