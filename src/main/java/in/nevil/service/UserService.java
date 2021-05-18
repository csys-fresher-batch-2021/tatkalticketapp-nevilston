package in.nevil.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.nevil.dao.UserDAO;
import in.nevil.model.User;
import in.nevil.validator.UserValidator;

public class UserService {
	
	private UserService() {
		//Default constructor
	}

	private  static Map<Long, String> adminCredentialHashTable = new HashMap<>();
	private static UserDAO userDAO = new UserDAO();
	private static List<User> userList =userDAO.getUserList();
	private static Map<Long,String>userCredentialHashTable = new HashMap<>();

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
	public static boolean userValidation(long userNumber, String userPassword) {
		boolean isValidUser = false;
		 for (User user : userList) {
			 userCredentialHashTable.put(user.getUserNumber(), user.getUserPassword());
	        }
		boolean isUserIdValid = UserValidator.userIdValidation(userNumber);
		boolean isValidPasswordFormat = UserValidator.isValidPasswordFormat(userPassword); 
		if(isUserIdValid && isValidPasswordFormat && userCredentialHashTable.containsKey(userNumber) &&userPassword.equals(userCredentialHashTable.get(userNumber))){
			isValidUser = true;
		}
		return isValidUser;
	}

}
