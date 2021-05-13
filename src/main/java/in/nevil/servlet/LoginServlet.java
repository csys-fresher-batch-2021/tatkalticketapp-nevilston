package in.nevil.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nevil.service.UserService;

/**
 * Servlet implementation class AdminValidationService
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String loginType = request.getParameter("command");
			String stringAdminNumber =request.getParameter("adminUsernumber");
				long adminUserNumber =Long.parseLong(stringAdminNumber);	
				String adminPassword = request.getParameter("adminPassword");
				boolean isValidAdmin = UserService.adminValidation(adminUserNumber, adminPassword);
				if (isValidAdmin) {
					HttpSession session = request.getSession();
					session.setAttribute("LOGGED_IN_USER", loginType);
					response.sendRedirect("trainListView.jsp");
				}
			}
			catch(Exception e){
				String message = "Invalid Credentials";
				response.sendRedirect("login.jsp?errorMessage=" + message);
			}
		 


		
	}

}
