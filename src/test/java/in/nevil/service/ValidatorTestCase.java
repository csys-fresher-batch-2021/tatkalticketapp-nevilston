package in.nevil.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.nevil.validator.UserValidator;
import in.nevil.validator.FeildValidator;

public class ValidatorTestCase {

	/**
	 * user number invalid format is valid test 
	 */
	@Test
	public void isUserNumberFormatIsInValid() {
		String userNumber ="67798767kab877";
		boolean isValidUserNumber = UserValidator.userIdFormatValidation(userNumber);
		assertFalse(isValidUserNumber);
	}
	/**
	 * user number valid format is valid test 
	 */
	@Test
	public void isUserNumberFormatIsValid() {
		String userNumber ="9566087158";
		boolean isValidUserNumber = UserValidator.userIdFormatValidation(userNumber);
		assertTrue(isValidUserNumber);
	}
	/**
	 *Null employee id is validated
	 */
	@Test
	public void isUserIdNull() { 
		long userNumber = 0;
		boolean isValidUserId = FeildValidator.isUserIdEmptyAndNull(userNumber);
		assertFalse(isValidUserId);
	}
	
	/**
	 * valid long is passed
	 */
	@Test
	public void isUserIdValidCase() { 
		long userNumber = 1234567890l;
		boolean isValidUserId = FeildValidator.isUserIdEmptyAndNull(userNumber);
		assertTrue(isValidUserId);
	}
	
	/**
	 * employeeId is empty
	 */
	@Test
	public void isUserIdEmpty() { 
		long userNumber =000000l;
		boolean isValidUserId = FeildValidator.isUserIdEmptyAndNull(userNumber);
		assertFalse(isValidUserId);
	}
	
	/**
	 *Valid employeeId length  is validated 
	 */
	@Test
	public void isValidEmployeeIdValidLengthTest() { 
		long userNumber = 12345l;
		boolean isValidUserId = FeildValidator.isValidUserIdLength(userNumber);
		assertTrue(isValidUserId);
	}
	
	/**
	 * Invalid employee Id is validated
	 */
	@Test
	public void isValidEmployeeIdInvalidLengthTest() { 
		long employeeName = 267l;
		boolean isValidUserId = FeildValidator.isValidUserIdLength(employeeName);
		assertFalse(isValidUserId);
	}
	
	/**
	 * password is right
	 */
	@Test
	public void isValidPasswordFormatValidTest() { 
		String password =  "@Password123";
		boolean isValidPasswordLength = UserValidator.isValidPasswordFormat(password);
		assertTrue(isValidPasswordLength);
	}
	
	
	

}


