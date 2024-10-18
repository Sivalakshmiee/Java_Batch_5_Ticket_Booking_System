package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.entity.Movie;

public class MovieService {
    
    public void displayEventDetails(Movie movie) {
        if (movie == null) {
            System.out.println("Movie event not found!");
            return;
        }

        // Display event details from the parent Event class
        System.out.println("Event Name: " + movie.getEventName());
        System.out.println("Event Date: " + movie.getEventDate());
        System.out.println("Event Time: " + movie.getEventTime());
        System.out.println("Venue: " + movie.getVenueName());
        System.out.println("Total Seats: " + movie.getTotalSeats());
        System.out.println("Available Seats: " + movie.getAvailableSeats());
        System.out.println("Ticket Price: " + movie.getTicketPrice());
        System.out.println("Event Type: " + movie.getEventType());

        // Display movie-specific details
        System.out.println("Genre: " + movie.getGenre());
        System.out.println("Actor: " + movie.getActorName());
        System.out.println("Actress: " + movie.getActressName());
    }
}
