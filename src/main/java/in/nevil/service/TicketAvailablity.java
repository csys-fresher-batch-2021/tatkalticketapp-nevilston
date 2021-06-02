package in.nevil.service;

import java.sql.SQLException;
import java.util.List;

import in.nevil.dao.TrainDAO;
import in.nevil.exceptions.TicketNotAvailableExceptions;
import in.nevil.model.Train;

public class TicketAvailablity {
	
	
	private TicketAvailablity() {
		//default constructor
	}
	//get the trainList details from the TrainDAO
	
	
	public static boolean checkTicketAvailability(int numberOfTicket) throws ClassNotFoundException, SQLException, TicketNotAvailableExceptions {
		boolean isAvailable = false;
		try {
		TrainDAO trainDAO = new TrainDAO();
		List<Train> trainList =trainDAO.getTrainDetails();
		for (Train train : trainList) {
			/**
			 * per user only Two ticket is allowed and availability check
			 */
			if (train.getAvailableTickets() >= (numberOfTicket) && numberOfTicket <= 2){
				isAvailable = true;
			}
			else {
				isAvailable =false;	
			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return isAvailable;
	}
	
}
