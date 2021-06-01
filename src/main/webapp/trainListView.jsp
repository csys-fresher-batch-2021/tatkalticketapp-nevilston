<%@page import="in.nevil.dao.TrainDAO"%>
<%@page import="in.nevil.model.Train"%>
<%@page import="in.nevil.service.TrainService"%>
<%@page import="java.util.List"%>
<%
String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
String role = (String) session.getAttribute("ROLE");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<head>
<title>Train List</title>
<meta content="text/html; charset=utf-8" />
</head>
<title>Online Train Booking</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List of Trains</h3>
		<!-- Table Is Created  -->
		<table class="table table-bordered">
			<caption>Due to Covid-19 Less Trains Are Operated</caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">Train No</th>
					<th scope="col">Train Name</th>
					<th scope="col">Available Tickets</th>
				</tr>
			</thead>
			<tbody>
				<% 
				final TrainDAO trainDAO = new TrainDAO();
				final List<Train> trainList = trainDAO.getTrainDetails();
				int i =0;
				for(Train train :trainList){
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=train.getTrainNumber()%></td>
					<td><%=train.getTrainName()%></td>
					<td><%=train.getAvailableTickets()%></td>
					<%
					if (loggedInUsername != null && role != null && role.equalsIgnoreCase("USER")) {
					%>
					<td><a href="DateCheck.jsp?trainName=<%=train.getTrainName()%>" class="btn btn-primary">Book</a> <%
 					}
 					%> <%
						 if (loggedInUsername != null && role != null && role.equalsIgnoreCase("ADMIN")) {
						 %>
					<td><a
						href="DeleteTrainServlet?TrainNumber=<%=train.getTrainNumber()%>"
						class="btn btn-danger">Delete</a> <%
 							}
						 %>
				</tr>
				<%
				}
				%>
			</tbody>

			<tbody>
		</table>
	</main>
</body>
</html>
