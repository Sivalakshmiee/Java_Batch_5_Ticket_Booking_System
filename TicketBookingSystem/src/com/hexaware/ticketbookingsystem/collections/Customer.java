package com.hexaware.ticketbookingsystem.collections;

public class Customer {
	
	private int customerId;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Customer(int customerId, String customerName, String email, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerId() {
        return customerId; // Get customer ID
    }

}
