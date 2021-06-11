
package in.nevil.service;

import java.sql.SQLException;
import java.util.ArrayList;
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
	
	private static PassengerDAO passengerDAO = new PassengerDAO();
	 static  List<Passenger> temPassengerList = new ArrayList<>();
	
	
	//validating the entered details and adding the passenger details

	public static boolean addPassenger(int id,String passengerName, int passengerAge, String passengerGender) throws ClassNotFoundException, SQLException {
		boolean isValidPassenger = false;
		boolean isUserIdValid = FeildValidator.isPassangerAgeEmptyAndNotNull(passengerAge);
		boolean isValidPasswordFormat = Validator.isValidPassengerName(passengerName);
			if (isUserIdValid && isValidPasswordFormat) {

				passengerDAO.addPassenger(new Passenger(id,passengerName, passengerAge, passengerGender));

				isValidPassenger = true;
			}
		return isValidPassenger;
	}	
	public static void  tempPassenger(int id,String passengerName, int passengerAge, String passengerGender ) {
		Passenger passenger = new Passenger(id,passengerName, passengerAge,passengerGender);
		temPassengerList.add(passenger);
		getTempPassengerList();
		
		
	}
	
	public static List<Passenger> getTempPassengerList(){
		return temPassengerList;
		
	}
}

