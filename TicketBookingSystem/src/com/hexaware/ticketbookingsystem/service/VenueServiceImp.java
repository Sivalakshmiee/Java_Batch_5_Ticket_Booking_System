package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.dao.VenueDaoImp; // Ensure you have this DAO implementation
import com.hexaware.ticketbookingsystem.entity.Venue; // Make sure to import the Venue class

public class VenueServiceImp {

    private final VenueDaoImp venueDAO = new VenueDaoImp(); // DAO for venue operations

    // Fetch venue details by name
    public Venue getVenueByName(String venueName) {
        try {
            return venueDAO.getVenueByName(venueName); // Fetch venue details from DAO
        } catch (Exception e) {
            System.err.println("Error fetching venue: " + e.getMessage());
            return null;
        }
    }

    // Method to display venue details
    public void displayVenueDetails(Venue venue) {
        if (venue == null) {
            System.out.println("Venue not found!");
            return;
        }
        System.out.println("Venue Name: " + venue.getVenueName());
        System.out.println("Address: " + venue.getAddress());
    }
}
