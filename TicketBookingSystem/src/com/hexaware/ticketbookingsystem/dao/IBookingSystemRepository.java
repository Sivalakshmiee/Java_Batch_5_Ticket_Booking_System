package com.hexaware.ticketbookingsystem.dao;

import com.hexaware.ticketbookingsystem.entity.BookingSystem;
import com.hexaware.ticketbookingsystem.entity.EventProvider;
import com.hexaware.ticketbookingsystem.exception.EventNotFoundException;
import com.hexaware.ticketbookingsystem.exception.InvalidBookingIDException;

public interface IBookingSystemRepository {
	
	boolean createBooking(BookingSystem booking);
	BookingSystem getBookingDetails(int bookingId)throws InvalidBookingIDException;
	boolean createEvent(EventProvider event);
	boolean cancelBooking(int bookingId) throws InvalidBookingIDException;
	int getAvailableSeats(int eventId);
	EventProvider getEventDetails(int eventId) throws EventNotFoundException;

}
