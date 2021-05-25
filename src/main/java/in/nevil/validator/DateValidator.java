package in.nevil.validator;

import java.time.LocalDate;

public class DateValidator {
	private DateValidator() {
		// Default Constructor
	}

	/**
	 * This method verifies whether the date entered correct and valid
	 * 
	 * @param employeeId
	 * @return
	 */
	public static boolean journeyDateCheck(String journeyDate) {
		LocalDate todayDate = LocalDate.now();
		LocalDate userJourneyDate = LocalDate.parse(journeyDate);
		LocalDate afterDate = todayDate.plusDays(1);

		boolean isValid = false;
		if (todayDate.isBefore(userJourneyDate) && (userJourneyDate.isEqual(afterDate))) {
			isValid = true;

		} else {
			isValid = false;
		}
		return isValid;
	}

}
