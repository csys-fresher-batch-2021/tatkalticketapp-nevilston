package in.nevil.model;

public class Station {
	private int  stationId;
	private String stationCode;
	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", stationCode=" + stationCode + ", stationName=" + stationName
				+ "]";
	}
	public Station(int stationId, String stationCode, String stationName) {
		super();
		this.stationId = stationId;
		this.stationCode = stationCode;
		this.stationName = stationName;
	}
	private String stationName;
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
}
