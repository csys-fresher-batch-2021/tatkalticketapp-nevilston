
package in.nevil.model;

public class Passenger {
	private int passengerBookingId;
	public int getPassengerBookingId() {
		return passengerBookingId;
	}
	public void setPassengerBookingId(int passengerBookingId) {
		this.passengerBookingId = passengerBookingId;
	}
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
	
	public Passenger(int passengerBookingId, String passengerName, int passangerAge, String passengerGender) {
		super();
		this.passengerName = passengerName;
		this.passangerAge = passangerAge;
		this.passengerGender = passengerGender;
		this.passengerBookingId=passengerBookingId;
	}
	@Override
	public String toString() {
		return "Passenger [passengerBookingId=" + passengerBookingId + ", passengerName=" + passengerName
				+ ", passangerAge=" + passangerAge + ", passengerGender=" + passengerGender + "]";
	}
	
}

