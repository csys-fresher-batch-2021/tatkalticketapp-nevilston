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
		<table class="table table-bordered">
		<thead>
		<tr>
		<th scope="col" >S.NO</th>
		<th scope="col">Train No</th>
		<th scope="col">Train Name</th>
		<th scope="col">Available TIckets</th>
		</tr>
		</thead>
		<tbody>
		<%
		List<Train> trains=TrainService.getAllTrains();
		int i=0;
		for(Train train:trains){
		i++;
		%>
		<tr>
		<td><%=i%></td>
		<td><%=train.trainNumber%></td>
		<td><%=train.trainName%></td>
		<td><%=train.availableTickets%></td>
		</tr>
		<%} %>
		</tbody>
		
		
		
		
	
		</table>
		
		
	</main>
</body>
</html>
