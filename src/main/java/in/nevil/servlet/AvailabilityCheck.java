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
		String userAvailableTickets = request.getParameter("ticketneeded");
		int userNeededSeats = Integer.parseInt(userAvailableTickets);
		try {
		boolean isValidDate = DateValidator.journeyDateCheck(userJourneyDate);
		boolean isTicketValidate = TicketAvailablity.checkTicketAvailability(userNeededSeats);
		if (userAvailableTickets.equalsIgnoreCase("1") && isValidDate && isTicketValidate) {
			HttpSession session = request.getSession();
			session.setAttribute("TICKETS", userAvailableTickets);
			
			response.sendRedirect("getPassangerInfromation.jsp");
		}
		else if(userAvailableTickets.equalsIgnoreCase("2")&& isValidDate && isTicketValidate){
			HttpSession session = request.getSession();
			session.setAttribute("TICKETS", "2");
			response.sendRedirect("getPassangerInfromation.jsp");
			
		} else {
			String message = "Invalid Date or Try With Less Seats ";
			response.sendRedirect("DateCheck.jsp?errorMessage=" + message);
		}
	
	}catch(Exception e) {
		e.getLocalizedMessage();
	}
		
	}
}
