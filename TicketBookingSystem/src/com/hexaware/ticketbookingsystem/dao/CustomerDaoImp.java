package com.hexaware.ticketbookingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.ticketbookingsystem.entity.Customer;

public class CustomerDaoImp {
	
	private final Connection conn;
	
	public CustomerDaoImp() {
        conn = DBUtil.getDBConnection(); 
    }
	
	// Fetch customer details by name
    public Customer getCustomerByName(String customerName) {
        String query = "SELECT * FROM customers WHERE customer_name = ?";
        Customer customer = null;

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, customerName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(
                            rs.getString("customer_name"),
                            rs.getString("email"),
                            rs.getString("phone_number")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching customer by name: " + e.getMessage());
        }
        return customer;
    }
	
	

}
