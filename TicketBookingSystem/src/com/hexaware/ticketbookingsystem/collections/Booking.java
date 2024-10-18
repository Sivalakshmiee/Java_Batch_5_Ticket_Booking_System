package com.hexaware.ticketbookingsystem.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Booking {
	
	private Map<Integer, Customer> customers; 
    private int bookingId;
    private int eventId;
    private int numTickets;
    private double totalCost;

    public Booking() {
        customers = new HashMap<>();
        this.bookingId = generateBookingId(); 
    }

    public int getNumTickets() {
		// TODO Auto-generated method stub
		return numTickets;
	}

	public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer); 
    }

    public void calculateBookingCost(int numTickets, double ticketPrice) {
        this.totalCost = numTickets * ticketPrice; // Calculate total cost
    }

    public int getBookingId() {
        return bookingId; // Get booking ID
    }

    public void setEventId(int eventId) {
        this.eventId = eventId; // Set event ID
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets; // Set number of tickets
    }

    public double getTotalCost() {
        return totalCost; // Get total cost
    }

    private int generateBookingId() {
        
        return new Random().nextInt(1000); // Random ID 
    }


}
