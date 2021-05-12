package in.nevil.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// PrintWriter out = response.getWriter();
		String trainNumber = request.getParameter("trainNumber");
		String trainName = request.getParameter("trainName");
		int seatAvailables = Integer.parseInt(request.getParameter("seatAvailable"));

		// checking the product is in the list or not
		boolean isAddTrain = TrainService.addTrain(trainName, trainNumber, seatAvailables);
		if (isAddTrain) {
			response.sendRedirect("trainListView.jsp");
		} else {
			String errorMessage = "Unable to Add Train";
			response.sendRedirect("addTrain.jsp?errorMessage=" + errorMessage);
		}
	}

}
