package in.nevil.model;

public class Train {
	private String trainTimeing;
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

	public Train(String trainName, String trainNumber, int avilableTickets , int trainFare,String trainTiming ) {
		this.trainName = trainName;
		this.trainNumber = trainNumber;
		this.availableTickets = avilableTickets;
		this.trainFare=trainFare;
		this.trainTimeing=trainTiming;
	}

	public Train() {
		// Default constructor
	}

	public String getTrainTimeing() {
		return trainTimeing;
	}

	public void setTrainTimeing(String trainTimeing) {
		this.trainTimeing = trainTimeing;
	}
	
}
