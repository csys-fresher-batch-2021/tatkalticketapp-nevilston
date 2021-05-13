package in.nevil.validator;
public class feildValidator {
	
	private feildValidator() {
		//Default Constructor
	}
	/**
	 * This method verifies whether an employeeId field is null or empty
	 * @param employeeId
	 * @return
	 */
	public static boolean isUserIdEmptyAndNull(long userId) {  
		boolean isEmployeeNull = true;
			if((userId==0)){
				isEmployeeNull = false;	
			}
		return isEmployeeNull;
	}
	
	/**
	 * This method verifies whether the length of the employeeID is valid or not
	 * @param employeeId
	 * @return
	 */
	
	public static boolean isValidUserIdLength(long userId) {
		boolean isValidEmployeeId = false;
		if(userId== 10) {
			isValidEmployeeId = true;
		}
		return isValidEmployeeId;
	}
	
}
