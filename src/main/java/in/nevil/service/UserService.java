package in.nevil.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.nevil.dao.UserDAO;
import in.nevil.model.User;
import in.nevil.validator.Validator;

public class UserService {

	private UserService() {
		// Default constructor
	}

	private static Map<Long, String> adminCredentialHashTable = new HashMap<>();

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

		boolean isUserIdValid = Validator.userIdValidation(adminUsername);
		boolean isValidPasswordFormat = Validator.isValidPasswordFormat(adminPassword);
		if (isUserIdValid && isValidPasswordFormat && adminCredentialHashTable.containsKey(adminUsername)
				&& adminPassword.equals(adminCredentialHashTable.get(adminUsername))) {
			isValidAdmin = true;
		}
		return isValidAdmin;

	}

	public static boolean userValidation(long userNumber, String userPassword) throws ClassNotFoundException, SQLException {
		UserDAO userDAO = new UserDAO();
		List<User> userList = userDAO.getUserList();
		boolean isValidUser = false;
		Map<Long, String> userCredentialHashTable = new HashMap<>();
		for (User user : userList) {
			userCredentialHashTable.put(user.getUserNumber(), user.getUserPassword());
		}
		boolean isUserIdValid = Validator.userIdValidation(userNumber);
		boolean isValidPasswordFormat = Validator.isValidPasswordFormat(userPassword);
		if (isUserIdValid && isValidPasswordFormat && userCredentialHashTable.containsKey(userNumber)
				&& userPassword.equals(userCredentialHashTable.get(userNumber))) {
			isValidUser = true;
		}
		return isValidUser;
	}

}
