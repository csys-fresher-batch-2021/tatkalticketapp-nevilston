package in.nevil.dao;

import java.util.ArrayList;
import java.util.List;

import in.nevil.model.Train;

public class TrainDAO {
	private static final  List<Train> trainList = new ArrayList<>();
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

}
