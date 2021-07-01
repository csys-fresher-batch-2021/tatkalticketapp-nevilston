
package in.nevil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.nevil.model.Train;
import in.nevil.util.ConnectionUtil;

public class TrainDAO {
	//adding new details train details
	public void addTrain(Train train) throws  SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO train_details (train_name,train_number,seats_avaialble,train_fare,train_timing) values(?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, train.getTrainName());
			pst.setString(2, train.getTrainNumber());
			pst.setInt(3, train.getAvailableTickets());
			pst.setInt(4,train.getTrainFare());
			pst.setString(5, train.getTrainTimeing());
			pst.executeUpdate();
		}  catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}
	//getting and displaying train details
	public List<Train> getTrainDetails() throws SQLException, ClassNotFoundException {
		List<Train> trainDetails = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM train_details";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String trainNumber = rs.getString("train_number");
				String trainName = rs.getString("train_name");
				int seats = rs.getInt("seats_avaialble");
				int fare = rs.getInt("train_fare");
				String timing = rs.getString("train_timing");
				Train train = new Train(trainName, trainNumber, seats,fare,timing);
				trainDetails.add(train);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return trainDetails;
	}

	// delete train from table
	public boolean deleteTrainFromTable(String trainNumber)  {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isdeleted = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql ="DELETE FROM train_details WHERE train_number=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, trainNumber);
			pst.executeUpdate();
			isdeleted = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isdeleted;
	}
	public int getTrainFare(String trainNumber) throws SQLException {
		int fare =0;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql ="select train_fare from train_details Where train_number=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, trainNumber);
			rs = pst.executeQuery();
			while (rs.next()) {
				fare = rs.getInt("train_fare");
			}
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return fare;
	}
}

