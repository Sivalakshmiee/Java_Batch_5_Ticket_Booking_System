package com.hexaware.ticketbookingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Event.EventType;

public class BookingDaoImp implements IBookingDao{
	
	private final Connection conn;
	
	public BookingDaoImp() {
        conn = DBUtil.getDBConnection();
    }
	
	public Event getEventById(int eventId) {
        String query =  "SELECT e.*, v.venue_name FROM event e " +
                "JOIN venu v ON e.venue_id = v.venue_id " +
                "WHERE e.event_id = ?";
        Event event = null;

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, eventId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    event = new Event(
                            rs.getString("event_name"),
                            rs.getDate("event_date").toLocalDate(),
                            rs.getTime("event_time").toLocalTime(),
                            rs.getString("venue_name"),
                            rs.getInt("total_seats"),
                            rs.getInt("available_seats"), // Added availableSeats here
                            rs.getDouble("ticket_price"),
                            EventType.valueOf(rs.getString("event_type").toUpperCase()) // Handle potential error
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching event by ID: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid event type: " + e.getMessage());
        }
        return event;

}
}
