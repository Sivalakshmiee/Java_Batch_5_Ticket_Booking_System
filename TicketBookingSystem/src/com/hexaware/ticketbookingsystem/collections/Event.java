package com.hexaware.ticketbookingsystem.collections;

import java.time.LocalDate;
import java.time.LocalTime;

import com.hexaware.ticketbookingsystem.collections.Event.EventType;

public class Event {
	
	private static int idCounter = 1; // Counter for event IDs
    private int eventId;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String venueName;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private EventType eventType;

    public enum EventType {
        MOVIE, SPORTS, CONCERT
    }

    public Event(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName, int totalSeats, int availableSeats, double ticketPrice, EventType eventType) {
        this.eventId = idCounter++;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venueName = venueName;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
    }

    public int getEventId() {
        return eventId; // Get event ID
    }

    public String getEventName() {
        return eventName; // Get event name
    }

    public double getTicketPrice() {
        return ticketPrice; // Get ticket price
    }

}
