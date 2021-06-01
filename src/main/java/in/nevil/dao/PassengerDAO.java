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
	public static void add(Passenger passenger) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO passenger_details (passenger_name,passenger_age,passenger_gender) values(?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, passenger.getPassengerName());
			pst.setInt(2, passenger.getPassangerAge());
			pst.setString(3,passenger.getPassengerGender());
			pst.executeUpdate();
	} finally {
		ConnectionUtil.close(pst, connection);
	}
}
	public static void getPassengerDetails() throws SQLException {
		List<Passenger> passengerList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM passenger_details";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
			String passengerName = rs.getString("passenger_name");
			int passangerAge = rs.getInt("passenger_age");
			String passngerGender = rs.getString("passenger_gender");
			Passenger passenger = new Passenger(passengerName, passangerAge, passngerGender);
			passengerList.add(passenger);
		}
		}catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
			finally {
			ConnectionUtil.close(pst, connection);
		}
	}
} 