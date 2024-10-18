package com.hexaware.ticketbookingsystem.dao;

import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Event.EventType;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class EventDaoImp implements IEventDao {
    private final Connection conn;
    private List<Event> event = new ArrayList<>();

    public EventDaoImp() {
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

	@Override
	public List<Event> getAllEvents() {
		return event;
	}

	@Override
	public void addEvent(Event event) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO events (event_name, event_date, event_time, venue_name, total_seats, available_seats, ticket_price, event_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event.getEventName());
            pstmt.setDate(2, Date.valueOf(event.getEventDate()));
            pstmt.setTime(3, Time.valueOf(event.getEventTime()));
            pstmt.setString(4, event.getVenueName());
            pstmt.setInt(5, event.getTotalSeats());
            pstmt.setInt(6, event.getAvailableSeats());
            pstmt.setDouble(7, event.getTicketPrice());
            
         // Validate and set event type
            EventType eventType = event.getEventType();
            if (isValidEventType(eventType)) {
            	pstmt.setString(8, event.getEventType().name());
            } else {
                System.out.println("Invalid event type. Allowed values: Movie, Sports, Concert.");
                return;
            }
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	

	private boolean isValidEventType(EventType eventType) {
		return eventType == EventType.MOVIE ||
	               eventType == EventType.SPORTS ||
	               eventType == EventType.CONCERT;
	}

	@Override
	public void updateEvent(Event event) {
		// TODO Auto-generated method stub
		 String sql = "UPDATE events SET available_seats = ? WHERE event_name = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, event.getAvailableSeats());
	            pstmt.setString(2, event.getEventName());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
	}




		

