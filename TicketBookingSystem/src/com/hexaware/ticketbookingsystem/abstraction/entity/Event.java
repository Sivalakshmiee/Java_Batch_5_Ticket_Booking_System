package com.hexaware.ticketbookingsystem.abstraction.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Event {
	
	private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String venueName;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private EventType eventType; // Change from String to EventType
    
    // Enum for event type
    public enum EventType {
        MOVIE, SPORTS, CONCERT
    }

	public Event() {
		super();
	}

	public Event(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName, int totalSeats,
			int availableSeats, double ticketPrice, EventType eventType) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.venueName = venueName;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.ticketPrice = ticketPrice;
		this.eventType = eventType;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public LocalTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
    

}
