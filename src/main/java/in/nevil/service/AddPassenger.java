package in.nevil.service;

import java.sql.SQLException;

import in.nevil.dao.PassengerDAO;
import in.nevil.model.Passenger;
import in.nevil.validator.FeildValidator;
import in.nevil.validator.Validator;

public class AddPassenger {
	/**
	 * Storing the The passenger User Details 
	 */
	
	private AddPassenger() {
		throw new IllegalStateException("Utill class");
	}
	
	

	
	
	//validating the entered details and adding the passenger details
	public static boolean addPassenger(String passengerName, int passengerAge, String passengerGender) throws ClassNotFoundException, SQLException {
		// call validation and check productName
		boolean isValidPassenger = false;
		boolean isUserIdValid = FeildValidator.isPassangerAgeEmptyAndNotNull(passengerAge);
		boolean isValidPasswordFormat = Validator.isValidPassengerName(passengerName);
			if (isUserIdValid && isValidPasswordFormat) {
				PassengerDAO.add(new Passenger(passengerName, passengerAge, passengerGender));
				isValidPassenger = true;
			}
		return isValidPassenger;
	}
	

	
	
}