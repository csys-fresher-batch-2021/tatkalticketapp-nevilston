package in.nevil.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import in.nevil.model.Booking;
import in.nevil.model.FinalBookingDetail;
import in.nevil.util.ConnectionUtil;

public class BookingDAO {
	public void addBookingInfo(Booking booking) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO Booking_details (pnr_number,train_name, train_number,journey_date,fare,booked_date_time,booking_id,train_time) values(?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, booking.getPnrNumber());
			pst.setString(2, booking.getTrainName());
			pst.setString(3, booking.getTrainNumber());
			pst.setObject(4, booking.getJourneyDate());
			pst.setInt(5, booking.getCost());
			pst.setObject(6, booking.getDateAndTime());
			pst.setInt(7, booking.getBookingId());
			pst.setString(8, booking.getJourneyTime());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	static List<FinalBookingDetail> bookedDetails = new ArrayList<>();

	public void getBookedDetails(int userid) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM booking_details WHERE booking_id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userid);
			rs = pst.executeQuery();
			while (rs.next()) {
				int ticketPNRNumber = rs.getInt("pnr_number");
				String trainName = rs.getString("train_name");
				String trainNumber = rs.getString("train_number");
				Date journeydate = rs.getDate("journey_date");
				LocalDate journeyDate = journeydate.toLocalDate();
				int fare = rs.getInt("fare");
				Timestamp bookeddate = rs.getTimestamp("booked_date_time");
				LocalDateTime bookedDate = bookeddate.toLocalDateTime();
				int userId = rs.getInt("booking_id");
				String journeyTime = rs.getString("train_time");
				FinalBookingDetail booking = new FinalBookingDetail(journeyDate, ticketPNRNumber, bookedDate, trainName,
						trainNumber, fare, userId, journeyTime);
				bookedDetails.add(booking);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
	}

	public List<FinalBookingDetail> getFinalList() {
		return bookedDetails;
	}
}
