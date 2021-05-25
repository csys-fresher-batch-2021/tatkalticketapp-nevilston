package in.nevil.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nevil.service.UserService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try { 
			String loginType = request.getParameter("command");
			String stringAdminNumber =request.getParameter("adminUsernumber");
				long adminUserNumber =Long.parseLong(stringAdminNumber);
				String adminPassword = request.getParameter("adminPassword");
				boolean isValidAdmin = UserService.adminValidation(adminUserNumber, adminPassword);
				boolean isValidUser = UserService.userValidation(adminUserNumber, adminPassword);
				if(loginType.equalsIgnoreCase("Admin") && isValidAdmin) {
					HttpSession session = request.getSession();
					session.setAttribute("LOGGED_IN_USER", loginType);
					session.setAttribute("ROLE", "ADMIN");
					response.sendRedirect("trainListView.jsp");
				}
			
				else if(isValidUser){
					HttpSession session = request.getSession();
					session.setAttribute("LOGGED_IN_USER", loginType);
					session.setAttribute("ROLE", "USER");
					response.sendRedirect("trainListView.jsp");
				
			}
				else {
					String message = "Invalid Credentials";
					response.sendRedirect("login.jsp?errorMessage=" + message);
				}
		}catch(Exception e){
			String error = "Enter Valid Number Format ";
			response.sendRedirect("login.jsp?error=" + error);
		}
		
		
	}

}
