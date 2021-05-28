package in.nevil.validator;

import java.sql.SQLException;
import java.util.List;
import in.nevil.dao.TrainDAO;
import in.nevil.model.Train;

public class TrainServiceValidator {
	
	private TrainServiceValidator() {
		//Default Constructor
	}
	
	
	
	
	public static boolean isTrainNameExists(String trainNumber) throws ClassNotFoundException, SQLException {
		boolean istrain =false;
		TrainDAO trainDAO = new TrainDAO();
		List<Train> trainList = trainDAO.getTrainDetails();
		
		
		for(Train train: trainList) {
			
			
		if(trainNumber.equals(train.getTrainNumber())) {
			istrain=true;
		}
		else {
			istrain =false;
		}
		
	}
		return istrain;
	}
}
