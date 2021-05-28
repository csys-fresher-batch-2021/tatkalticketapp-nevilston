package in.nevil.service;

import java.sql.SQLException;
import in.nevil.exceptions.CannotAddTrainException;
import in.nevil.dao.TrainDAO;
import in.nevil.model.Train;
import in.nevil.validator.TrainServiceValidator;

public class TrainService {

	private TrainService() {
		throw new IllegalStateException("Utility class");
	}

	private static TrainDAO trainDAO = new TrainDAO();

	// Adding Train Name and Train Number

	public static boolean addTrain(String newtrainName, String newtrainNumber, int newavailableTickets)
			throws ClassNotFoundException, SQLException, CannotAddTrainException {
		// call validation and check productName
		boolean istrain = TrainServiceValidator.isTrainNameExists(newtrainNumber);
		Train train = (new Train(newtrainName, newtrainNumber, newavailableTickets));
		if (istrain) {
			throw new CannotAddTrainException(train.getTrainName() + "- Train Already Added");

		} else {
			trainDAO.addTrain(train);
			return true;
			
					}
	}

}
