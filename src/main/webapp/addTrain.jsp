<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add New Train Route</h3>
		<!-- <form action="addproduct_action.jsp">-->
		<form action="AddTrainServlet" method="get">
		<label for="newTrainName">Train Number</label>
		<input type="text" name="trainNumber" placeholder="Enter Train Number" required autofocus />
		<label for="newTrainNumber">Train Name</label>
		<input type="text" name="trainName" placeholder="Enter Train Name" required autofocus />
		<label for="ticketAvailable">Seat Available</label>
		<input type="number" name="seatAvailable" placeholder="Enter Ticket Available" required autofocus />
		<br/>
		<button type="submit">Submit</button>
		</form>
	</main>
</body>
</html>