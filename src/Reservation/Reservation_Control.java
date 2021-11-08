package reservations;

import java.util.Date;

import Table.Table;
import Table.Table_Control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Reservation_Control{
	
	private static ArrayList<Reservation> reservationList;
	//Gets path of the project directory
	private static String userHome = System.getProperty("user.dir");
	public static String pathSeparator = File.separator; 
	private static String pathToCsv = userHome+ pathSeparator + "src" + pathSeparator + "data"+ pathSeparator + "reservations.csv";

	public static void init() {
		//create an array list of reservations
		reservationList = new ArrayList<Reservation>();
		Reservation reservation;
		Calendar date = Calendar.getInstance();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy HH:mm");
		// Loads table layout
		try {
		BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
		csvReader.readLine(); // this will read the first line
		String line1=null;//skips first line
		String row ="";
		while ((row = csvReader.readLine()) != null) {
		    //reads each line and split it by comma into an array
			String[] line = row.split(",");
			
			String datestr = line[0];
			date.setTime(dateFormatter.parse(datestr));
			int pax = Integer.parseInt(line[1]);
			String name = line[2];
			int contact =Integer.parseInt(line[3]);
			int tableID = Integer.parseInt(line[4]);
			
			reservation = new Reservation(date,pax,name,contact,tableID);
			//Sets the tables with occupied to have a status that is true
			Table_Control.getTableLayout().get(tableID-1).setOccupied(true);
			reservationList.add(reservation);
		}
		System.out.println("Reservations loaded");
		csvReader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Methods
	public static void displayUI() {
		Reservation_UI.showReservationUI();
	}
	
	
	//Called when creating Reservation
	public static void createReservation(String date, String time, int pax, String name, int contact) {
		// Create a Calendar instance. To be assigned the inputed date time
		Calendar reserveDate = Calendar.getInstance();
		try {
			// Create a custom date formatter with the same format as the input string
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy HH:mm");
			Date d = dateFormatter.parse(date + " "+time);
			reserveDate.setTime(d);
			//Check tables to see if any can fit the pax. checktable returns an array of possible tableID
			//Checks through the available tables to see if any of them has a clashing reservation
			int tableID = Reservation_Control.checkAvailable(pax, reserveDate);
			if(tableID ==-1) {
				System.out.println("No tables available");
			}else {
				//Add this reservation to the reservation list
				Reservation newreservation = new Reservation(reserveDate,  pax, name, contact, tableID);
				
				reservationList.add(newreservation);
				System.out.println("Reservation Created!");
			}
			}catch(java.text.ParseException e) {
	            // TODO Auto-generated catch block
	            System.out.println("Please input your date and time in the correct format!");
	        }
		
		
	}
	
	
	//Called when deleting Reservations
	public static void deleteReservation(String name) {
		
	}
	//Check for expired reservations and deletes them
	public static void checkReservation() {
		
	}
	//Called when viewing reservation
	public static void viewReservation(String name, int contact) {
		boolean notFound = true;
		//Iterates through the reservations in the table
		for (int i =0;i<reservationList.size();i++) {
			//Check if name and contact matches the table
			if (name.equals(reservationList.get(i).getName()) && contact==reservationList.get(i).getContact()) {
				//Converts date to string
				Calendar date = reservationList.get(i).getDateTime();
				SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy HH:mm");
				String strDate = dateFormatter.format(date.getTime());
				//Print out reservation bookings
				System.out.println("Resevation name: " +reservationList.get(i).getName() );
				System.out.println("Resevation date and time: " + strDate);
				System.out.println("Resevation pax: " + reservationList.get(i).getPax());
				notFound = false;
			}
		}
		if (notFound) {
			System.out.println("No reservation found!");
		}
	}
	
	
	public static int checkAvailable(int pax,Calendar reservedDate) {
		int tableID = -1;
		ArrayList<Integer> tables = new ArrayList<Integer>();
		//Iterates through each table in the layout to check for pax and occupied. If not occupied, return the table ID
		for (int i = 0; i<Table_Control.getTableLayout().size();i++) {
			//Deals with even pax requests
			if(pax == Table_Control.getTableLayout().get(i).getPax()&& !Table_Control.getTableLayout().get(i).getOccupied()) {
				//Assign available table with the suitable pax to the arraylist of avail tables
				tableID = Table_Control.getTableLayout().get(i).getTableID();
				
			}else if (pax+1 == Table_Control.getTableLayout().get(i).getPax()&& !Table_Control.getTableLayout().get(i).getOccupied()) { //Deals with odd numbers
				//Assign available table with the suitable pax to the arraylist of avail tables
				tableID = Table_Control.getTableLayout().get(i).getTableID();
				
			}
		}
		//if all proposed tables is occupied, check the reservations list to see if the occupied table has a clashing reservation
		if (tableID == -1) {
			//iterates through reservation list to see if table has a clashing reservation
			for (int j = 0; j<reservationList.size();j++) {
				
			}
			return tableID;
		}else {
			return tableID;
		}
	}
	
	public static void saveReservation() {
		System.out.println("Saving Reservations...");
		FileWriter writer;
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy HH:mm");


		try {
			writer = new FileWriter(pathToCsv);
			writer.append("date, pax, name, contact, tableID\n");
			for(int k=0 ; k< reservationList.size();k++) {
	            String dateTime = dateFormatter.format((Date)reservationList.get(k).getDateTime().getTime());
	            String pax = Integer.toString(reservationList.get(k).getPax());
	            String name = reservationList.get(k).getName();
	            String contact = Integer.toString(reservationList.get(k).getContact());
	            String tableID = Integer.toString(reservationList.get(k).getTableID());
	            writer.append(dateTime + "," + pax + "," + name + "," + contact + "," + tableID + "\n");
	        }
	        writer.flush();
	        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Saved!");
    }
	
}
