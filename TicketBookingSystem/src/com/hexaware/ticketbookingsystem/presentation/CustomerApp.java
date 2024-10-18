package com.hexaware.ticketbookingsystem.presentation;

import java.util.Scanner;

import com.hexaware.ticketbookingsystem.entity.Customer;
import com.hexaware.ticketbookingsystem.service.CustomerService;

public class CustomerApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        CustomerService customerService = new CustomerService();

        System.out.println("Welcome to the Customer Management System!");

        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. View Customer Details by Name");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String venueName = scanner.nextLine();
                    Customer customer = customerService.getCustomerByName(venueName);
                    
                    if (customer != null) {
                        customerService.displayCustomerDetails(customer);
                    } else {
                        System.out.println("Customer not found!");
                    }
                    break;
                case 2:
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();

	}

}
