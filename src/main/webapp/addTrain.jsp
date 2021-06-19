<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Train</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add New Train Route</h3>
		<!--HTML Web Page For adding Train -->
		<form action="AddTrainServlet" method="get">
			<label for="newTrainName">Train Number</label> <input type="text"
				name="trainNumber" placeholder="Enter Train Number" required
				autofocus /> <br/><label for="newTrainNumber">Train Name</label> <input
				type="text" name="trainName" placeholder="Enter Train Name" required
				autofocus /> <br/><label for="ticketAvailable">Seat Available</label> <input
				type="number" name="seatAvailable"
				placeholder="Enter Ticket Available" required autofocus /> <br />
				<label for="trainfare">Train Fare</label> <input
				type="number" name="trainFare"
				placeholder="Enter Train Fare " required autofocus /> <br />
				<label for="trainTime">Train Time</label>
				<input type="text" name="trainTime" placeholder="Enter Train Depature Time" required autofocus /><br/>
			<button type="submit">Submit</button>
		</form>
	</main>
</body>
</html>