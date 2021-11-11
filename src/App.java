import java.util.Scanner;
import Table.Table_Control;
import Reservation.Reservation_Control;
import Menu.Menu_Control;
import Order.Order_Control;

public class App {

	public static void main(String[] args) {
		// Initialize controllers (add on controllers for those that needs to be
		// initialized)
		Table_Control.init();
		Reservation_Control.init();
		Menu_Control.init();
		// Show main menu UI
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n============OODP RESTAURANT MAIN MENU===============");
			System.out.println("(1) Menu");
			System.out.println("(2) Reservations");
			System.out.println("(3) Order");
			System.out.println("(4) View Sales Report");
			System.out.println("(5) Log out");
			System.out.println("====================================================");
			System.out.print("Where do you want to go? ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Menu_Control.displayUI();
				break;
			case 2:
				Reservation_Control.displayUI();
				break;
			case 3:
				Order_Control.displayUI();
				break;
			case 4:

				break;
			case 5: // Exit
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("THANK YOU FOR USING OUR OODP RESTAURANT APP!!!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

				break;
			}
		} while (choice < 5);
	}
}
