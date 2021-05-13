package in.nevil.service;

import java.util.HashMap;
import java.util.Map;

import in.nevil.validator.UserValidator;

public class UserService {
	
	private UserService() {
		//Default constructor
	}

	private final static Map<Long, String> adminCredentialHashTable = new HashMap<>();

	static {
		adminCredentialHashTable.put(9566087158l, "@Password123");
	}
	
	/**
	 * This method is used to validate the admin credentials that he is a valid
	 * admin or not
	 * 
	 * @param adminUsername
	 * @param adminPassword
	 * @return
	 */
	 
	public static boolean adminValidation(long adminUsername, String adminPassword) {
		boolean isValidAdmin = false;
			
		
		boolean isUserIdValid = UserValidator.userIdValidation(adminUsername);
		boolean isValidPasswordFormat = UserValidator.isValidPasswordFormat(adminPassword);
		if (isUserIdValid && isValidPasswordFormat && adminCredentialHashTable.containsKey(adminUsername) && adminPassword.equals(adminCredentialHashTable.get(adminUsername))) {
						isValidAdmin = true;
		}
		return isValidAdmin;

	}

}
