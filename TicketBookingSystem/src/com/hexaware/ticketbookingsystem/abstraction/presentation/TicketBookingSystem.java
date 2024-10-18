package com.hexaware.ticketbookingsystem.abstraction.presentation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.hexaware.ticketbookingsystem.entity.Concert;
import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Movie;
import com.hexaware.ticketbookingsystem.entity.Sports;
import com.hexaware.ticketbookingsystem.service.EventService;

public class TicketBookingSystem extends BookingSystem {

    private ArrayList<Event> events;  // Maintain an array of events

    public TicketBookingSystem() {
        events = new ArrayList<>();
    }

    // Method to create events
    public Event createEvent(String eventName, String date, String time, int totalSeats,
                             double ticketPrice, String eventType, String venueName) {
        LocalDate eventDate = LocalDate.parse(date);
        LocalTime eventTime = LocalTime.parse(time);

        Event event = null;
        switch (eventType.toLowerCase()) {
            case "movie":
                event = new Movie(eventName, eventDate, eventTime, venueName, totalSeats,
                                  totalSeats, ticketPrice, Event.EventType.MOVIE,
                                  "Action", "Tom Cruise", "Emma Stone");
                break;

            case "sports":
                event = new Sports(eventName, eventDate, eventTime, venueName, totalSeats,
                                   totalSeats, ticketPrice, Event.EventType.SPORTS,
                                   "Cricket", "India vs Pakistan");
                break;

            case "concert":
                event = new Concert(eventName, eventDate, eventTime, venueName, totalSeats,
                                    totalSeats, ticketPrice, Event.EventType.CONCERT,
                                    "Coldplay", "Rock", venueName);
                break;

            default:
                System.out.println("Invalid event type!");
                return null;
        }
        
        // Add the created event to the events list
        events.add(event);
        System.out.println("Event '" + eventName + "' created successfully!");
        return event;
    }



  

    public static void main(String[] args) {
		TicketBookingSystem bookingSystem = new TicketBookingSystem();
        EventService eventService = new EventService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Ticket Booking System!");

        // Create an event
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter event date (yyyy-mm-dd): ");
        String eventDate = scanner.nextLine();
        System.out.print("Enter event time (HH:mm): ");
        String eventTime = scanner.nextLine();
        System.out.print("Enter total seats: ");
        int totalSeats = scanner.nextInt();
        System.out.print("Enter ticket price: ");
        double ticketPrice = scanner.nextDouble();
        scanner.nextLine();  // Clear the buffer
        System.out.print("Enter event type (movie, sports, concert): ");
        String eventType = scanner.nextLine();
        System.out.print("Enter venue name: ");
        String venueName = scanner.nextLine();

        Event event = bookingSystem.createEvent(eventName, eventDate, eventTime, totalSeats, 
                                                ticketPrice, eventType, venueName);

        boolean exit = false;

        // Menu-driven system for event management
        while (!exit) {
            System.out.println("\n1. Display Event Details");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    eventService.displayEventDetails(event);
                    break;

                case 2:
                    System.out.print("Enter number of tickets to book: ");
                    int ticketsToBook = scanner.nextInt();
                    eventService.bookTickets(event, ticketsToBook);
                    break;

                case 3:
                    System.out.print("Enter number of tickets to cancel: ");
                    int ticketsToCancel = scanner.nextInt();
                    eventService.cancelTickets(event, ticketsToCancel);
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting... Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
   }
}
