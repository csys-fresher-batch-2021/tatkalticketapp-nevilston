<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Information</title>
</head>
<body>

     <%
     String str = request.getParameter("ticketneeded");
     int tickets = Integer.parseInt(str);
     while(tickets != 0){
	  %>
	<label for="passengerName">Passenger Name</label> 
	<input type="text"name="passengername" placeholder="Enter Name" required autofocus /><br/> 
	<label for="passengerAge">Passenger Age</label>
	<input type="number"name="passengerAge" placeholder="Enter Age" required autofocus /><br/>
	<label for="passengerGender">Passenger Gender :</label>
	<input type="radio" name="gender" value="Male"/>Male
	<input type="radio" name="gender"value="female"/>Female<br>
	<%
	tickets--;
     }
	%>
</body>
</html>