package in.nevil.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nevil.exceptions.CannotAddTrainException;
import in.nevil.service.TrainService;

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
		String trainNumber = request.getParameter("trainNumber");
		String trainName = request.getParameter("trainName");
		int seatAvailables = Integer.parseInt(request.getParameter("seatAvailable"));
		int trainFare = Integer.parseInt(request.getParameter("trainFare"));
	
		try {
		// checking the TrainList
		boolean isAddTrain = TrainService.addTrain(trainName, trainNumber, seatAvailables,trainFare);
		if (isAddTrain) {
			out.println("alert('Train Added ');");
			response.sendRedirect("trainListView.jsp");
			
		} else {
			throw new CannotAddTrainException("Cannot Add Train");
		}
		}catch(Exception e) {
			String errorMessage = "Unable to Add Train";
			response.sendRedirect("addTrain.jsp?errorMessage=" + errorMessage);
		}
	}
}
