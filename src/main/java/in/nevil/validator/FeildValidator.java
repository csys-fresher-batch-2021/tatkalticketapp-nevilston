package in.nevil.validator;

public class FeildValidator {

	private FeildValidator() {
		// Default Constructor
	}

	/**
	 * This method verifies whether an user id is null or empty
	 * 
	 * @param employeeId
	 * @return
	 */
	public static boolean isUserIdEmptyAndNull(long userId) {
		boolean isEmployeeNull = true;
		if ((userId == 0)) {
			isEmployeeNull = false;
		}
		return isEmployeeNull;
	}

	/**
	 * This method verifies whether the length of the employeeID is valid or not
	 * 
	 * @param employeeId
	 * @return
	 */

	public static boolean isValidUserIdLength(long userId) {
		boolean isValidUserId = false;
		if (Long.toString(userId).length() == 10) {
			isValidUserId = true;
		}
		return isValidUserId;
	}
	public static boolean isPassangerAgeEmptyAndNotNull(int age) {
		boolean isValidage=false;
		if(age!=0) {
			isValidage=true;
		}
		else {
			isValidage= false;
		}
		return isValidage;
	}
}
