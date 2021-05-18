package in.nevil.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegisterServicesValidationTest {

	// With Correct Details
	@Test
	public void registerUsertest() {
		String userName ="Nevil";
		long userMobileNumber= 9566087158l;
		String Password ="Lobo@9145";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertTrue(inValidRegistration);
	}
	// user number  is empty
	@Test
	public void registerUsertestWithUserNumberNull() {
		String userName ="Deo";
		long userMobileNumber= 0l;
		String Password ="Lobo@9145";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertFalse(inValidRegistration);
	}
	// user number invalidFormat is empty
	@Test
	public void registerUsertestWithUserNumberInvalidFormat() {
		String userName ="Deo";
		long userMobileNumber= 89848l;
		String Password ="Lobo@9145";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertFalse(inValidRegistration);
	}
	//invalid password format missing "@"
	@Test
	public void registerUsertestWithUserPasswordInvalidFormat() {
		String userName ="Deo";
		long userMobileNumber= 89848l;
		String Password ="Lobo9145";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertFalse(inValidRegistration);
	}
	//Empty Password 
	@Test
	public void registerUsertestWithUserPasswordEmpty() {
		String userName ="Deo";
		long userMobileNumber= 89848l;
		String Password ="";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertFalse(inValidRegistration);
	}
	//all fields are empty 
	@Test
	public void registerUsertestAllFieldsAreEmpty() {
		String userName ="";
		long userMobileNumber=0l ;
		String Password ="";
		boolean inValidRegistration = RegisterService.addUser(userName, userMobileNumber, Password);
		assertFalse(inValidRegistration);
	}
	@Test
	public void passwordMatchTest() {
		String newPassword= "Password@123";
		String confirmPassword ="Password@123";
		boolean isPasswordMatched =RegisterService.passwordMatchCheck(newPassword, confirmPassword);
		assertTrue(isPasswordMatched);
	}
	@Test
	public void passwordMissMatchTest() {
		String newPassword= "Password@123";
		String confirmPassword ="Password3";
		boolean isPasswordMatched =RegisterService.passwordMatchCheck(newPassword, confirmPassword);
		assertFalse(isPasswordMatched);
	}
}
