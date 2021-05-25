<%@page import="in.nevil.dao.TrainDAO"%>
<%@page import="java.util.Map"%>
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
			<label for="dateCheck"> Journey Date</label>
			<p>
				<input type="date" name="journeydate"
					placeholder="Enter journey Date " required autofocus></input><br>
			</p>
			<label for="dateCheck">Number of Ticket </label>
			<p>
				<input type="number" name="ticketneeded"
					placeholder="Enter Ticket Needed" required autofocus></input><br>
			<p>
				<%
				final String errorMessage = request.getParameter("errorMessage");
				if (errorMessage != null) {
					out.println("<font color='red'>" + errorMessage + "</font>");
				}
				%>
				<br />
				<button class="btn btn-primary">Check</button>
				<br />
			<h3>Types Of Class Available</h3>
			<table class="table table-bordered" aria-describedby="mydesc">
				<thead>
					<tr>
						<th scope="col">CLASS</th>
						<th scope="col">FARE</th>

					</tr>
				</thead>
				<tbody>
					<%
					final TrainDAO trainDAO = new TrainDAO();
					Map<String, Integer> trainClassList = TrainDAO.getClassList();
					for (String trainClassType : trainClassList.keySet()) {
					%>
					<tr>
						<td><%=trainClassType%></td>
						<td><%=trainClassList.get(trainClassType)%></td>

						<%
						}
						%>

					</tr>
				</tbody>
			</table>

		</form>
	</main>
</body>
</html>