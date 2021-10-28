package reservations;

import java.util.Scanner;

public class reservation_UI {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("(1) Create Reservations");
			System.out.println("(2) View Reservations");
			System.out.println("(3) Delete Reservation");
			System.out.println("(4) Exit");
			choice = sc.nextInt();
			switch (choice) {
				case 1: // Create Reservations
					System.out.println("Please enter Reservation start time");
					int startDateTime = sc.nextInt();
					System.out.println("Please enter Reservation end time: ");
					int endDateTime = sc.nextInt();
					System.out.println("Please enter the pax: ");
					int pax = sc.nextInt();
					System.out.println("Please enter your name: ");
					String name = sc.next();
					System.out.println("Please enter your contact: ");
					int contact = sc.nextInt();
					reservation_control.createReservation(startDateTime , endDateTime, pax, name, contact);
					break;
				case 2: // View Reservations
					System.out.println("Please enter your name");
					String x = sc.next();
					System.out.println("Please enter your contact number");
					int y = sc.nextInt();
					reservation_control.viewReservation(x,y);
					break;
				case 3: // Delete Reservation
					System.out.println("Please enter your name");
					String z = sc.next();
					reservation_control.deleteReservation(z);
					break;
				case 4: // Exit
					System.out.println("Exiting...");
					break;
				}
			} while (choice < 4);
		}
}
