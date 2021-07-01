<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<!-- Header Page  -->
<%
String loggedInUsername = (String)session.getAttribute("LOGGED_IN_USER");
String role = (String) session.getAttribute("ROLE");
%>
<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Online Train Booking</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="trainListView.jsp">Train Available</a></li>
				<% if (loggedInUsername != null && ! role.equalsIgnoreCase("ADMIN")){ %>

				<li class="nav-item"><a class="nav-link" href="BookedTickets.jsp">Booked Tickets
						</a></li>
				<%} %>
				<% if (loggedInUsername != null && role != null && role.equalsIgnoreCase("ADMIN")){ %>
				<li class="nav-item"><a class="nav-link" href="addTrain.jsp">Add
						Train</a></li>
				<li class="nav-item"><a class="nav-link" href="adminbooking.jsp">Booking Details</a>
				<%} %>
			</ul>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<% if (loggedInUsername == null){ %>
				<li class="nav-item active"><a class="nav-link"
					href="login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link"
					href="registration.jsp">Register</a></li>
				<%} else { %>
				<li class="nav-item"><a class="nav-link" href="#">Welcome <%=loggedInUsername %></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
				</li>
				<%} %>
			</ul>


		</div>
	</nav>
</header>