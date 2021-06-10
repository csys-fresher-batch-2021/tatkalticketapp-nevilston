package in.nevil.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FinalBookingDetail {
	private LocalDate journeyDate;
	private int pnrNumber;
	private LocalDateTime dateAndTime;
	private String trainName;
	private String trainNumber;
	private int cost;
	private String bookedPassengerName;
	private String bookedPassengerGender;
	private int bookedPssengerAge;

	public FinalBookingDetail(LocalDate journeyDate, int pnrNumber, LocalDateTime dateAndTime, String trainName,
			String trainNumber, int cost, String bookedPassengerName, String bookedPassengerGender,
			int bookedPssengerAge) {
		super();
		this.journeyDate = journeyDate;
		this.pnrNumber = pnrNumber;
		this.dateAndTime = dateAndTime;
		this.trainName = trainName;
		this.trainNumber = trainNumber;
		this.cost = cost;
		this.bookedPassengerName = bookedPassengerName;
		this.bookedPassengerGender = bookedPassengerGender;
		this.bookedPssengerAge = bookedPssengerAge;
	}

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

	public String getBookedPassengerName() {
		return bookedPassengerName;
	}

	public void setBookedPassengerName(String bookedPassengerName) {
		this.bookedPassengerName = bookedPassengerName;
	}

	public String getBookedPassengerGender() {
		return bookedPassengerGender;
	}

	public void setBookedPassengerGender(String bookedPassengerGender) {
		this.bookedPassengerGender = bookedPassengerGender;
	}

	public int getBookedPssengerAge() {
		return bookedPssengerAge;
	}

	public void setBookedPssengerAge(int bookedPssengerAge) {
		this.bookedPssengerAge = bookedPssengerAge;
	}

}
