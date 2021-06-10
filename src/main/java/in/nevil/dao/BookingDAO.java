package in.nevil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import in.nevil.model.Booking;
import in.nevil.model.FinalBookingDetail;
import in.nevil.util.ConnectionUtil;

public class BookingDAO {
	public void addBookingInfo(Booking  booking) throws ClassNotFoundException, SQLException { 
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO Booking_details (pnr_number,train_name, train_number,journey_date,fare,booked_date_time) values(?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, booking.getPnrNumber());
			pst.setString(2, booking.getTrainName());
			pst.setString(3, booking.getTrainNumber());
			pst.setObject(4, booking.getJourneyDate());
			pst.setInt(5,booking.getCost());
			pst.setObject(6, booking.getDateAndTime());
			pst.executeUpdate();
		}finally {
			ConnectionUtil.close(pst, connection);
		}
	}
	final static List<FinalBookingDetail> bookedDetails = new ArrayList<>();
	public static void getBookedDetails(int user_id,int pnrNumber){
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM Booking_details FULL OUTER JOIN passenger_details  ON  Booking_details=Passenger_details WHERE passenger_id=? & pnr_number=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, user_id);
			pst.setInt(2,pnrNumber);
			rs = pst.executeQuery();
		while (rs.next()) {
			int ticketPNRNumber = rs.getInt("pnr_number");
			String trainName = rs.getString("train_name");
			String trainNumber = rs.getString("train_number");
			LocalDate journeyDate  = (LocalDate) rs.getObject("journey_date");
			int fare = rs.getInt("fare");
			LocalDateTime bookedDate = (LocalDateTime) rs.getObject("booked_date_time");
			String passengerName = rs.getString("passenger_name");
			
			String passengerGender = rs.getString("passenger_gender");
			
			int passengerAge = rs.getInt("passenger_age");

			FinalBookingDetail booking = new FinalBookingDetail(journeyDate, ticketPNRNumber, bookedDate, trainName, trainNumber, fare, passengerName, passengerGender, passengerAge);
			bookedDetails.add(booking);
			
		}
		}catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
	}
	public  List<FinalBookingDetail> getFinalList(){
		System.out.println(bookedDetails);
		return bookedDetails;
	}
}
