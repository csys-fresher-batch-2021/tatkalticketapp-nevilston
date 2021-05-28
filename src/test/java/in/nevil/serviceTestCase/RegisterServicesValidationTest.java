package in.nevil.serviceTestCase;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import in.nevil.exceptions.UserAlreadyRegisteredException;
import in.nevil.service.RegisterService;

public class RegisterServicesValidationTest {

	
	// user number is empty
	@Test
	public void registerUsertestWithUserNumberNull()
			throws ClassNotFoundException, UserAlreadyRegisteredException, SQLException {
		String userName = "Deo";
		long userMobileNumber = 0l;
		String Password = "Lobo@9145";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertFalse(inValidRegistration);
	}

	// user number invalidFormat is empty
	@Test
	public void registerUsertestWithUserNumberInvalidFormat()
			throws ClassNotFoundException, UserAlreadyRegisteredException, SQLException {
		String userName = "Deo";
		long userMobileNumber = 89848l;
		String Password = "Lobo@9145";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertFalse(inValidRegistration);
	}

	// invalid password format missing "@"
	@Test
	public void registerUsertestWithUserPasswordInvalidFormat()
			throws ClassNotFoundException, UserAlreadyRegisteredException, SQLException {
		String userName = "Deo";
		long userMobileNumber = 89848l;
		String Password = "Lobo9145";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertFalse(inValidRegistration);
	}

	// Empty Password
	@Test
	public void registerUsertestWithUserPasswordEmpty()
			throws ClassNotFoundException, UserAlreadyRegisteredException, SQLException {
		String userName = "Deo";
		long userMobileNumber = 89848l;
		String Password = "";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertFalse(inValidRegistration);
	}

	// all fields are empty
	@Test
	public void registerUsertestAllFieldsAreEmpty()
			throws ClassNotFoundException, UserAlreadyRegisteredException, SQLException {
		String userName = "";
		long userMobileNumber = 0l;
		String Password = "";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertFalse(inValidRegistration);
	}

	@Test
	public void passwordMatchTest() {
		String newPassword = "Password@123";
		String confirmPassword = "Password@123";
		boolean isPasswordMatched = RegisterService.passwordMatchCheck(newPassword, confirmPassword);
		assertTrue(isPasswordMatched);
	}

	@Test
	public void passwordMissMatchTest() {
		String newPassword = "Password@123";
		String confirmPassword = "Password3";
		boolean isPasswordMatched = RegisterService.passwordMatchCheck(newPassword, confirmPassword);
		assertFalse(isPasswordMatched);
	}
}
