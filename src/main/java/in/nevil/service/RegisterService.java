package in.nevil.service;

import java.sql.SQLException;
import java.util.List;
import in.nevil.dao.UserDAO;
import in.nevil.exceptions.UserAlreadyRegisteredException;
import in.nevil.model.User;
import in.nevil.validator.Validator;

public class RegisterService {

	private RegisterService() {
		throw new IllegalStateException("Utill class");
	}

	public static boolean passwordMatchCheck(String newPassword, String confirmPassword) {
		boolean isPasswordMatched = false;
		if (newPassword.equals(confirmPassword)) {
			isPasswordMatched = true;
		} else {
			isPasswordMatched = false;
		}
		return isPasswordMatched;
	}

	public static boolean addUser(String userName, long userNumber, String userPassword)
			throws UserAlreadyRegisteredException, ClassNotFoundException, SQLException {
		UserDAO userDAO = new UserDAO();
		List<User> userList = userDAO.getUserList();
		Long userNumbercheck = userNumber;
		boolean isUserRegister = false;
		try {
			boolean isUserIdValid = Validator.userIdValidation(userNumber);
			System.out.println(userNumber);
			boolean isValidPasswordFormat = Validator.isValidPasswordFormat(userPassword);

			for (User user : userList) {
				long registeredNumber = user.getUserNumber();
				if (userNumbercheck == (registeredNumber)) {
					isUserRegister =false;
				} else {
					if (isUserIdValid && isValidPasswordFormat) {
						UserDAO.addUser(new User(0, userName, userNumber, userPassword));
					
						isUserRegister = true;
					}
				}
			}
		} catch (Exception e) {
			throw new UserAlreadyRegisteredException("User Already Available");
		}

		
		return isUserRegister;
	}
}
