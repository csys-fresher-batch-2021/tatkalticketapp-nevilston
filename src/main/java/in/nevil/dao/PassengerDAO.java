package in.nevil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.nevil.util.ConnectionUtil;
import in.nevil.model.Passenger;

public class PassengerDAO {

	public void addPassenger(Passenger passenger) throws  SQLException, ClassNotFoundException 
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "INSERT INTO passenger_details (passenger_id,passenger_name,passenger_age,passenger_gender) values(?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, passenger.getPassengerBookingId());
			pst.setString(2, passenger.getPassengerName());
			pst.setInt(3, passenger.getPassangerAge());
			pst.setString(4, passenger.getPassengerGender());
			pst.executeUpdate();
		}  finally {
			ConnectionUtil.close(pst, connection);
		}
	}
	public List<Passenger> getPassengerList() throws SQLException, ClassNotFoundException {
		List<Passenger> getPassengerList = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM passenger_details";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int passangerBooKid = rs.getInt("passenger_id");
				
				String passengerName = rs.getString("passenger_name");
				
				String passengerGender = rs.getString("passenger_gender");
				
				int passengerAge = rs.getInt("passenger_age");
        
				Passenger passenger = new Passenger(passangerBooKid,passengerName, passengerAge,passengerGender);
				getPassengerList.add(passenger);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return getPassengerList;
} 