package in.nevil.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SummaryServlet
 */
@WebServlet("/SummaryServlet")
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("USER_ID");
		String trainName = (String) session.getAttribute("TRAIN_NAME");
		String trainNumber=  (String) session.getAttribute("TRAIN_NUMBER");
		LocalDate travelDate =(LocalDate) session.getAttribute("DATE");
	}

}
