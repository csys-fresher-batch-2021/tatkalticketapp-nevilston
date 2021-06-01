package in.nevil.serviceTestCase;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import in.nevil.service.AddPassenger;

public class AddPassengerServiceTest {

	// With Correct Details
	@Test
	public void addPassengerTest() throws ClassNotFoundException, SQLException {
		String passengerName = "Chota Bheem";
		int passengerAge = 23;
		String passengerGender = "Male";
		boolean isValidPassenger = AddPassenger.addPassenger(passengerName, passengerAge, passengerGender);
		assertTrue(isValidPassenger);
	}

	// Entry Null value or empty
	public void addPassengerTestwithNUllValue() throws ClassNotFoundException, SQLException {
	
		String passengerName = null;
		int passengerAge = 0;
		String passengerGender = null;
		boolean isValidPassenger = AddPassenger.addPassenger(passengerName, passengerAge, passengerGender);
		assertFalse(isValidPassenger);
 }
}