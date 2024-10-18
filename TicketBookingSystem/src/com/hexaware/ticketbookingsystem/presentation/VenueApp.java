package com.hexaware.ticketbookingsystem.presentation;

import java.util.Scanner;

import com.hexaware.ticketbookingsystem.entity.Venue;
import com.hexaware.ticketbookingsystem.service.VenueServiceImp;

public class VenueApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        VenueServiceImp venueService = new VenueServiceImp();

        System.out.println("Welcome to the Venue Management System!");

        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. View Venue Details by Name");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Venue Name: ");
                    String venueName = scanner.nextLine();
                    Venue venue = venueService.getVenueByName(venueName);
                    
                    if (venue != null) {
                        venueService.displayVenueDetails(venue);
                    } else {
                        System.out.println("Venue not found!");
                    }
                    break;
                case 2:
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
