package in.nevil.validator;

import java.time.LocalDate;

public class DateValidator {
	public static boolean journeyDateCheck(String journeyDate) {
		LocalDate todayDate = LocalDate.now();
		LocalDate userJourneyDate = LocalDate.parse(journeyDate);
		LocalDate afterDate = todayDate.plusDays(1);

		boolean isValid = false;
		if (todayDate.isBefore(userJourneyDate) && (userJourneyDate.isEqual(afterDate))) {
			isValid = true;
			System.out.println("Train Is Availbale for the Date Entered");
		} else {
			System.out.println("No Trains Avilable on the Date Entered");
			isValid = false;
		}
		return isValid;
	}

}
