package Reservation;

import java.util.InputMismatchException;
import java.util.Scanner;

import Table.Table_Control;

public class Reservation_UI {

	public void displayUI() {
		Scanner sc = new Scanner(System.in);
		int choice;
		boolean run = true;

		do {
			System.out.println("\n============RESERVATIONS===============");
			System.out.println("(1) Create Reservations");
			System.out.println("(2) View Reservations");
			System.out.println("(3) Delete Reservation");
			System.out.println("(4) Update Table reservations");
			System.out.println("(5) Return to main menu");
			System.out.println("=======================================");
			System.out.print("What do you want to do? ");
			try {
				choice = sc.nextInt();
				if (!(choice >= 1 && choice <= 5)) {
					System.out.println("Input must be an integer from 1-5!");
				}
				switch (choice) {
				case 1: // Create Reservations
					System.out.println("Please enter Reservation date (dd/mm/yy)");
					String date = sc.next();
					System.out.println("Please enter Reservation Time (hh:mm) ");
					String time = sc.next();
					System.out.println("Please enter the pax: ");
					int pax = sc.nextInt();
					System.out.println("Please enter your name: ");
					String name = sc.next();
					System.out.println("Please enter your contact: ");
					int contact = sc.nextInt();

					Reservation_Control.createReservation(date, time, pax, name, contact);
					break;
				case 2: // View Reservations
					System.out.println("Please enter your name");
					String x = sc.next();
					System.out.println("Please enter your contact number");
					int y = sc.nextInt();
					Reservation_Control.viewReservation(x, y);
					break;
				case 3: // Delete Reservation
					System.out.println("Please enter your name");
					String z = sc.next();
					System.out.println("Please enter your contact number");
					int a = sc.nextInt();
					Reservation_Control.deleteReservation(z, a);
					break;
				case 4: // update table reservations
					System.out.println("Updating Table Reservations");
					Table_Control.updateTableReservation();
					break;
				case 5: // Exit
					Reservation_Control.saveReservation();
					run = false;
					System.out.println("Returning to main menu...");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Input must be an integer!");
				sc.nextLine();
				continue;
			}

		} while (run);
	}
}
