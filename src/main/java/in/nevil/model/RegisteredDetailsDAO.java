package in.nevil.model;

public class RegisteredDetailsDAO {
	private int userid;
	@Override
	public String toString() {
		return "RegisteredDetailsDAO [userid=" + userid + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userMobileNumber=" + userMobileNumber + "]";
	}
	public RegisteredDetailsDAO(int userid, String userName, String userPassword, long userMobileNumber) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMobileNumber = userMobileNumber;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public long getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	private String userName;
	private String userPassword;
	private long userMobileNumber;
	
}
