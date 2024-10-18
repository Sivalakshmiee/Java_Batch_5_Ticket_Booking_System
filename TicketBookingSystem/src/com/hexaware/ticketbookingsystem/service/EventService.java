package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.dao.EventDaoImp;
import com.hexaware.ticketbookingsystem.entity.Event;

public class EventService implements IEventService {

    private final EventDaoImp eventDAO = new EventDaoImp(); // Use the instance properly
//    private final IEventDao eventDao;
//    
//    public EventService(IEventDao eventDao) {
//        this.eventDao = eventDao;
//    }
    

    // Fetch event details by ID from the database
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
    public double calculateTotalRevenue(Event event) {
        int bookedTickets = getBookedNoOfTickets(event);
        return bookedTickets * event.getTicketPrice();
    }

    @Override
    public int getBookedNoOfTickets(Event event) {
        return event.getTotalSeats() - event.getAvailableSeats();
    }

    @Override
    public boolean bookTickets(Event event, int numTickets) {
        if (event.getAvailableSeats() >= numTickets) {
            event.setAvailableSeats(event.getAvailableSeats() - numTickets);
            System.out.println("Successfully booked " + numTickets + " tickets.");
            return true;
        } else {
            System.out.println("Not enough seats available!");
            return false;
        }
    }

    @Override
    public boolean cancelBooking(Event event, int numTickets) {
        int bookedTickets = getBookedNoOfTickets(event);
        if (numTickets <= bookedTickets) {
            event.setAvailableSeats(event.getAvailableSeats() + numTickets);
            System.out.println("Successfully cancelled " + numTickets + " tickets.");
            return true;
        } else {
            System.out.println("Invalid cancellation request!");
            return false;
        }
    }

    @Override
    public void displayEventDetails(Event event) {
        if (event == null) {
            System.out.println("Event not found!");
            return;
        }
        System.out.println("Event Name: " + event.getEventName());
        System.out.println("Event Date: " + event.getEventDate());
        System.out.println("Event Time: " + event.getEventTime());
        System.out.println("Venue: " + event.getVenueName());
        System.out.println("Total Seats: " + event.getTotalSeats());
        System.out.println("Available Seats: " + event.getAvailableSeats());
        System.out.println("Ticket Price: " + event.getTicketPrice());
        System.out.println("Event Type: " + event.getEventType());
    }
    
    // Method to cancel tickets for an event
    public void cancelTickets(Event event, int numTickets) {
        event.setAvailableSeats(event.getAvailableSeats() + numTickets);
        System.out.println("Tickets canceled successfully.");
    }
}
