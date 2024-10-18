package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.entity.Event;

public interface IBookingService {
		double calculateBookingCost(Event event, int numTickets);
	   	boolean bookTickets(Event event, int numTickets);
	    boolean cancelBooking(Event event, int numTickets);
	    int getAvailableNoOfTickets(Event event);
	    void displayEventDetails(Event event);
		Event getEventById(int eventId);
	

}
