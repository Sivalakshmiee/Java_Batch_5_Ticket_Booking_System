package com.hexaware.ticketbookingsystem.controlstructure;

import java.util.Scanner;

public class ConditionalBookingSystem {

	public static void main(String[] args) {
		
		// task 1(1)
        Scanner s = new Scanner(System.in);
        
     
        System.out.print("Enter the available tickets: ");
        int availableTicket = s.nextInt();
        
       
        System.out.print("Enter the Number of Booking Tickets: ");
        int noOfBookingTicket = s.nextInt();
        
        // Check if booking is possible based on available tickets - task 1(2)
        if (availableTicket >= noOfBookingTicket) {
            availableTicket = availableTicket - noOfBookingTicket; // Subtract booked tickets from available tickets - task 1(3)
            System.out.println("Booking Successful! Remaining tickets: " + availableTicket);
        } else {
            System.out.println("Oops! Not enough tickets available.");
        }
        
        s.close();


	}

}
