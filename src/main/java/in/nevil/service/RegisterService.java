package in.nevil.service;

import java.util.List;

import in.nevil.dao.UserDAO;
import in.nevil.model.User;
import in.nevil.validator.UserValidator;

public class RegisterService {

	private RegisterService() {
		throw new IllegalStateException("Utill class");
	}
	private static UserDAO userDAO = new UserDAO();
	private static List<User> userList =userDAO.getUserList();
	
	public static boolean passwordMatchCheck(String newPassword,String confirmPassword) {
		boolean isPasswordMatched =false;
		if(newPassword.equals(confirmPassword)) {
			isPasswordMatched=true;
		}
		else {
			isPasswordMatched=false;
		}
		return isPasswordMatched;
	}
	@SuppressWarnings("unlikely-arg-type")
	public static boolean addUser(String userName, long userNumber, String userPassword) {
		//  call validation and check productName
		boolean isUserRegister = false;
		boolean isUserIdValid = UserValidator.userIdValidation(userNumber);
		boolean isValidPasswordFormat = UserValidator.isValidPasswordFormat(userPassword);
		if(userList.contains(userNumber)) {
			isUserRegister = false;
			}
		else {
			if(isUserIdValid&& isValidPasswordFormat) {
			UserDAO.addUser(new User(userName,userNumber,userPassword));
			isUserRegister =true;
		}
		}
		return isUserRegister;
	}
}
