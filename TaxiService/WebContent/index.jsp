<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ramesh Taxi</title>
		<link rel = "stylesheet" href = "Style/Main.css" type = "text/css" />
		<script type = "text/javascript" src = "Scripts/Main.js"></script>
		<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	</head>
	
	<%@include file = "Header.jsp" %>
	
	<body>
	
		<div id = "leftSide">
		
			<h2 id = "loginSpan">User Login</h2>
			
			<h2 id = "registerUserSpan" hidden = "true">New User Registration</h2>
			
			<form action = "Validate.jsp" id = "loginForm">
			
				<table border="1" id = "loginTable" >
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
								<option disabled selected value = "null">--Select a City--</option>
								<option value = "Chicago">Chicago</option>
								<option value = "Honolulu">Honolulu</option>
								<option value = "Toronto">Toronto</option>
								<option value = "Boston">Boston</option>
								<option value = "Gurgaon">Gurgaon</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td><input type = "button" id = "btnResetLogin" value = "Reset">
						<td><input type = "submit" value = "Login" id = "btnSubmit" /></td>
					</tr>
				</table>
			</form>
			
			<h4 id = "registerSpan" onclick="switchToRegister()">Not yet a user? Register now.</h4>
			
			<form action = "Register.jsp" id = "registerForm" hidden = "true">
				
				<table border = "1" id = "registerTable">
					<tr>
						<td><label for = "name">Name</label></td>
						<td><input type = "text" required name = "name" id = "rname" /></td>
					</tr>
					
					<tr>
						<td><label for = "email">Email</label></td>
						<td><input type = "email" required name = "email" id = "remail"/></td>
					</tr>
					
					<tr>
						<td><label for = "password">Password</label></td>
						<td><input type = "password" required name = "password" id = "rpassword"></td>
					</tr>
					
					<tr>
						<td><label for = "telephone">Telephone</label></td>
						<td><input type = "tel" required name = "telephone" id = "rtelephone" /></td>
					</tr>
					
					<tr>
						<td><label for = "city">City</label></td>
						<td>
							<select id = "rcity" name = "city">
								<option disabled selected value = "null">--Select a City--</option>
								<option value = "Chicago">Chicago</option>
								<option value = "Honolulu">Honolulu</option>
								<option value = "Toronto">Toronto</option>
								<option value = "Boston">Boston</option>
								<option value = "Gurgaon">Gurgaon</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td><input type = "button" id = "btnResetRegistration" value = "Reset">
						<td><input type = "submit" value = "Register" id = "btnSubmit" /></td>
					</tr>
					
				</table>
			</form>
			
			<h4 id = "existingUserSpan" hidden = "true" onclick = "switchToLogin()">Already a user? Login here.</h4>
			
			<div id = "errorDiv">
				<h2><c:out value = "${message}" /></h2>
			</div>
		
		
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