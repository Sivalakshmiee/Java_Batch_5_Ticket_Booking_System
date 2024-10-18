package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.dao.EventDaoImp;
import com.hexaware.ticketbookingsystem.entity.Event;

public class BookingServiceImp  implements IBookingService{
	
	private final EventDaoImp eventDAO = new EventDaoImp();
	
	@Override
    public Event getEventById(int eventId) {
        try {
            return eventDAO.getEventById(eventId); // Use the instance object to call the method
        } catch (Exception e) {
            System.err.println("Error fetching event: " + e.getMessage());
            return null;
        }
    }

	@Override
	public double calculateBookingCost(Event event, int numTickets) {
	    if (numTickets <= 0) {
	        System.out.println("Number of tickets must be positive.");
	        return 0;
	    }
	    return numTickets * event.getTicketPrice();
	}

	@Override
	public boolean bookTickets(Event event, int numTickets) {
		int availableSeats = event.getAvailableSeats();

        if (numTickets <= availableSeats) {
            event.setAvailableSeats(availableSeats - numTickets);
            System.out.println(numTickets + " tickets booked successfully!");
            return true;
        } else {
            System.out.println("Not enough seats available. Booking failed.");
            return false;
        }
    }

	@Override
	public boolean cancelBooking(Event event, int numTickets) {
		int availableSeats = event.getAvailableSeats();
        int totalSeats = event.getTotalSeats();

        if (availableSeats + numTickets <= totalSeats) {
            event.setAvailableSeats(availableSeats + numTickets);
            System.out.println(numTickets + " tickets cancelled successfully!");
            return true;
        } else {
            System.out.println("Cancellation exceeds total seats. Cancellation failed.");
            return false;
        }
	}

	@Override
	public int getAvailableNoOfTickets(Event event) {
		return event.getAvailableSeats();
	}

	@Override
	public void displayEventDetails(Event event) {
		System.out.println("Event Details:");
        System.out.println("Event Name: " + event.getEventName());
        System.out.println("Date: " + event.getEventDate());
        System.out.println("Time: " + event.getEventTime());
        System.out.println("Venue: " + event.getVenueName());
        System.out.println("Total Seats: " + event.getTotalSeats());
        System.out.println("Available Seats: " + event.getAvailableSeats());
        System.out.println("Ticket Price: " + event.getTicketPrice());
        System.out.println("Event Type: " + event.getEventType());
		
	}

	 }
