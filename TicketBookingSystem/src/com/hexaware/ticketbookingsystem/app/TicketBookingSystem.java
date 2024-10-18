package com.hexaware.ticketbookingsystem.app;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.hexaware.ticketbookingsystem.entity.BookingSystem;
import com.hexaware.ticketbookingsystem.entity.EventProvider;
import com.hexaware.ticketbookingsystem.exception.EventNotFoundException;
import com.hexaware.ticketbookingsystem.exception.InvalidBookingIDException;
import com.hexaware.ticketbookingsystem.service.IBookingSystemServiceProviderImpl;
import com.hexaware.ticketbookingsystem.service.IEventServiceProviderImpl;

public class TicketBookingSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        IBookingSystemServiceProviderImpl bookingService = new IBookingSystemServiceProviderImpl();
        IEventServiceProviderImpl eventService = new IEventServiceProviderImpl();
        
        while (true) {
        	try {
        	
        	
            System.out.println("\n==== Ticket Booking System ====");
            System.out.println("1. Create Booking");
            System.out.println("2. Get Booking Details");
            System.out.println("3. Create Event");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Get Available Seats");
            System.out.println("6. Get Event Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
            case 1:
                createBooking(scanner, bookingService);
                break;
            case 2:
                getBookingDetails(scanner, bookingService);
                break;
            case 3:
                createEvent(scanner, eventService);
                break;
                
            case 4:
                cancelBooking(scanner, bookingService);
                break;
                
            case 5:
                getAvailableSeats(scanner, bookingService);
                break;
                
            case 6:
                getEventDetails(scanner, bookingService);
                break;
                
            case 7:
                System.out.println("Exiting... Thank you!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
            
        } catch (NullPointerException e) {
            System.err.println("Error: Null value encountered. Please check your input and try again.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
        	
        }
      

	}



	private static void createBooking(Scanner scanner, IBookingSystemServiceProviderImpl bookingService) {
		// TODO Auto-generated method stub
		System.out.print("Enter Booking ID: ");
        int bookingId = scanner.nextInt();
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Enter Event ID: ");
        int eventId = scanner.nextInt();
        System.out.print("Enter Number of Tickets: ");
        int numTickets = scanner.nextInt();
        System.out.print("Enter Total Cost: ");
        int totalCost = scanner.nextInt();
        System.out.print("Enter Booking Date (YYYY-MM-DD): ");
        String dateStr = scanner.next();
        Date bookingDate = Date.valueOf(dateStr);  // Convert to SQL Date

        BookingSystem booking = new BookingSystem(bookingId, customerId, eventId, numTickets, totalCost, bookingDate);

        boolean result = bookingService.createBooking(booking);
        if (result) {
            System.out.println("Booking created successfully.");
        } else {
            System.out.println("");
        }    
		
	}
	
	private static void getBookingDetails(Scanner scanner, IBookingSystemServiceProviderImpl bookingService) {
		
		try {
		System.out.print("Enter Booking ID to retrieve details: ");
        int bookingId = scanner.nextInt();

        BookingSystem booking = bookingService.getBookingDetails(bookingId);
        if (booking != null) {
            System.out.println("Booking Details:");
            System.out.println("Booking ID: " + booking.getBookingId());
            System.out.println("Customer ID: " + booking.getCustomerId());
            System.out.println("Event ID: " + booking.getEventId());
            System.out.println("Number of Tickets: " + booking.getNumTickets());
            System.out.println("Total Cost: " + booking.getTotalCost());
            System.out.println("Booking Date: " + booking.getBookingDate());
        } else {
        	throw new InvalidBookingIDException("No booking found with the given ID.");
        }
		}catch (InvalidBookingIDException e) {
            System.err.println(e.getMessage());
        }
		
	}
	
	private static void createEvent(Scanner scanner, IEventServiceProviderImpl eventService) {
		
		EventProvider event = new EventProvider();
		
		System.out.println("Enter Event Id: ");
		int eventId = scanner.nextInt();
		event.setEventId(eventId);
		
		System.out.print("Enter Event Name: ");
        scanner.nextLine(); // Consume newline
        String eventName = scanner.nextLine();
        event.setEventName(eventName);
        
        System.out.print("Enter Event Date (YYYY-MM-DD): ");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine());
        event.setEventDate(eventDate);
        
        System.out.print("Enter Event Time (HH:MM): ");
        LocalTime eventTime = LocalTime.parse(scanner.nextLine());
        event.setEventTime(eventTime);
        
        System.out.println("Enter venue id");
        int venueId = scanner.nextInt();
        event.setVenueId(venueId);
        
        System.out.print("Enter Total Seats: ");
        int totalSeats = scanner.nextInt();
        event.setTotalSeats(totalSeats);
        
        System.out.print("Enter Available Seats: ");
        int availableSeats = scanner.nextInt();
        event.setAvailableSeats(availableSeats);
        
        System.out.print("Enter Ticket Price: ");
        double ticketPrice = scanner.nextDouble();
        event.setTicketPrice(ticketPrice);
        
        System.out.println("Enter booking id");
        int bookingId = scanner.nextInt();
        event.setBookingId(bookingId);
        
        System.out.print("Enter Event Type (MOVIE, SPORTS, CONCERT): ");
        String eventTypeStr = scanner.next().toUpperCase();
        EventProvider.EventType eventType = EventProvider.EventType.valueOf(eventTypeStr);
        event.setEventType(eventType);

        boolean result = eventService.createEvent(event);
        if (result) {
            System.out.println("Event created successfully.");
        } else {
            System.out.println("Failed to create event.");
        }
        
        
		
	}
	
	private static void cancelBooking(Scanner scanner, IBookingSystemServiceProviderImpl bookingService) {
		
		try {
		System.out.print("Enter Booking ID to cancel: ");
        int bookingId = scanner.nextInt();

        boolean result = bookingService.cancelBooking(bookingId);
        if (result) {
            System.out.println("Booking canceled successfully.");
        } else {
        	throw new InvalidBookingIDException("Failed to cancel booking. Please check the Booking ID.");
        }
		}catch (InvalidBookingIDException e) {
            System.err.println(e.getMessage());
        }
		
	}
	
	private static void getAvailableSeats(Scanner scanner, IBookingSystemServiceProviderImpl bookingService) {
		System.out.print("Enter Event ID to check available seats: ");
        int eventId = scanner.nextInt();

        int availableSeats = bookingService.getAvailableSeats(eventId);
        if (availableSeats >= 0) {
            System.out.println("Available seats for Event ID " + eventId + ": " + availableSeats);
        } else {
            System.out.println("Failed to retrieve available seats. Please check the Event ID.");
        }
		
	}
	
	private static void getEventDetails(Scanner scanner, IBookingSystemServiceProviderImpl bookingService) {
		
		try {
		System.out.print("Enter Event ID to get details: ");
        int eventId = scanner.nextInt();

        EventProvider event = bookingService.getEventDetails(eventId);
        if (event != null) {
            System.out.println("Event Details:");
            System.out.println("Name: " + event.getEventName());
            System.out.println("Date: " + event.getEventDate());
            System.out.println("Time: " + event.getEventTime());
            System.out.println("Venue: " + event.getVenueId());
            System.out.println("Total Seats: " + event.getTotalSeats());
            System.out.println("Available Seats: " + event.getAvailableSeats());
            System.out.println("Ticket Price: " + event.getTicketPrice());
            System.out.println("Event Type: " + event.getEventType());
        } else {
        	throw new EventNotFoundException("No event found with the given ID.");
        }
		}catch (EventNotFoundException e) {
            System.err.println(e.getMessage());
        }
		
	}


}
