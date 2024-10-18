package com.hexaware.ticketbookingsystem.dao;

import java.sql.SQLException;

import com.hexaware.ticketbookingsystem.entity.Event;

public interface IBookingDao {
	
	Event getEventById(int eventId) throws SQLException;

}
