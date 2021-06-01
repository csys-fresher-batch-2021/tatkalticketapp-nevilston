package in.nevil.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nevil.service.TicketAvailablity;
import in.nevil.validator.DateValidator;

/**
 * Servlet implementation class AvailabilityCheck
 */
@WebServlet("/AvailabilityCheck")
public class AvailabilityCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userJourneyDate = request.getParameter("journeydate");
		int numberOfTicket = Integer.parseInt(request.getParameter("ticketnedded"));
		String tickets = request.getParameter("ticketnedded");
		try {
		boolean isValilTicket = TicketAvailablity.checkTicketAvailability(numberOfTicket);
		boolean isValidDate = DateValidator.journeyDateCheck(userJourneyDate);
//		float fareCalculation = TicketAvailablity  
		if (isValidDate && isValilTicket && numberOfTicket == 1 ) {
				String message = "Train Available";
				response.sendRedirect("getPassangerInfromation.jsp?errorMessage=" + message);
				HttpSession session = request.getSession();
				session.setAttribute("USER_TICKET", tickets);
				
		} else if(isValidDate && isValilTicket ) {
			String message ="Train Avialable";
			response.sendRedirect("getPassangerInfromation.jsp?errorMessage=" + message);
			HttpSession session = request.getSession();
			session.setAttribute("USER_TICKET", "2");
		}else {
			String message = "Invalid Date ";
			response.sendRedirect("DateCheck.jsp?errorMessage=" + message);
		}
	
	}catch(Exception e) {
		e.getLocalizedMessage();
	}
		
	}
}
