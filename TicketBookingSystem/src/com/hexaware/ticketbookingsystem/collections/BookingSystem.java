package com.hexaware.ticketbookingsystem.collections;

import java.util.HashMap;
import java.util.Map;

public class BookingSystem {
	
	private Map<Integer, Event> events; // Store events by eventId

    public BookingSystem() {
        events = new HashMap<>();
    }

    public void addEvent(Event event) {
        events.put(event.getEventId(), event); // Add event
    }

}
