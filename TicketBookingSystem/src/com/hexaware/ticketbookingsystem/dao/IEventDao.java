package com.hexaware.ticketbookingsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.ticketbookingsystem.entity.Event;

public interface IEventDao {


	Event getEventById(int eventId) throws SQLException;
	List<Event> getAllEvents();
    void addEvent(Event event);
    void updateEvent(Event event);

}
