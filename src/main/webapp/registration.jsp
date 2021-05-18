<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>New User Register</h3>
		<!--HTML Web Page For adding Train -->
		<form action="RegistrationServlet" method="post">
			<label for="newUserName">User Name</label> <input type="text"
				name="userName" pattern="[A-Za-z\s]{3,20}" placeholder="Enter Name"
				required autofocus /><br> <label for="newUserNumber">Mobile
				Number</label> <input type="number" name="userNumber"
				placeholder="Enter Mobile Number" required autofocus /><br> <label
				for="newPassword">New Password</label> <input type="password"
				name="newPassword" placeholder="Enter new Password" required
				autofocus /><br> <label for="confirmNewPassword">Confirm
				New Password</label> <input type="password" name="confirmNewPassword"
				placeholder="Re-Enter new Password" required autofocus /><br>
			<br />
			<button type="submit">Submit</button>
		</form>
	</main>
</body>
</html>