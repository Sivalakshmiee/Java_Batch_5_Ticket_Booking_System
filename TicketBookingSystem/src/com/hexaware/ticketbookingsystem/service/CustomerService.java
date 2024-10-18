package com.hexaware.ticketbookingsystem.service;

import com.hexaware.ticketbookingsystem.dao.CustomerDaoImp;

import com.hexaware.ticketbookingsystem.entity.Customer;

public class CustomerService {
	
	private final CustomerDaoImp customerDAO = new CustomerDaoImp();
	
	// Fetch venue details by name
    public Customer getCustomerByName(String customerName) {
        try {
            return customerDAO.getCustomerByName(customerName); 
        } catch (Exception e) {
            System.err.println("Error fetching customer: " + e.getMessage());
            return null;
        }
    }
	
	public void displayCustomerDetails(Customer customer) {
        if (customer != null) {
            System.out.println("Customer Name: " + customer.getCustomerName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone Number: " + customer.getPhoneNumber());
        } else {
            System.out.println("Customer not found.");
        }
    }

}
