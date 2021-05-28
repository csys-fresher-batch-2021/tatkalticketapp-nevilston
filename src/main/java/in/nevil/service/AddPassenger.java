package in.nevil.service;

import java.util.List;

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
	
	@SuppressWarnings("unused")
	private static PassengerDAO passengerDao= new PassengerDAO();
	@SuppressWarnings("unused")
	private static final List<Passenger> passengerList = PassengerDAO.getPassengerList();
	
	
	//validating the entered details and adding the passenger details
	public static boolean addPassenger(String passengerName, int passengerAge, String passengerGender) {
		// call validation and check productName
		boolean isValidPassenger = false;
		boolean isUserIdValid = FeildValidator.isPassangerAgeEmptyAndNotNull(passengerAge);
		boolean isValidPasswordFormat = Validator.isValidPassengerName(passengerName);
			if (isUserIdValid && isValidPasswordFormat) {
				PassengerDAO.addPassenger(new Passenger(passengerName, passengerAge, passengerGender));
				isValidPassenger = true;
			}
		return isValidPassenger;
	}
	
	
}
