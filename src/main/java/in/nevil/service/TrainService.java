package in.nevil.service;

import java.util.List;

import in.nevil.dao.TrainDAO;
import in.nevil.model.Train;

public class TrainService {

	private TrainService() {
		throw new IllegalStateException("Utility class");
	}
	private static TrainDAO trainDAO = new TrainDAO();
	private static List<Train> trainList =TrainDAO.getTrainList();
	// Adding Train Name and Train Number
	

	

	
	@SuppressWarnings("unlikely-arg-type")
	public static boolean addTrain(String newtrainName, String newtrainNumber, int newavailableTickets) {
		//  call validation and check productName
		boolean istrain = false;
		
		if (trainList.contains("newtrainName")) {
			istrain = false;
		} else {
			trainDAO.addTrain(new Train(newtrainName, newtrainNumber, newavailableTickets));
			istrain = true;
		}
		return istrain;
	}

	public static boolean deleteTrain(String trainNumber) {
		Train searchTrain = null;
		boolean isDeleted = false;
		for (Train train : trainList) {
			if (train.getTrainNumber().equalsIgnoreCase(trainNumber)) {
				searchTrain = train;
				break;
			}
		}
		if (searchTrain != null) {
			trainList.remove(searchTrain);
			isDeleted = true;
		}
		return isDeleted;
	}
}
