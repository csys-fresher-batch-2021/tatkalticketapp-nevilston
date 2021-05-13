package in.nevil.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
		
		private UserValidator() {
			//Default constructor
		}
		
		public static boolean userIdFormatValidation(String userId) {
			boolean isValidFormat= false;
			try {
				@SuppressWarnings("unused")
				long user =Long.parseLong(userId);
				isValidFormat= true;
			}
			catch(Exception e){
				isValidFormat= false;
			}
			return isValidFormat;
		}

		/**
		 * This method is a combined validation method where all the validations are combined to give one result for UserId
		 * @param employeeId
		 * @return
		 */
		
		public static boolean userIdValidation(long userId) {
			boolean isValidAllParameters = false;
			boolean isEmptyAndNull = FeildValidator.isUserIdEmptyAndNull(userId);
			boolean isValidUserIdLength = FeildValidator.isValidUserIdLength(userId);
			
			
			if(isEmptyAndNull && isValidUserIdLength) {
				isValidAllParameters = true;
			}
			return isValidAllParameters;
		}
		/**
		 * This method verifies whether the password is in valid format or not
		 * @param password
		 * @return
		 */
		public static boolean isValidPasswordFormat(String password) {
			 boolean isValidFormat = false;
			 if (password != null) {
				 String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,15}$";
				 Pattern regexPattern = Pattern.compile(regex);
				 Matcher matchCheck = regexPattern.matcher(password);
				 isValidFormat = matchCheck.matches();
			 	}
	 return isValidFormat;
	}
	
	}

