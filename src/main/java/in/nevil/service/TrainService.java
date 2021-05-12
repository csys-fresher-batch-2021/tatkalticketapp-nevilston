package in.nevil.service;

import java.util.ArrayList;
import java.util.List;

import in.nevil.model.Train;

public class TrainService {

	private TrainService() {
		throw new IllegalStateException("Utility class");
	}
	// Array initializing

	private static List<Train> trainList = new ArrayList<>();
	// Adding Train Name and Train Number
	static {
		trainList.add(new Train("Madurai Express", "12345M", 190));
		trainList.add(new Train("Pearl City Express", "234451T", 103));
		trainList.add(new Train("Kacheguda Express", "457671C", 230));
		trainList.add(new Train("Karnataka  Express", "654321E", 230));
	}

	public static List<Train> getAllTrains() {
		return trainList;
	}

	@SuppressWarnings("unlikely-arg-type")
	public static boolean addTrain(String newtrainName, String newtrainNumber, int newavailableTickets) {
		//  call validation and check productName
		boolean istrain = false;
		
		if (trainList.contains("newtrainName")) {
			istrain = false;
		} else {
			trainList.add(new Train(newtrainName, newtrainNumber, newavailableTickets));
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
