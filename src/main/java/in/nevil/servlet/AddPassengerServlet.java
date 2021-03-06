
package in.nevil.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nevil.dao.BookingDAO;
import in.nevil.service.AddPassenger;
import in.nevil.service.DisplayBookingService;
import in.nevil.validator.Validator;

/**
 * Servlet implementation class AddPassengerServlet
 */
@WebServlet("/AddPassengerServlet")
public class AddPassengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookingDAO bookingDAO = new BookingDAO();
		String ticketsNeeded = (String) session.getAttribute("USER_TICKET");
		int id =  (int) session.getAttribute("USER_ID");
		String passengerName = request.getParameter("passengername");
		String time=(String)session.getAttribute("TRAIN_TIME");
		String passengerGender = request.getParameter("gender");
		String age = request.getParameter("passengerAge");
		String trainName = (String) session.getAttribute("TRAIN_NAME");
		String trainNumber=  (String) session.getAttribute("TRAIN_NUMBER");
		LocalDate travelDate =(LocalDate) session.getAttribute("DATE");

		try {
			int tickets = Validator.numberFormater(ticketsNeeded);
			if (tickets == 1) {
				int passengerAge = Integer.parseInt(age);
				boolean addPassenger1 = AddPassenger.addPassenger(id,passengerName, passengerAge, passengerGender);
				AddPassenger.tempPassenger(id, passengerName, passengerAge, passengerGender);
				DisplayBookingService.summaryBooking(id,trainNumber,  trainName, travelDate,time);
				if (addPassenger1) {
					response.sendRedirect("Summary.jsp");
				}
			} else if (tickets == 2) {
				int passengerAge = Integer.parseInt(age);
				String passengerName2 = request.getParameter("passengername2");
				String passengerGender2 = request.getParameter("gender2");
				String age2 = request.getParameter("passengerAge2");
				int passengerAge2 = Integer.parseInt(age2);
				DisplayBookingService.summaryBooking(id,trainNumber,  trainName, travelDate,time);
				boolean addPassenger1 = AddPassenger.addPassenger(id,passengerName, passengerAge, passengerGender);
				boolean addPassenger2 = AddPassenger.addPassenger(id,passengerName2, passengerAge2, passengerGender2);
				AddPassenger.tempPassenger(id, passengerName2, passengerAge2, passengerGender2);
				AddPassenger.tempPassenger(id, passengerName, passengerAge, passengerGender);
				if (addPassenger1 && addPassenger2) {
					bookingDAO.getBookedDetails(id);
					response.sendRedirect("Summary.jsp");
				}
			}
		} catch (Exception e) {
			e.getMessage();

		}
	}
}

