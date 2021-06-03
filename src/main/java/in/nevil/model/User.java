package in.nevil.model;

public class User {
	private int userId;
	private String userName;
	private long userNumber;
	private String userPassword;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(long userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public User(int userId, String userName, long userNumber, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userNumber = userNumber;
		this.userPassword = userPassword;
	}

}
