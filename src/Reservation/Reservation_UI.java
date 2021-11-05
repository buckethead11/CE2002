package Reservation;

import java.util.Scanner;

public class Reservation_UI {
	
	public static void showReservationUI() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("(1) Create Reservations");
			System.out.println("(2) View Reservations");
			System.out.println("(3) Delete Reservation");
			System.out.println("(4) Return to main menu");
			choice = sc.nextInt();
			switch (choice) {
				case 1: // Create Reservations
					System.out.println("Please enter Reservation date (dd/mm/yy)");
					//String date = sc.next();
					// Only can input 1000 1200 1400 1600 1800
					System.out.println("Please enter Reservation Time (hh:mm) ");
					//String time = sc.next();
					System.out.println("Please enter the pax: ");
					//int pax = sc.nextInt();
					System.out.println("Please enter your name: ");
					//String name = sc.next();
					System.out.println("Please enter your contact: ");
					//int contact = sc.nextInt();
					
					//TEST
					String time = "10:00";
					String date = "05/11/21";
					int pax = 5;
					String name = "avran";
					int contact = 1234;
					Reservation_Control.createReservation(date , time, pax, name, contact);
					break;
				case 2: // View Reservations
					System.out.println("Please enter your name");
					String x = sc.next();
					System.out.println("Please enter your contact number");
					int y = sc.nextInt();
					Reservation_Control.viewReservation(x,y);
					break;
				case 3: // Delete Reservation
					System.out.println("Please enter your name");
					String z = sc.next();
					Reservation_Control.deleteReservation(z);
					break;
				case 4: // Exit
					System.out.println("Returning to main menu...");
					break;
				}
			} while (choice < 4);
		}
}
