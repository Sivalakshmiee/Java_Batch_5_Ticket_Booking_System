package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.entity.Sports;

public class SportsService {
	
	public void displayEventDetails(Sports sports) {
        if (sports == null) {
            System.out.println("Sport event not found!");
            return;
        }

        // Display event details from the parent Event class
        System.out.println("Event Name: " + sports.getEventName());
        System.out.println("Event Date: " + sports.getEventDate());
        System.out.println("Event Time: " + sports.getEventTime());
        System.out.println("Venue: " + sports.getVenueName());
        System.out.println("Total Seats: " + sports.getTotalSeats());
        System.out.println("Available Seats: " + sports.getAvailableSeats());
        System.out.println("Ticket Price: " + sports.getTicketPrice());
        System.out.println("Event Type: " + sports.getEventType());

        // Display movie-specific details
        System.out.println("Artist: " + sports.getSportName());
        System.out.println("Actor: " + sports.getTeamsName());
        
    }

}
