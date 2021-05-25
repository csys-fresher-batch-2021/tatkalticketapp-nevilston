package in.nevil.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.nevil.model.Train;

public class TrainDAO {
	private static final Map<String, Integer> classListPrice = new HashMap<>();
	// Default adding the Class and Fare
	static {
		classListPrice.put("First Class", 760);
		classListPrice.put("Sleeper", 295);
		classListPrice.put("Second Sitting", 180);
	}

	private static final List<Train> trainList = new ArrayList<>();
	static {
		trainList.add(new Train("Madurai Express", "12345M", 120));
		trainList.add(new Train("Pearl City Express", "234451T", 190));
		trainList.add(new Train("Kacheguda Express", "457671C", 200));
	}

	public void addTrain(Train train) {
		trainList.add(new Train(train.getTrainName(), train.getTrainNumber(), train.getAvailableTickets()));
	}

	public static List<Train> getTrainList() {
		return trainList;
	}

	public static Map<String, Integer> getClassList() {
		return classListPrice;
	}

}
