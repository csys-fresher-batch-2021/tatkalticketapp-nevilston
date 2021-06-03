package in.nevil.model;

public class Train {
	private  String trainName;
	private  String trainNumber;
	public int getTrainFare() {
		return trainFare;
	}

	

	private int trainFare;

	public  String getTrainName() {
		return trainName;
	}

	public  String getTrainNumber() {
		return trainNumber;
	}

	public  int getAvailableTickets() {
		return availableTickets;
	}

	private  int availableTickets;

	public Train(String trainName, String trainNumber, int avilableTickets , int trainFare ) {
		this.trainName = trainName;
		this.trainNumber = trainNumber;
		this.availableTickets = avilableTickets;
		this.trainFare=trainFare;
	}

	public Train() {
		// Default constructor
	}
	
}
