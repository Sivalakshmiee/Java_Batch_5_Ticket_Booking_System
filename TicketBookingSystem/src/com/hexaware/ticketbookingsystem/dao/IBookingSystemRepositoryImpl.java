package com.hexaware.ticketbookingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.ticketbookingsystem.entity.BookingSystem;
import com.hexaware.ticketbookingsystem.entity.EventProvider;
import com.hexaware.ticketbookingsystem.exception.EventNotFoundException;
import com.hexaware.ticketbookingsystem.exception.InvalidBookingIDException;

public class IBookingSystemRepositoryImpl implements IBookingSystemRepository{
	
	private Connection conn;
	
	public IBookingSystemRepositoryImpl() {

		conn = DBUtil.getDBConnection();

	}

	@Override
	public boolean createBooking(BookingSystem booking) {
		String query = "INSERT INTO booking (booking_id, customer_id, event_id, num_tickets, total_cost, booking_date) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

 // Use try-with-resources to manage the PreparedStatement
 try (PreparedStatement stmt = conn.prepareStatement(query)) {
     // Set parameters in the prepared statement
     stmt.setInt(1, booking.getBookingId());
     stmt.setInt(2, booking.getCustomerId());
     stmt.setInt(3, booking.getEventId());
     stmt.setInt(4, booking.getNumTickets());
     stmt.setInt(5, booking.getTotalCost());
     stmt.setDate(6, booking.getBookingDate());  // java.sql.Date is expected

     // Execute the query
     stmt.executeUpdate();
     System.out.println("Booking created successfully.");

 } catch (SQLException e) {
     // Handle SQL exceptions
     e.printStackTrace();
 }
return false;
		
	}

	@Override
	public BookingSystem getBookingDetails(int bookingId) throws InvalidBookingIDException{
		String query = "SELECT * FROM booking WHERE booking_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Assuming you have proper constructor and getters
                int customerId = rs.getInt("customer_id");
                int eventId = rs.getInt("event_id");
                int numTickets = rs.getInt("num_tickets");
                int totalCost = rs.getInt("total_cost");
                java.sql.Date bookingDate = rs.getDate("booking_date");

                return new BookingSystem(bookingId, customerId, eventId, numTickets, totalCost, bookingDate);
            } else {
                throw new InvalidBookingIDException("Booking ID " + bookingId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidBookingIDException("Error retrieving booking: " + e.getMessage());
        }
//        return null;  // Return null if booking not found
	}

	

	

	@Override
	public boolean createEvent(EventProvider event) {
		String query = "INSERT INTO event (event_id, event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type, booking_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

 try (PreparedStatement stmt = conn.prepareStatement(query)) {
	 stmt.setInt(1, event.getEventId());
     stmt.setString(2, event.getEventName());
     stmt.setDate(3, java.sql.Date.valueOf(event.getEventDate())); // Convert LocalDate to java.sql.Date
     stmt.setTime(4, java.sql.Time.valueOf(event.getEventTime() + ":00")); // Convert LocalTime to java.sql.Time
//     stmt.setString(4, event.getVenueName());
     stmt.setInt(5, event.getVenueId());
     stmt.setInt(6, event.getTotalSeats());
     stmt.setInt(7, event.getAvailableSeats());
     stmt.setDouble(8, event.getTicketPrice());
     stmt.setString(9, event.getEventType().name()); // Save enum as String
     stmt.setInt(10, event.getBookingId());

     stmt.executeUpdate();
     return true;

 } catch (SQLException e) {
     e.printStackTrace();
     return false;
 }	
	}

	@Override
	public boolean cancelBooking(int bookingId) throws InvalidBookingIDException{
		String query = "DELETE FROM booking WHERE booking_id = ?"; 

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookingId);
//            stmt.executeUpdate();
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new InvalidBookingIDException("Invalid Booking ID: " + bookingId);
            }
            return true; // Cancellation successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Cancellation failed
        }

	}

	@Override
	public int getAvailableSeats(int eventId) {
		String query = "SELECT available_seats FROM event WHERE event_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("available_seats");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
	}

	@Override
	public EventProvider getEventDetails(int eventId) throws EventNotFoundException{
		String query = "SELECT * FROM event WHERE event_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                EventProvider event = new EventProvider();
                event.setEventName(rs.getString("event_name"));
                event.setEventDate(rs.getDate("event_date").toLocalDate());
                event.setEventTime(rs.getTime("event_time").toLocalTime());
                event.setVenueName(rs.getString("venue_id"));
                event.setTotalSeats(rs.getInt("total_seats"));
                event.setAvailableSeats(rs.getInt("available_seats"));
                event.setTicketPrice(rs.getDouble("ticket_price"));
                event.setEventType(EventProvider.EventType.valueOf(rs.getString("event_type").toUpperCase()));
                return event;
            } else {
                throw new EventNotFoundException("Event ID " + eventId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EventNotFoundException("Error retrieving event: " + e.getMessage());
        }
//        return null;
	}

	



}
