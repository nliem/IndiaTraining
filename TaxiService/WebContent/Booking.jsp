<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script type = "text/javascript" src = "Scripts/Booking.js"></script>
		<link type = "text/css" rel = "stylesheet" href = "Style/Booking.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
		<title>Insert title here</title>
	</head>
	
	<%@include file = "Header.jsp" %>
	
	<body>
	
		<h1 id = "bookingHeader">Book Taxi</h1>
		
		<form id = "bookingForm" action = "BookNow.jsp" >
		
			<table border = "1" id = "bookingTable">
				<tr id = "emailRow">
					<td><label for = "email">Email</label></td>
					<td colspan="2"><input type = "email" value ="${Email}" name = "customeremail" id = "customeremail"/></td>
				</tr>
				<tr>
					<td><label for = "name">Name</label></td>
					<td colspan="2"><input type = "text" value="${Name}" readonly name = "name" id = "name"/></td>
				</tr>
				
				<tr>
					<td><label for = "telephone">Telephone</label></td>
					<td colspan="2"><input type = "text" value = "${Telephone}" readonly name = "telephone" id = "telephone"/></td>
				</tr>
				
				<tr>
					<td><label for = "chargetype">Booking Type</label></td>
					<td colspan="2">
						<select name = "chargetype" id = "chargetype">
							<option value = "METER">Meter</option>
							<option value = "PACKAGE">Package</option>
							<option value = "OUTSERVICE">Out Service</option>					
						</select>
					</td>
				</tr>
				
				<tr>
					<td><label for = "pickup">Pickup Location</label></td>
					<td colspan="2">
						<select name = "pickup" id = "pickup">
							<option value = "null" disabled selected>--Select a City--</option>
							<option value = "Chicago">Chicago</option>
							<option value = "Honolulu">Honolulu</option>
							<option value = "Toronto">Toronto</option>
							<option value = "Boston">Boston</option>
							<option value = "Gurgaon">Gurgaon</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td><label for = "dropoff">Dropoff Location</label></td>
					<td colspan="2">
						<select name = "dropoff" id = "dropoff">
							<option value = "null" disabled selected>--Select a City--</option>
							<option value = "Chicago">Chicago</option>
							<option value = "Honolulu">Honolulu</option>
							<option value = "Toronto">Toronto</option>
							<option value = "Boston">Boston</option>
							<option value = "Gurgaon">Gurgaon</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td><input type = "button" value = "Reset" id = "btnReset"></td>
					<td><input type = "submit" formaction = "BookNow.jsp" value = "Book Now"/></td>
					<td><input type = "submit" formaction = "BookLater.jsp" value = "Book Later"/></td>
				</tr>
			</table>
		</form>
		
		<div id = "errorDiv">
				<h2><c:out value = "${bookingError}" /></h2>
		</div>
	
	</body>
</html>