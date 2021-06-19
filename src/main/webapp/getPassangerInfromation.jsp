
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
String ticketneeded = (String) session.getAttribute("USER_TICKET");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Passenger Information</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Enter Passenger Details</h3>
	<form action="AddPassengerServlet" method="get">
	
     <% 
     if (ticketneeded.equalsIgnoreCase("1") && ticketneeded != null){ 
     %>
	<label for="passengerName">Passenger Name</label> 
	<input type="text"name="passengername" placeholder="Enter Name" required autofocus /><br/> 
	<label for="passengerAge">Passenger Age</label>
	<input type="number"name="passengerAge" placeholder="Enter Age" required autofocus /><br/>
	<label for="passengerGender">Passenger Gender :</label>
	<input type="radio" name="gender" value="Male"/>Male
	<input type="radio" name="gender"value="female"/>Female<br>
	<%} %>
	
	
	 <% if (ticketneeded.equalsIgnoreCase("2") && ticketneeded != null){ %>
	 <p>Enter First Passenger Details</p>
	<label for="passengerName">Passenger Name</label> 
	<input type="text"name="passengername" placeholder="Enter Name" required autofocus /><br/> 
	<label for="passengerAge">Passenger Age</label>
	<input type="number"name="passengerAge" placeholder="Enter Age" required autofocus /><br/>
	<label for="passengerGender">Passenger Gender :</label>
	<input type="radio" name="gender" value="Male"/>Male
	<input type="radio" name="gender"value="female"/>Female<br></br>
	
	<p>Enter Second Passenger Details</p>
	<label for="passengerName">Passenger Name </label> 
	<input type="text"name="passengername2" placeholder="Enter Name" required autofocus /><br/> 
	<label for="passengerAge">Passenger Age </label>
	<input type="number"name="passengerAge2" placeholder="Enter Age" required autofocus /><br/>
	<label for="passengerGender">Passenger Gender :</label>
	<input type="radio" name="gender2" value="Male"/>Male
	<input type="radio" name="gender2"value="female"/>Female<br>
	<%} %>
	
	<button type="submit">Submit</button>
	</form>
	</main>
	
</body>


</html>