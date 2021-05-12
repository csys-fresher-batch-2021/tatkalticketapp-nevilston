<%@page import="in.nevil.model.Train"%>
<%@page import="in.nevil.service.TrainService"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<head>
<title>A page written in english</title>
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
					<th scope="col">Available TIckets</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Train> trains = TrainService.getAllTrains();
				int i = 0;
				for (Train train : trains) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=train.getTrainName()%></td>
					<td><%=train.getTrainNumber()%></td>
					<td><%=train.getAvailableTickets()%></td>
					<td><a
						href="DeleteTrainServlet?TrainNumber=<%=train.getTrainNumber()%>"
						class="btn btn-danger">Delete</a>
				</tr>
				<%
				}
				%>
			</tbody>
			<!-- Added the Details of the Train In the Table -->
		</table>
		<a href="addTrain.jsp">Add Train</a>

	</main>
</body>
</html>
