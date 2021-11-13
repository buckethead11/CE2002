import java.util.Scanner;
import Table.Table_Control;
import Reservation.*;
import Sales.Sales_UI;
import Menu.*;
import Order.*;

public class App {
	private Sales_UI salesUI;
	private Menu_UI menuUI;
	private Order_UI orderUI;
	private Reservation_UI reservationUI;

	public static void main(String[] args) {
		// Initialize controllers (add on controllers for those that needs to be
		// initialized)
		Table_Control.init();
		Reservation_Control.init();
		Menu_Control.init();
		Menu_UI menuUI = new Menu_UI();
		Order_UI orderUI = new Order_UI();
		Reservation_UI reservationUI = new Reservation_UI();
		Sales_UI salesUI = new Sales_UI();
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
				menuUI.displayUI();
				break;
			case 2:
				reservationUI.displayUI();
				break;
			case 3:
				orderUI.displayUI();
				break;
			case 4:
				salesUI.displayUI();
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
