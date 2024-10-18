package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.dao.IBookingSystemRepositoryImpl;
import com.hexaware.ticketbookingsystem.entity.EventProvider;

public class IEventServiceProviderImpl implements IEventServiceProvider{
	
	private IBookingSystemRepositoryImpl eventRepo;

    public IEventServiceProviderImpl() {
        this.eventRepo = new IBookingSystemRepositoryImpl();
    }


	@Override
	public boolean createEvent(EventProvider event) {
		// TODO Auto-generated method stub
		return eventRepo.createEvent(event);
	}


	@Override
	public int getAvailableSeats(int eventId) {
		return eventRepo.getAvailableSeats(eventId);
	}

}
