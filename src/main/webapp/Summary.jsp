<%@page import="in.nevil.service.AddPassenger"%>
<%@page import="in.nevil.model.Passenger"%>
<%@page import="in.nevil.dao.BookingDAO"%>
<%@page import="in.nevil.model.FinalBookingDetail"%>
<%@page import="in.nevil.model.Booking"%>
<%@page import="java.util.List"%>
<%@page import="in.nevil.service.DisplayBookingService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="text-center">
			<h3>Preview Of Ticket</h3>
		</div>
		<%
			DisplayBookingService display = new DisplayBookingService();
				List<Booking> tempBookingList = display.getTempBooking();
				for (Booking details : tempBookingList) {
		%>
		<p>
			Train Number:
			<%=details.getTrainNumber()%>
		</p>
		<p>
			Train Name:<%=details.getTrainName()%></p>
		<p>
			PNR NO:<%=details.getPnrNumber()%></p>
		<p>
			Journey Date:<%=details.getJourneyDate()%>
		</p>
		<p>
			Fare
			<%=details.getCost()%></p>
		<%
			}
		%>
		<table class="table table-bordered">
			<caption>Due to Covid-19 Less Trains Are Operated</caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">Passenger Name</th>
					<th scope="col">Passenger Age</th>
					<th scope="col">Passenger Gender</th>
				</tr>
			</thead>
			<tbody>
				<%
			 
				final List<Passenger> listPassenger = AddPassenger.getTempPassengerList();
				int i = 0;
				for (Passenger passenger : listPassenger) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=passenger.getPassengerName()%></td>
					<td><%=passenger.getPassangerAge()%></td>
					<td><%=passenger.getPassengerGender()%></td>
					<%
						}
					%>
					<tbody>
		</table>
				<div class="text-center">
						<button class="btn btn-primary" type="submit">Book</button>
						<button class="btn btn-danger">Cancel</button>
				</div>

			</main>
			<script>
			
			</script>
</body>
</html>