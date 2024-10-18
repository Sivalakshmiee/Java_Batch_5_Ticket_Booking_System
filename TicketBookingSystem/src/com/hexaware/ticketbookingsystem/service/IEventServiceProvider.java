package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.entity.EventProvider;

public interface IEventServiceProvider {
	
	boolean createEvent(EventProvider event);
	int getAvailableSeats(int eventId);

}
