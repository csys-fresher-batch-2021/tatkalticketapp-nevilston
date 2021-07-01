package in.nevil.validator;

import java.util.List;

import in.nevil.dao.StationDAO;
import in.nevil.model.Station;

public class StationValidator {

	private StationValidator() {
		// Default Constructor
	}

	public static boolean trainValidator(String sourceStation, String destinationStation, String trainNumber) {
		StationDAO stationDAO = new StationDAO();
		boolean isValid = false;
		List<Station> station = stationDAO.getStationList(trainNumber);
		for (Station stationName : station) {
			if (stationName.getStationName().contains(sourceStation)
					&& stationName.getStationName().contains(destinationStation)
			) {
				isValid = true;

			} else {
				isValid = false;
			}
		}
		return isValid;
	}

}