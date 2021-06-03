<%@page import="in.nevil.model.Train"%>
<%@page import="java.util.List"%>
<%@page import="in.nevil.dao.TrainDAO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Date Check</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>BOOKING</h3>
		<form action="AvailabilityCheck" method="get">
			<%
				String trainName = request.getParameter("trainName");
			%>
			<h4>
				The Train Selected is <%=trainName%></h4>
			<br /> <label for="dateCheck"> Journey Date</label>
			<p>
				<input type="date" name="journeydate"
					placeholder="Enter journey Date " required autofocus></input><br>
			</p>

			<label for="dateCheck">Number of Ticket </label>
				<input TYPE="radio" name="ticketneeded" value="1" />1
				<Input TYPE="radio" name="ticketneeded" value="2" />2<br> <br /> 
				

				<%
					final String errorMessage = request.getParameter("errorMessage");
				if (errorMessage != null) {
					out.println("<font color='red'>" + errorMessage + "</font>");
				}
				%>
				<br />

				<button class="btn btn-primary">Check</button>
				<br/>
			

				
		</form>
			
	</main>
</body>
</html>