package in.nevil.serviceTestCase;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import in.nevil.service.UserService;

public class UserServiceValidationTest {

	/**
	 * Valid userId  and Password
	 */
	@Test
	public void adminValidationTestBothValid() { 
		long userID = 9566087158l;
		String password =  "@Password123";
		boolean inValidCredentials = UserService.adminValidation(userID, password);
		assertTrue(inValidCredentials);	
	}

	/**
	 * valid userId  and invalid password
	 */
	@Test
	public void adminValidationTestValidEmployeeId() { 
		long userId = 9566087158l;
		String password =  "@Password1";
		boolean inValidCredentials = UserService.adminValidation(userId, password);
		assertFalse(inValidCredentials);
	}	

	/**
	 * valid userId and Invalid password with lower case
	 */
	@Test
	public void adminValidationTestValidPassword() { 
		long userId = 9566087158l;
		String password =  "@password123";
		boolean inValidCredentials = UserService.adminValidation(userId, password);
		assertFalse(inValidCredentials);	
	}	

	/**
	 * Invalid userId  and Invalid password
	 */
	@Test
	public void adminValidationTestBothInvalid() { 
		long userId = 956697774l;
		String password =  "@Passss1123";
		boolean inValidCredentials = UserService.adminValidation(userId, password);
		assertFalse(inValidCredentials);	
	}	

	/**
	 *Null userId
	 */
	@Test
	public void adminValidationTestBothNull() { 
		long  userId = 0l;
		String password =  null;
		boolean inValidCredentials = UserService.adminValidation(userId, password);
		assertFalse(inValidCredentials);	
	}	
	/**
	 * valid user registration
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void userValidationTestValid() throws ClassNotFoundException, SQLException { 
		long  userId = 9566087158l;
		String password ="Password@123";
		boolean inValidCredentials = UserService.userValidation(userId, password);
		assertTrue(inValidCredentials);	
	}	
	/**
	 * invalid user number and valid password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void userValidationTestInValidUserNumber() throws ClassNotFoundException, SQLException { 
		long  userId = 9566087159l;
		String password ="Lobo@9145";
		boolean inValidCredentials = UserService.userValidation(userId, password);
		assertFalse(inValidCredentials);	
	}
	//both field are empty and null
	@Test
	public void userValidationTestInValidFieldValues() throws ClassNotFoundException, SQLException { 
		long  userId = 9566087159l;
		String password ="Lobo@9145";
		boolean inValidCredentials = UserService.userValidation(userId, password);
		assertFalse(inValidCredentials);	
	}
}


