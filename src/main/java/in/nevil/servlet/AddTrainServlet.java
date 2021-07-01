package in.nevil.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nevil.service.TrainService;
import in.nevil.validator.Validator;

/**
 * Servlet implementation class AddTrainServlet
 */
@WebServlet("/AddTrainServlet")
public class AddTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		try {
			String trainNumber = request.getParameter("trainNumber");
			String trainName = request.getParameter("trainName");
			String seatAvailable = request.getParameter("seatAvailable");
			int seatAvailables = Validator.numberFormater(seatAvailable);
			String fare = request.getParameter("trainFare");
			int trainFare = Validator.numberFormater(fare);
			String trainTime= request.getParameter("trainTime");
			// checking the TrainList
			boolean isAddTrain = TrainService.addTrain(trainName, trainNumber, seatAvailables, trainFare, trainTime);
			if (isAddTrain) {
				out.println("alert('Train Added ');");
				response.sendRedirect("trainListView.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
			String errorMessage = "Unable to Add Train";
			response.sendRedirect("addTrain.jsp?errorMessage=" + errorMessage);
		}
	}
}
