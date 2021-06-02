package in.nevil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.nevil.ConnectionSql.ConnectionUtil;
import in.nevil.model.User;

public class UserDAO {

	public static void addUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO user_details (user_name,user_mobilenumber, user_password) values(?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, user.getUserName());
			pst.setLong(2, user.getUserNumber());
			pst.setString(3, user.getUserPassword());
			pst.executeUpdate();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public List<User> getUserList() throws SQLException, ClassNotFoundException {
		List<User> userDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM user_details";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				long userMobileNumber = rs.getLong("user_mobilenumber");
				String userPassword = rs.getString("user_password");
				User user = new User(userId,userName, userMobileNumber, userPassword);
				userDetails.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return userDetails;
	}
	
	public int getUserId(long userNumber) throws SQLException {
		int userId= 0;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select user_id  From user_details Where user_mobilenumber=?";
			pst = connection.prepareStatement(sql);
			pst.setLong(1, userNumber);
			rs = pst.executeQuery();
			while(rs.next()) {
			 userId = rs.getInt("user_id");
			}
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return userId;
		
		
	}
	
}
