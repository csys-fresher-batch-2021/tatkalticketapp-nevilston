package in.nevil.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import in.nevil.dao.BookingDAO;
import in.nevil.dao.TrainDAO;
import in.nevil.model.Booking;
import in.nevil.model.FinalBookingDetail;
import in.nevil.model.Passenger;

public class DisplayBookingService {
	final static List<Booking> bookingDetails = new ArrayList<>();
	
	public static void summaryBooking(int user_id ,String trainNumber ,String trainName,LocalDate travelDate) throws SQLException, ClassNotFoundException {
		TrainDAO trainDAO = new TrainDAO();
		int trainFare = trainDAO.getTrainFare(trainNumber);
		int totalFare = fareCalculation(trainFare);
		System.out.println(trainFare);
		System.out.println(totalFare);
		int pnrNumber = getPNR();
		String bookedTrainName = trainName;
		String bookedTrainNumber = trainNumber;	
		LocalDateTime bookingDateAndTime =  LocalDateTime.now();  
		LocalDate JourneyDate =travelDate;
		Booking booking = (new Booking(pnrNumber,bookingDateAndTime,bookedTrainName,bookedTrainNumber,JourneyDate,totalFare));
		bookingDetails.add(booking);
		BookingDAO bookingDAO = new BookingDAO();
		bookingDAO.addBookingInfo(booking);
		BookingDAO.getBookedDetails(user_id, pnrNumber);
		List<FinalBookingDetail> bookingList = bookingDAO.getFinalList();
		System.out.println(bookingList);
	}
	public static int getPNR(){
		Random r = new Random( System.currentTimeMillis() );
	    int random = 10000 + r.nextInt(20000);
	    return random;
	}

	public static int fareCalculation(int fare) {
		List<Passenger> tempPassengerList = AddPassenger.getTempPassengerList();
		
		int c = 0;
		int d = 0;
		int totalCost = 0;
		
		for (Passenger passenger : tempPassengerList) {
			
			if (passenger.getPassangerAge() >= 65) {
				
				c++;
			} else {
				d++;
			}
		} if(c==1 & d== 1) {
			double cost1 =((c * fare ) * 0.5);
			double cost2 = ((d * fare));
			totalCost = (int)cost1 +(int)cost2;
		}
		if(c!=0) {
				double cost = ((c * fare) * 0.5);
				totalCost=(int) cost;
			}else if(c==2) {
				double cost = ((c*fare)*0.5);
				totalCost =(int) cost;
			}else if(d==1) {
				double cost = ((d * fare));
				totalCost = (int) cost;
			}else {
				double cost = ((d * fare));
				totalCost = (int) cost;
			}	
		return totalCost;
	}
	public List<Booking> getTempBooking(){
		return bookingDetails;
	}
	
	
}
	