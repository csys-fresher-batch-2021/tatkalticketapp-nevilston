<%@page import="in.nevil.model.FinalBookingDetail"%>
<%@page import="java.util.List"%>
<%@page import="in.nevil.dao.BookingDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking History</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3> Booking List</h3>
		<!-- Table Is Created  -->
		<table class="table table-bordered">
			
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">User Id</th>
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
			List<FinalBookingDetail> bookedtickets = bookingDAO.getFinalList();
			int i=0;
			for(FinalBookingDetail bookedTickets:bookedtickets){
				i++;
			%>
			<tr>
					<td><%=i%></td>
					<td><%=bookedTickets.getBookingId()%></td>
					<td><%=bookedTickets.getPnrNumber()%></td>
					<td><%=bookedTickets.getTrainName()%></td>
					<td><%=bookedTickets.getJourneyDate()%></td>
					<td><%=bookedTickets.getJoruneyTime() %></td>
					<td><%=bookedTickets.getCost()%></td>
					<td><a class="btn btn-danger">Cancel</a></td>
				</tr>
				<%} %>
</body>
</html>