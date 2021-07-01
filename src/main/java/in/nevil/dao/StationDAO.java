package in.nevil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.nevil.model.Station;
import in.nevil.util.ConnectionUtil;

public class StationDAO {

	public List<Station> getStationList(String trainNumber){
		List<Station> stationList = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT*from train_station where Station_code=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, trainNumber);
			rs = pst.executeQuery();
			while(rs.next()) {
				int stationId =rs.getInt("station_id");
				String stationName= rs.getString("station_code");
				String stationCode=rs.getString("station_name");
				Station station = new Station(stationId,stationName,stationCode);
				stationList.add(station);
			}
		}catch(ClassNotFoundException |SQLException e) {
			e.getMessage();
		}finally {
			ConnectionUtil.close(rs, pst, connection);
		}

		return stationList;
	}
}
