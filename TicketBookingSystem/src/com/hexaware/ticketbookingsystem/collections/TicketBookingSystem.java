package com.hexaware.ticketbookingsystem.collections;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class TicketBookingSystem {

    public static void main(String[] args) {
        
        BookingSystem bookingSystem = new BookingSystem();
        
        Event event1 = new Event("Concert", LocalDate.of(2024, 11, 20), LocalTime.of(19, 0), "Stadium A", 100, 100, 50.0, Event.EventType.CONCERT);
        Event event2 = new Event("Movie", LocalDate.of(2024, 11, 22), LocalTime.of(18, 0), "Cinema B", 200, 200, 10.0, Event.EventType.MOVIE);
        
        bookingSystem.addEvent(event1);
        bookingSystem.addEvent(event2);
        
        Customer customer1 = new Customer(1, "John Doe", "john@example.com", "2039485721");
        Customer customer2 = new Customer(2, "Jane Smith", "jane@example.com", "0987654321");
        
        Booking booking = new Booking();
        booking.addCustomer(customer1);
        booking.addCustomer(customer2);
        
        booking.setEventId(event1.getEventId());
        booking.setNumTickets(2);
        booking.calculateBookingCost(booking.getNumTickets(), event1.getTicketPrice());
        
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Total Cost: " + booking.getTotalCost());
        System.out.println("Total Cost: " + booking.getNumTickets());
    }
}



