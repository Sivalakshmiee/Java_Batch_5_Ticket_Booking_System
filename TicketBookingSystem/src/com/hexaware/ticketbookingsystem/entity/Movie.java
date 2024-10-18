package com.hexaware.ticketbookingsystem.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movie extends Event{
	
	private String genre;
	private String actorName;
	private String actressName;
	public Movie() {
		super();
	}
	public Movie(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
            int totalSeats, int availableSeats, double ticketPrice, EventType eventType,
            String genre, String actorName, String actressName) {
		super(eventName, eventDate, eventTime, venueName, totalSeats, availableSeats, ticketPrice, eventType);
   		this.genre = genre;
   		this.actorName = actorName;
   		this.actressName = actressName;
}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActressName() {
		return actressName;
	}
	public void setActressName(String actressName) {
		this.actressName = actressName;
	}
	
	

}
