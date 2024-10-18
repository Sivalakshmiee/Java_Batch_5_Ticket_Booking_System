package com.hexaware.ticketbookingsystem.controlstructure;

import java.util.Scanner;

public class NestedPremium {

	public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
		
		System.out.println("Available Ticket Categories:");
		System.out.println("1. Silver - Rs.1000" + "\n" + "2. Gold - Rs.3000" + "\n" + "3. Diamond - Rs.5000");
		
		System.out.println("Enter ticket category (Silver/Gold/Diamond): ");
		String ticketType = scanner.next();
		
		System.out.println("Enter the number of tickets you want to book: ");
		int noOfTicket = scanner.nextInt();
		
		int ticketPrice = 0;
		
		if (ticketType.equals("Silver")) {
			ticketPrice = 1000;
		}
		
		else if(ticketType.equals("Gold")) {
			ticketPrice = 3000;
		}
		
		else if(ticketType.equals("Diamond")) {
			ticketPrice = 5000;
		}
		else {
			System.out.println("Invalid");
			scanner.close();
			return;
		}
		
		// Calculate total cost
        int totalCost = ticketPrice * noOfTicket;
        
        // Display the total cost of the tickets
        System.out.println("You have selected " + noOfTicket + " " + ticketType + " tickets.");
        System.out.println("Total cost: Rs. " + totalCost);
        
        // Close the scanner to prevent resource leak
        scanner.close();


	}

}
