package in.nevil.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
	private String journeyTime;
	public String getJourneyTime() {
		return journeyTime;
	}
	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}
	private int bookingId;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
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
	private String boardingStation;
	public String getBoardingStation() {
		return boardingStation;
	}
	public void setBoardingStation(String boardingStation) {
		this.boardingStation = boardingStation;
	}
	public String getDestinationPoint() {
		return destinationPoint;
	}
	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}
	private String destinationPoint;

	
	
	public Booking( int pnrNumber, LocalDateTime dateAndTime, String trainName, String trainNumber,LocalDate journeyDate,
			int cost ,int bookingId,String journeyTime) {
		super();
		this.pnrNumber = pnrNumber;
		this.dateAndTime = dateAndTime;
		this.trainName = trainName;
		this.trainNumber = trainNumber;
		this.cost = cost;
		this.journeyDate=journeyDate;
		this.bookingId=bookingId;
		this.journeyTime=journeyTime;
	}
	@Override
	public String toString() {
		return "Booking [journeyDate=" + journeyDate + ", pnrNumber=" + pnrNumber + ", dateAndTime=" + dateAndTime
				+ ", trainName=" + trainName + ", trainNumber=" + trainNumber + ", cost=" + cost + "]";
	}
	
}
