<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Portal</title>
</head>
<style>
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">


		<h2>Welcome</h2>

		<h3>
			<strong> Login</strong>
		</h3>

		<form action="LoginServlet" method="post">
			<input TYPE="radio" name="command" value="Admin" />Admin <Input
				TYPE="radio" name="command" value="User" />User<br> <br /> <input
				type="text" name="adminUsernumber" id="adminUsernumber"
				placeholder="User Number" required autofocus><br /> <br />
			<input type="password" name="adminPassword" id="adminPassword"
				placeholder="password" required><br />
			<%
			final String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
			<br />

			<button class="btn btn-primary">Login</button>
			<br>

		</form>



	</main>
</body>
</html>