package in.nevil.serviceTestCase;

import static org.junit.Assert.assertFalse;

import java.sql.SQLException;

import org.junit.Test;

import in.nevil.exceptions.TicketNotAvailableExceptions;
import in.nevil.service.TicketAvailablity;

public class TicketAvailableTest {
	/**
	 * entering the valid ticket needed and checked
	 * @throws TicketNotAvailableExceptions
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void validTicketAvailablityChecktest() throws ClassNotFoundException, SQLException, TicketNotAvailableExceptions {
		int numberofTickets = 2;
		boolean isAvailable = TicketAvailablity.checkTicketAvailability(numberofTickets);
		assertFalse(isAvailable);
	}
	/**
	 * InValid Number of Tickets needed
	 * @throws TicketNotAvailableExceptions
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void invalidTicketAvailablityChecktest() throws ClassNotFoundException, SQLException, TicketNotAvailableExceptions {
		int numberofTickets = 10;
		boolean isAvailable = TicketAvailablity.checkTicketAvailability(numberofTickets);
		assertFalse(isAvailable);
	}
	/**
	 * Ticket needed is 1 and valid
	 * @throws TicketNotAvailableExceptions
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void valid1TicketAvailablityChecktest() throws ClassNotFoundException, SQLException, TicketNotAvailableExceptions {
		int numberofTickets = 10;
		boolean isAvailable = TicketAvailablity.checkTicketAvailability(numberofTickets);
		assertFalse(isAvailable);
	}
}
