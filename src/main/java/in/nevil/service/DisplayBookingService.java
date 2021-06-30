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
	static List<Booking> bookingDetails = new ArrayList<>();

	public static void summaryBooking(int userid ,String trainNumber ,String trainName,LocalDate travelDate,String jourenytime) throws SQLException, ClassNotFoundException {
		TrainDAO trainDAO = new TrainDAO();
		int trainFare = trainDAO.getTrainFare(trainNumber);
		int totalFare = fareCalculation(trainFare);
		int userId=userid;
		String jourenyTime=jourenytime;
		int pnrNumber = getPNR();
		String bookedTrainName = trainName;
		String bookedTrainNumber = trainNumber;
		LocalDateTime bookingDateAndTime =  LocalDateTime.now();
		LocalDate journeyDate =travelDate;
		Booking booking = (new Booking(pnrNumber,bookingDateAndTime,bookedTrainName,bookedTrainNumber,journeyDate,totalFare,userId,jourenyTime));
		bookingDetails.add(booking);
		BookingDAO bookingDAO = new BookingDAO();
		bookingDAO.addBookingInfo(booking);
		bookingDAO.getBookedDetails(userid);
		@SuppressWarnings("unused")
		List<FinalBookingDetail> bookingList = bookingDAO.getFinalList();
	}
	public static int getPNR(){
		Random r = new Random( System.currentTimeMillis() );
		return ( 10000 + r.nextInt(20000));
	}

	public static int fareCalculation(int fare) {
		List<Passenger> tempPassengerList = AddPassenger.getTempPassengerList();
		int c = 0;
		int d = 0;
		int totalCost = 500;
		for (Passenger passenger : tempPassengerList) {
			if (passenger.getPassangerAge() >= 65) {

				c++;
			} else {
				d++;
			}
		}
		if(c==1||c==2){
			double cost1=((c* fare)* 0.5);
			totalCost=(int)cost1;
		}
		else if(d==1&&c==1) {
			double cost1=((c* fare)* 0.5);
			double cost2=((d*fare));
			totalCost=(int)cost1+(int)cost2;
		}
		if(c==0&&d<=2) {
			double cost1=((d*fare));
			totalCost=(int)cost1;
		}else if(d==0&&c<=2) {
			double cost1=((c* fare)* 0.5);
			totalCost=(int)cost1;
		}
		return totalCost;
	}
	public List<Booking> getTempBooking(){
		return bookingDetails;
	}
}
