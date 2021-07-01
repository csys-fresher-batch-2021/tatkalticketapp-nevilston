<%@page import="in.nevil.model.FinalBookingDetail"%>
<%@page import="java.util.List"%>
<%@page import="in.nevil.dao.BookingDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>My BOOKINGS</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>My Booking List</h3>
		<!-- Table Is Created  -->
		<table class="table table-bordered">
			<caption>Once Booked Cannot Be Cancelled</caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					
					<th scope="col">PNR Number</th>
					<th scope="col">Train Name</th>
					<th scope="col">Journey Date</th>
					<th scope="col">Journey Timing</th>
					<th scope="col">Fare</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			
				<%
				BookingDAO bookingDAO =new BookingDAO();
				int userId=(int) session.getAttribute("USER_ID");
				bookingDAO.getBookedDetails(userId);
				List<FinalBookingDetail> bookedtickets = bookingDAO.getFinalList();
				
				int i=0;
				if(bookedtickets != null){
				for(FinalBookingDetail bookedTickets:bookedtickets){
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=bookedTickets.getPnrNumber()%></td>
					<td><%=bookedTickets.getTrainName()%></td>
					<td><%=bookedTickets.getJourneyDate()%></td>
					<td><%=bookedTickets.getJoruneyTime() %></td>
					<td><%=bookedTickets.getCost()%></td>
					
				</tr>
				<%} %>
				<%} else{
				%>
					<a>No Bookings Done Yet </a>
				<%} %>	
				</table>
				</main>
</body>
</html>