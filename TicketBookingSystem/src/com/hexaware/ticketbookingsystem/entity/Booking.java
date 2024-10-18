package com.hexaware.ticketbookingsystem.entity;

public class Booking {
	
	private Event event;
	private int numTickets;
	private double totalCost;
	public Booking() {
		super();
	}
	public Booking(Event event, int numTickets, double totalCost) {
		super();
		this.event = event;
		this.numTickets = numTickets;
		this.totalCost = totalCost;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public int getNumTickets() {
		return numTickets;
	}
	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	

}
