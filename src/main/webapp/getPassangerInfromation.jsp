<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String ticketneeded = (String) session.getAttribute("USER_TICKET");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Information</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Enter User Details</h3>
	<form action="#" method="get" >
	<P>Enter Passenger Details </P>
	<%
				if (ticketneeded != null && ticketneeded.equalsIgnoreCase("1")) {
				%>
				<label for="passengerName">Passenger Name</label>
				<input type="text"name="passengername" placeholder="Enter Name" required autofocus /><br/>
				<label for="passengerAge">Passenger Age</label>
				<input type="number"name="passengerAge" placeholder="Enter Age" required autofocus /><br/>
				<label for="passengerGender">Passenger Gender :</label>
				<input type="checkbox" name="gender" value="Male"/>Male
				<input type="checkbox" name="gender"value="female"/>Female<br>
				<%
				}else{
				%>
				<label for="passengerName">Passenger Name</label>
				<input type="text"name="passengername" placeholder="Enter Name" required autofocus /><br/>
				<label for="passengerAge">Passenger Age</label>
				<input type="number"name="passengerAge" placeholder="Enter Age" required autofocus /><br/>
				<label for="passengerGender">Passenger Gender :</label>
				<input type="checkbox" name="gender" value="Male"/>Male
				<input type="checkbox" name="gender"value="female"/>Female<br></br>
				<label for="passengerName">Passenger Name</label>
				<input type="text"name="passengername1" placeholder="Enter Name" required autofocus /><br/>
				<label for="passengerAge">Passenger Age</label>
				<input type="number"name="passengerAge1" placeholder="Enter Age" required autofocus /><br/>
				<label for="passengerGender1">Passenger Gender :</label>
				<input type="checkbox" name="gender1" value="Male"/>Male
				<input type="checkbox" name="gender1"value="female"/>Female<br>
				<%} %>
	</form>
	</main>
	</body>
		
</html>