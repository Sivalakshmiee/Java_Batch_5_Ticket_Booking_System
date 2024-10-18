package com.hexaware.ticketbookingsystem.presentation;

import java.util.Scanner;

import com.hexaware.ticketbookingsystem.entity.Concert;
import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Movie;
import com.hexaware.ticketbookingsystem.entity.Sports;
import com.hexaware.ticketbookingsystem.service.ConcertService;
import com.hexaware.ticketbookingsystem.service.EventService;
import com.hexaware.ticketbookingsystem.service.MovieService;
import com.hexaware.ticketbookingsystem.service.SportsService;

public class EventApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        EventService eventService = new EventService();
        MovieService movieService = new MovieService();
        ConcertService concertService = new ConcertService();
        SportsService sportsService = new SportsService();

        System.out.println("Welcome to the Event Management System!");

        // Get event by ID from the database
        System.out.print("Enter Event ID to load: ");
        int eventId = scanner.nextInt();
        Event event = eventService.getEventById(eventId);

        if (event == null) {
            System.out.println("Event not found! Exiting...");
            scanner.close();
            return;
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Display Event Details");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booked Tickets");
            System.out.println("5. View Total Revenue");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	if (event instanceof Movie) {
                        movieService.displayEventDetails((Movie) event);
                    } else if (event instanceof Concert) {
                    	concertService.displayEventDetails((Concert) event);
                    } else if(event instanceof Sports) {
                    	sportsService.displayEventDetails((Sports) event);
                    }
                	else {
                        eventService.displayEventDetails(event);
                    }
                case 2:
                    System.out.print("Enter number of tickets to book: ");
                    int ticketsToBook = scanner.nextInt();
                    eventService.bookTickets(event, ticketsToBook);
                    break;
                case 3:
                    System.out.print("Enter number of tickets to cancel: ");
                    int ticketsToCancel = scanner.nextInt();
                    eventService.cancelBooking(event, ticketsToCancel);
                    break;
                case 4:
                    System.out.println("Total Booked Tickets: " +
                            eventService.getBookedNoOfTickets(event));
                    break;
                case 5:
                    System.out.println("Total Revenue: " +
                            eventService.calculateTotalRevenue(event));
                    break;
                case 6:
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
