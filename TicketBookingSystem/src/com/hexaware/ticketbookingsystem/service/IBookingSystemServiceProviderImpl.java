package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.dao.IBookingSystemRepositoryImpl;
import com.hexaware.ticketbookingsystem.entity.BookingSystem;
import com.hexaware.ticketbookingsystem.entity.EventProvider;
import com.hexaware.ticketbookingsystem.exception.EventNotFoundException;
import com.hexaware.ticketbookingsystem.exception.InvalidBookingIDException;

public class IBookingSystemServiceProviderImpl implements IBookingSystemServiceProvider{
	
	private IBookingSystemRepositoryImpl bookingRepo;

    // Constructor to initialize DAO
    public IBookingSystemServiceProviderImpl() {
        this.bookingRepo = new IBookingSystemRepositoryImpl();
    }

	public boolean createBooking(BookingSystem booking) {
		return bookingRepo.createBooking(booking);
	}

	@Override
	public BookingSystem getBookingDetails(int bookingId) throws InvalidBookingIDException{
		// TODO Auto-generated method stub
		return bookingRepo.getBookingDetails(bookingId);
	}

	@Override
	public boolean cancelBooking(int bookingId) throws InvalidBookingIDException{
		return bookingRepo.cancelBooking(bookingId);
	}

	@Override
	public int getAvailableSeats(int eventId) {
		return bookingRepo.getAvailableSeats(eventId);
	}

	@Override
	public EventProvider getEventDetails(int eventId) throws EventNotFoundException{
		return bookingRepo.getEventDetails(eventId);
	}
	
	

	

	

	

	

	

}
