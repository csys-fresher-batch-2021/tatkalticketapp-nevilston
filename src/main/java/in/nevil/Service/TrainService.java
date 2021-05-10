package in.nevil.Service;

import java.util.HashMap;
import java.util.Map;

public class TrainService {
	//Array  initializing 
	private static Map<String, String> trainNames = new HashMap<String, String>();
	// Adding Train Name and Train Number 
	static {
		trainNames.put("12345M", "Madurai Express");
		trainNames.put("234451T", "Pearl City Express");
		trainNames.put("457671C", "Kacheguda Express");
	}
	public static Map<String,String>getDisplayTrainName()  {
		// System.out.println(trainName);// to display the TrainName in Console
		
		return trainNames;
	}

}
