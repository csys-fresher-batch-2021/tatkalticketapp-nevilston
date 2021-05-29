package in.nevil.model;

public class Passenger {

	private String passengerName;
	private int passangerAge;
	private String passengerGender;
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassangerAge() {
		return passangerAge;
	}
	public void setPassangerAge(int passangerAge) {
		this.passangerAge = passangerAge;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	@Override
	public String toString() {
		return "Passenger [passengerName=" + passengerName + ", passangerAge=" + passangerAge + ", passengerGender="
				+ passengerGender + "]";
	}
	public Passenger(String passengerName, int passangerAge, String passengerGender) {
		super();
		this.passengerName = passengerName;
		this.passangerAge = passangerAge;
		this.passengerGender = passengerGender;
	}
}
