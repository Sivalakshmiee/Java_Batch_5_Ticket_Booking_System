package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.entity.Event;

public interface IEventService {
	
	Event getEventById(int eventId);
    double calculateTotalRevenue(Event event);
    int getBookedNoOfTickets(Event event);
    boolean bookTickets(Event event, int numTickets);
    boolean cancelBooking(Event event, int numTickets);
    void displayEventDetails(Event event);

}
