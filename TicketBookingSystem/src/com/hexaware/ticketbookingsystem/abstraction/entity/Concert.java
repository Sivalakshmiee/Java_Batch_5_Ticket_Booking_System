package com.hexaware.ticketbookingsystem.abstraction.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{
	
	private String artist;
	private String type;
	public Concert() {
		super();
	}
	public Concert(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
            int totalSeats, int availableSeats, double ticketPrice, EventType eventType,
            String artist, String concertType, String type) {
			super(eventName, eventDate, eventTime, venueName, totalSeats, availableSeats, ticketPrice, eventType);
			this.artist = artist;
			this.type = type;
}

	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
