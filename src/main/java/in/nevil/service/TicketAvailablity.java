package in.nevil.service;

import java.util.List;

import in.nevil.dao.TrainDAO;
import in.nevil.model.Train;

public class TicketAvailablity {
	
	
	private TicketAvailablity() {
		//default constructor
	}
	//get the trainList details from the TrainDAO
	private static List<Train> trainList =TrainDAO.getTrainList();
	
	public static boolean checkTicketAvailability(int numberOfTicket) {
		boolean isAvailable = false;
		for (Train train : trainList) {
			/**
			 * per user only Two ticket is allowed and availability check
			 */
			if (train.getAvailableTickets() >= (numberOfTicket) && numberOfTicket <= 2){
				isAvailable = true;
			}
			else {
				isAvailable = false;
			}
		}
		return isAvailable;
	}
}
