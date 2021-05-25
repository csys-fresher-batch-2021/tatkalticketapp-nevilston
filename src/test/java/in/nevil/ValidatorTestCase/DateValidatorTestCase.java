package in.nevil.ValidatorTestCase;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import in.nevil.validator.DateValidator;

public class DateValidatorTestCase {

	// Entering correct date as Tomorrow Date
	@Test
	public void journeyDateValidationTest1() {
		LocalDate todayDate = LocalDate.now();
		LocalDate afterDate = todayDate.plusDays(1);
		String todayStringdate = afterDate.toString();
		String journeydate = (todayStringdate);
		boolean isValidDate = DateValidator.journeyDateCheck(journeydate);
		assertTrue(isValidDate);
	}

	// Entering Invalid Date
	@Test
	public void journeyDateValidationTest2() {
		String journeydate = "2021-04-27";
		boolean isValidDate = DateValidator.journeyDateCheck(journeydate);
		assertFalse(isValidDate);
	}

	// Entering Invalid date with past year and past Month Validation
	@Test
	public void journeyDateValidationTest3() {
		String journeydate = "2020-05-26";
		boolean isValidDate = DateValidator.journeyDateCheck(journeydate);
		assertFalse(isValidDate);
	}
	// Entering Invalid Date
	@Test
	public void journeyDateValidationTest4() {
		String journeydate = "2021-03-26";
		boolean isValidDate = DateValidator.journeyDateCheck(journeydate);
		assertFalse(isValidDate);
	}
	// Entering Invalid Date
	@Test
	public void journeyDateValidationTest5() {
		String journeydate = "2020-04-26";
		boolean isValidDate = DateValidator.journeyDateCheck(journeydate);
		assertFalse(isValidDate);
	}
	// Entering Invalid Date
	@Test
	public void journeyDateValidationTest6() {
		String journeydate = "2021-04-26";
		boolean isValidDate = DateValidator.journeyDateCheck(journeydate);
		assertFalse(isValidDate);
	}

}
