package com.hexaware.ticketbookingsystem.entity;

import java.sql.Date;

public class BookingSystem {
	
	private int bookingId;
    private int customerId;
    private int eventId;
    private int numTickets;
    private int totalCost;
    private Date bookingDate;
	public BookingSystem() {
		super();
	}
	public BookingSystem(int bookingId, int customerId, int eventId, int numTickets, int totalCost, Date bookingDate) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.eventId = eventId;
		this.numTickets = numTickets;
		this.totalCost = totalCost;
		this.bookingDate = bookingDate;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getNumTickets() {
		return numTickets;
	}
	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
    
 

}
