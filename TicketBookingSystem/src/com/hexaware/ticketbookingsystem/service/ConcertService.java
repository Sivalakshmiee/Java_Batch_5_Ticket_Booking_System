package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.entity.Concert;


public class ConcertService {
	
	public void displayEventDetails(Concert concert) {
        if (concert == null) {
            System.out.println("Movie event not found!");
            return;
        }

        // Display event details from the parent Event class
        System.out.println("Event Name: " + concert.getEventName());
        System.out.println("Event Date: " + concert.getEventDate());
        System.out.println("Event Time: " + concert.getEventTime());
        System.out.println("Venue: " + concert.getVenueName());
        System.out.println("Total Seats: " + concert.getTotalSeats());
        System.out.println("Available Seats: " + concert.getAvailableSeats());
        System.out.println("Ticket Price: " + concert.getTicketPrice());
        System.out.println("Event Type: " + concert.getEventType());

        // Display movie-specific details
        System.out.println("Artist: " + concert.getArtist());
        System.out.println("Actor: " + concert.getType());
        
    }

}
