
<%@page import="in.nevil.model.Station"%>
<%@page import="in.nevil.dao.StationDAO"%>
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
				String trainNumber =request.getParameter("trainNumber");
				String trainTime =request.getParameter("trainTime");
				session.setAttribute("TRAIN_TIME",trainTime );
				session.setAttribute("TRAIN_NAME", trainName);
				session.setAttribute("TRAIN_NUMBER", trainNumber);
			%>
			<h4>
				The Train Selcted is <%=trainName%> <%=trainNumber%></h4>
				
				
			
			<label for="boardingStation">Boarding Point</label>
					<input type="text"name="boardingStation" placeholder="Boarding Point " required autofocus /><br/>
					<label for="boardingStation">Destination Point</label>
					<input type="text"name="DestinationStation" placeholder="Destination Point " required autofocus /><br/> 
			<br /> <label for="dateCheck"> Journey Date</label>
			<p>
				<input type="date" name="journeydate"
					placeholder="Enter journey Date " required autofocus></input><br>
			</p>
		
			<label for="dateCheck">Number of Ticket </label>
				<input TYPE="radio" name="ticketneeded" value="1" required autofocus />1
				<Input TYPE="radio" name="ticketneeded" value="2" required autofocus/>2<br> <br /> 
				

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
			<table class="table table-bordered">
				<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">Station ID</th>
					<th scope="col">Station Name</th>
					
				</tr>
			</thead>
			<tbody>
			<%
				StationDAO stationDAO = new StationDAO();
				List<Station> station = stationDAO.getStationList(trainNumber);
				int i=0;
				for(Station stationName:station){
					i++;
					
			%>
			<tr>
					<td><%=i%></td>
					
					<td><%=stationName.getStationId()%></td>
					<td><%=stationName.getStationName()%></td>
					
			</tr>
			
			<% } %>
			</tbody>	
	
			
</main>
</body>
</html>
