package in.nevil.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nevil.dao.TrainDAO;
import in.nevil.service.TrainService;

/**
 * Servlet implementation class DeleteTrainServlet
 */
@WebServlet("/DeleteTrainServlet")
public class DeleteTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		TrainDAO trainDAO = new TrainDAO();
		String trainNumbertodelete = request.getParameter("TrainNumber");
		boolean isDelete = trainDAO.deleteTrainFromTable(trainNumbertodelete);
		if (isDelete) {
			response.sendRedirect("trainListView.jsp");
		} else {
			String errorMessage = "Unable to Delete Train";
			response.sendRedirect("trainListView.jsp?errorMessage=" + errorMessage);
		}
	}

}
