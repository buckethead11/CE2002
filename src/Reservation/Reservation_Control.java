package Reservation;

import java.util.Date;

import Table.Table_Control;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reservation_Control{
	
	//Methods
	
	public static void displayUI() {
		Reservation_UI.showReservationUI();
	}
	//Called when creating Reservation
	public static void createReservation(String date, String time, int pax, String name, int contact) {
		// Current date
		Calendar now = Calendar.getInstance();
		now.getTime();
		// Create a Calendar instance. To be assigned the inputed date time
		Calendar cal = Calendar.getInstance();
		try {
			// Create a custom date formatter with the same format as the input string
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy HH:mm");
			Date reservedate = dateFormatter.parse(date + " "+time);
			cal.setTime(reservedate);
			}catch(java.text.ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		//Check if table is avaliable, assigns a table id to a variable. If theres no table ID should be 0
		int tableID =Table_Control.checkTable(cal, pax);
		//Pass this reservation object to the table array. Include table IDs
		Table_Control.assignTable(cal, pax, name, contact,tableID);
	}
	
	
	//Called when deleting Reservations
	public static void deleteReservation(String name) {
		
	}
	
	
	//Called when viewing reservation
	public static void viewReservation(String name, int contact) {
		boolean notFound = true;
		//Iterates through the tables
		for (int i =0;i<10;i++) {
			//Iterates through the reservations in the table
			for (int j =0;j<5;j++) {
				//Check if name and contact matches the table
				if (name.equals(Table_Control.getTableLayout(i).getReservation(j).getName()) && contact==Table_Control.getTableLayout(i).getReservation(j).getContact()) {
					//Converts date to string
					Calendar date = Table_Control.getTableLayout(i).getReservation(j).getDateTime();
					SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy HH:mm");
					String strDate = dateFormatter.format(date.getTime());
					//Print out reservation bookings
					System.out.println("Resevation name: " +Table_Control.getTableLayout(i).getReservation(j).getName() );
					System.out.println("Resevation date and time: " + strDate);
					System.out.println("Resevation pax: " + Table_Control.getTableLayout(i).getPax());
					notFound = false;
				}
			}
		}
		if (notFound) {
			System.out.println("No reservation found!");
		}
	}
}
