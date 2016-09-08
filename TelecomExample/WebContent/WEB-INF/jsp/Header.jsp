<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Header.css" type="text/css" >
		<link rel="icon" href="${pageContext.request.contextPath}/resources/images/tabicon.png" >
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ramesh Telecom</title>
	</head>
	
	<body>
	
		<div id="rameshHeader">
			<a href="/TelecomExample" id="rameshHome">Ramesh Telecom</a>
		</div>
	
		<div class="container-fluid" id="headerBar">
			<div class="btn-group" role="group" aria-label="...">
				<a href="request"><button type="button" class="btn btn-lg">Submit Request</button></a>
				<a href="/TelecomExample"><button type="button" class="btn btn-lg">Home</button></a>
				<button type="button" class="btn dropdown-toggle btn-lg" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">
					View Requests 
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
    				<li><a href="request/findRequests?type=TECHNICAL">Technical</a></li>
    				<li><a href="request/findRequests?type=PAYMENT+RELATED">Payment Related</a></li>
   					<li><a href="request/findRequests?type=SPECIAL+OFFERS">Special Offers</a></li>
  				</ul>
			</div>
		</div>
	
	</body>
</html>