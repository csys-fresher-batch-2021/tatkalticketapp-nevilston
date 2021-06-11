package in.nevil.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
	
	private LocalDate journeyDate;
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	public int getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	private int pnrNumber; 
	private LocalDateTime dateAndTime;
	private String trainName;
	private String trainNumber;
	private int cost;
	
	
	public Booking( int pnrNumber, LocalDateTime dateAndTime, String trainName, String trainNumber,LocalDate journeyDate,
			int cost) {
		super();
		this.pnrNumber = pnrNumber;
		this.dateAndTime = dateAndTime;
		this.trainName = trainName;
		this.trainNumber = trainNumber;
		this.cost = cost;
		this.journeyDate=journeyDate;
	}
	@Override
	public String toString() {
		return "Booking [journeyDate=" + journeyDate + ", pnrNumber=" + pnrNumber + ", dateAndTime=" + dateAndTime
				+ ", trainName=" + trainName + ", trainNumber=" + trainNumber + ", cost=" + cost + "]";
	}
	
}
