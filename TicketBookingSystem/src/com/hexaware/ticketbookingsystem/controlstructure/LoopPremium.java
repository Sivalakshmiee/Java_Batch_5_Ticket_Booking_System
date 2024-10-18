package com.hexaware.ticketbookingsystem.controlstructure;

import java.util.Scanner;

public class LoopPremium {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String userInput = "";

        // loop
        
        while (!userInput.equalsIgnoreCase("Exit")) {
        	System.out.println("Available Ticket Categories:");
    		System.out.println("1. Silver - Rs.1000" + "\n" + "2. Gold - Rs.3000" + "\n" + "3. Diamond - Rs.5000");
           
            System.out.print("Enter the ticket category (Silver/Gold/Diamond) or type 'Exit' to quit: ");
            userInput = scanner.next();

            // Check if the user wants to exit
            if (userInput.equals("Exit")) {
                System.out.println("Exiting the booking system. Thank you!");
                break; // Exit the loop
            }

            // Input for number of tickets
            System.out.print("Enter the number of tickets you want to book: ");
            int noOfTickets = scanner.nextInt();

            int ticketPrice = 0;

            if (userInput.equals("Silver")) {
                ticketPrice = 1000;
            } else if (userInput.equals("Gold")) {
                ticketPrice = 3000;
            } else if (userInput.equals("Diamond")) {
                ticketPrice = 5000;
            } else {
                System.out.println("Invalid ticket type. Please enter Silver, Gold, or Diamond.");
                continue; // Go back to the beginning of the loop for a valid input
            }

            // Calculate total cost
            int totalCost = ticketPrice * noOfTickets;

            
            System.out.println("You have selected " + noOfTickets + " " + userInput + " tickets.");
            System.out.println("Total cost: Rs. " + totalCost);

            
            System.out.println("Type 'Exit' to quit or press any other key to continue booking.");
            userInput = scanner.next(); // Read the next input
        }

        // Close the scanner to prevent resource leak
        scanner.close();


	}

}
