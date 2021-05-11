package in.nevil.service;

import java.util.ArrayList;
import java.util.List;

import in.nevil.model.Train;

public class TrainService {
	
	private TrainService() {
	    throw new IllegalStateException("Utility class");
	  }
	//Array  initializing 
	
	private static List<Train> trainList= new ArrayList<>();	
	// Adding Train Name and Train Number 
	static {
		trainList.add(new Train("Madurai Express","12345M",190));
		trainList.add(new Train("Pearl City Express","234451T",103));
		trainList.add(new Train("Kacheguda Express","457671C",230));
		trainList.add(new Train("Karnataka  Express","654321E",230));
	}
	public static List<Train> getAllTrains() {
		return trainList;
	}

}
