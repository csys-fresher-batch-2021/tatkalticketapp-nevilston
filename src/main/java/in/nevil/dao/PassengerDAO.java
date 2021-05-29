package in.nevil.dao;

import java.util.ArrayList;
import java.util.List;

import in.nevil.model.Passenger;

public class PassengerDAO {
	private static final List<Passenger> passengerList = new ArrayList<>();

	public static void addPassenger(Passenger passenger) {
		passengerList.add(new Passenger(passenger.getPassengerName(), passenger.getPassangerAge(),
				passenger.getPassengerGender()));
	}

	public static List<Passenger> getPassengerList() {
		return passengerList;
	}
}