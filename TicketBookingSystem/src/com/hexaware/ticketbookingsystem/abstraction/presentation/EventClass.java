package com.hexaware.ticketbookingsystem.abstraction.presentation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.hexaware.ticketbookingsystem.abstraction.entity.Concert;
import com.hexaware.ticketbookingsystem.abstraction.entity.Event.EventType;
import com.hexaware.ticketbookingsystem.abstraction.entity.Movie;
import com.hexaware.ticketbookingsystem.abstraction.entity.Sports;

public class EventClass {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Concert Details:");
        Concert concert = getConcertDetails(scanner);
      
        System.out.println("\nEnter Movie Details:");
        Movie movie = getMovieDetails(scanner);
      
        System.out.println("\nEnter Sports Event Details:");
        Sports sports = getSportsDetails(scanner);

        System.out.println("\n--- Concert Details ---");
        displayConcertDetails(concert);

        System.out.println("\n--- Movie Details ---");
        displayMovieDetails(movie);

        System.out.println("\n--- Sports Event Details ---");
        displaySportsDetails(sports);

        scanner.close();
    }

    private static Concert getConcertDetails(Scanner scanner) {
        System.out.print("Event Name: ");
        String eventName = scanner.nextLine();
        System.out.print("Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Concert Type: ");
        String concertType = scanner.nextLine();
        System.out.print("Event Date (yyyy-mm-dd): ");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Event Time (HH:mm): ");
        LocalTime eventTime = LocalTime.parse(scanner.nextLine());
        System.out.print("Venue Name: ");
        String venueName = scanner.nextLine();
        System.out.print("Total Seats: ");
        int totalSeats = scanner.nextInt();
        System.out.print("Available Seats: ");
        int availableSeats = scanner.nextInt();
        System.out.print("Ticket Price: ");
        double ticketPrice = scanner.nextDouble();
        scanner.nextLine();  

        return new Concert(eventName, eventDate, eventTime, venueName, totalSeats,
                availableSeats, ticketPrice, EventType.CONCERT, artist, concertType, "Music");
    }

    private static Movie getMovieDetails(Scanner scanner) {
        System.out.print("Event Name: ");
        String eventName = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Actor Name: ");
        String actorName = scanner.nextLine();
        System.out.print("Actress Name: ");
        String actressName = scanner.nextLine();
        System.out.print("Event Date (yyyy-mm-dd): ");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Event Time (HH:mm): ");
        LocalTime eventTime = LocalTime.parse(scanner.nextLine());
        System.out.print("Venue Name: ");
        String venueName = scanner.nextLine();
        System.out.print("Total Seats: ");
        int totalSeats = scanner.nextInt();
        System.out.print("Available Seats: ");
        int availableSeats = scanner.nextInt();
        System.out.print("Ticket Price: ");
        double ticketPrice = scanner.nextDouble();
        scanner.nextLine();  

        return new Movie(eventName, eventDate, eventTime, venueName, totalSeats,
                availableSeats, ticketPrice, EventType.MOVIE, genre, actorName, actressName);
    }

    private static Sports getSportsDetails(Scanner scanner) {
        System.out.print("Event Name: ");
        String eventName = scanner.nextLine();
        System.out.print("Sport Name: ");
        String sportName = scanner.nextLine();
        System.out.print("Teams Name: ");
        String teamsName = scanner.nextLine();
        System.out.print("Event Date (yyyy-mm-dd): ");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Event Time (HH:mm): ");
        LocalTime eventTime = LocalTime.parse(scanner.nextLine());
        System.out.print("Venue Name: ");
        String venueName = scanner.nextLine();
        System.out.print("Total Seats: ");
        int totalSeats = scanner.nextInt();
        System.out.print("Available Seats: ");
        int availableSeats = scanner.nextInt();
        System.out.print("Ticket Price: ");
        double ticketPrice = scanner.nextDouble();
        scanner.nextLine();  

        return new Sports(eventName, eventDate, eventTime, venueName, totalSeats,
                availableSeats, ticketPrice, EventType.SPORTS, sportName, teamsName);
    }

    private static void displayConcertDetails(Concert concert) {
        System.out.println("Event Name: " + concert.getEventName());
        System.out.println("Artist: " + concert.getArtist());
        System.out.println("Concert Type: " + concert.getType());
        System.out.println("Event Date: " + concert.getEventDate());
        System.out.println("Event Time: " + concert.getEventTime());
        System.out.println("Venue: " + concert.getVenueName());
        System.out.println("Total Seats: " + concert.getTotalSeats());
        System.out.println("Available Seats: " + concert.getAvailableSeats());
        System.out.println("Ticket Price: $" + concert.getTicketPrice());
    }

    private static void displayMovieDetails(Movie movie) {
        System.out.println("Event Name: " + movie.getEventName());
        System.out.println("Genre: " + movie.getGenre());
        System.out.println("Actor: " + movie.getActorName());
        System.out.println("Actress: " + movie.getActressName());
        System.out.println("Event Date: " + movie.getEventDate());
        System.out.println("Event Time: " + movie.getEventTime());
        System.out.println("Venue: " + movie.getVenueName());
        System.out.println("Total Seats: " + movie.getTotalSeats());
        System.out.println("Available Seats: " + movie.getAvailableSeats());
        System.out.println("Ticket Price: $" + movie.getTicketPrice());
    }

    private static void displaySportsDetails(Sports sports) {
        System.out.println("Event Name: " + sports.getEventName());
        System.out.println("Sport: " + sports.getSportName());
        System.out.println("Teams: " + sports.getTeamsName());
        System.out.println("Event Date: " + sports.getEventDate());
        System.out.println("Event Time: " + sports.getEventTime());
        System.out.println("Venue: " + sports.getVenueName());
        System.out.println("Total Seats: " + sports.getTotalSeats());
        System.out.println("Available Seats: " + sports.getAvailableSeats());
        System.out.println("Ticket Price: $" + sports.getTicketPrice());
    }

}
