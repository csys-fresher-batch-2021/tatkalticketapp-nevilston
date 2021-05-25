package in.nevil.serviceTestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import in.nevil.service.TicketAvailablity;

public class TicketAvailableTest {
	/**
	 * entering the valid ticket needed and checked 
	 */
	@Test
	public void validTicketAvailablityChecktest() {
		int numberofTickets = 2;
		boolean isAvailable = TicketAvailablity.checkTicketAvailability(numberofTickets);
		assertTrue(isAvailable);
	}
	/**
	 * InValid Number of Tickets needed 
	 */
	@Test
	public void invalidTicketAvailablityChecktest() {
		int numberofTickets = 10;
		boolean isAvailable = TicketAvailablity.checkTicketAvailability(numberofTickets);
		assertFalse(isAvailable);
	}
	/**
	 * Ticket needed is 1 and valid 
	 */
	@Test
	public void valid1TicketAvailablityChecktest() {
		int numberofTickets = 10;
		boolean isAvailable = TicketAvailablity.checkTicketAvailability(numberofTickets);
		assertFalse(isAvailable);
	}
}
