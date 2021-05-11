package in.nevil.model;

public class Train {
	public String trainName;
	public String trainNumber;
	public int availableTickets;

	public Train(String trainName, String trainNumber, int avilableTickets) {
		super();
		this.trainName = trainName;
		this.trainNumber = trainNumber;
		this.availableTickets = avilableTickets;
	}
	@Override
	public String toString() {
		return "Train [trainName=" + trainName + ", trainNumber=" + trainNumber + ", avilableTickets=" + availableTickets
				+ "]";
	}
	
}
