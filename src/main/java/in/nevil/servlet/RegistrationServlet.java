package in.nevil.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nevil.service.RegisterService;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String number = request.getParameter("userNumber");
		long userNumber = Long.parseLong(number);
		String newUserPassword = request.getParameter("newPassword");
		String confirmnewUserPassword = request.getParameter("confirmNewPassword");
		boolean isPasswordMatched = RegisterService.passwordMatchCheck(newUserPassword, confirmnewUserPassword);
		boolean isAddUser = RegisterService.addUser(userName, userNumber, confirmnewUserPassword);
		if (isAddUser && isPasswordMatched) {
			response.sendRedirect("login.jsp?Message=" + "Registred Sucessfully");
		} else {
			String errorMessage = "Entered Password MissMatch / User Already Registred ";
			response.sendRedirect("registration.jsp?errorMessage=" + errorMessage);
		}

	}

}
