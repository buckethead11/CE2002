package Table;

import java.util.ArrayList;
import java.util.Calendar;


import Reservation.Reservation;
import Reservation.Reservation_Control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Table_Control {
	
	private static ArrayList<Table> tableLayout;
	//Gets path of the project directory
	private static String userHome = System.getProperty("user.dir");
	public static String pathSeparator = File.separator; 
	private static String pathToCsv = userHome + pathSeparator + "data"+ pathSeparator + "tables.csv";
	
	//Initialises the table layout
	public static void init() {
		//create an array list of table layout with 20 tables
		tableLayout = new ArrayList<Table>(20);
		Table table;
		
		// Loads table layout
		try {
		BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
		csvReader.readLine(); // this will read the first line
		String line1=null;//skips first line
		String row ="";
		while ((row = csvReader.readLine()) != null) {
		    //reads each line and split it by comma into an array
			String[] line = row.split(",");
			int pax = Integer.parseInt(line[1]);
			int tableID = Integer.parseInt(line[0]);
			
			table = new Table(tableID, pax);
			tableLayout.add(table);
		}
		System.out.println("Table loaded");
		csvReader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Table> getTableLayout(){
		return tableLayout;
	}

	public static void updateTableReservation(){
		ArrayList<Reservation> reservationList = Reservation_Control.getReservationList();
		System.out.println(reservationList.size());
		for (int i =0; i<reservationList.size(); i++){
			Reservation reservation = reservationList.get(i);
			Calendar reservationDateTime = reservation.getDateTime();
			Calendar currentDateAndTime = Calendar.getInstance();

			int ReservationDay = reservationDateTime.DAY_OF_YEAR;
			int currentDay = currentDateAndTime.DAY_OF_YEAR;
			reservationDateTime.set(Calendar.HOUR_OF_DAY, reservationDateTime.get(Calendar.HOUR_OF_DAY)-1);
			//debugging
			/*
			System.out.println("Current Date and Time: "+ currentDateAndTime);
			System.out.println("Reservation Date and Time "+ reservationDateTime);
			System.out.println("Reservation Hour "+ reservationDateTime.HOUR);
			System.out.println("System Hour "+ currentDateAndTime.HOUR);
			*/
			//checking
			if(ReservationDay== currentDay){
				if (reservationDateTime.HOUR_OF_DAY == currentDateAndTime.HOUR_OF_DAY){
					int tableID = reservation.getTableID();
					tableLayout.get(tableID).setOccupied(true);
					System.out.println("Table Reservations Updated: ");
					System.out.println("Table: " + tableID +" set to Occupied");
					
				} //assume reservations made from 12noon - 12mn

			}
		}
	}
	public static void checkTableStatus(){
		for (int i =0; i < tableLayout.size();i++){
			//If table is occupied print table number is occupied
			if (tableLayout.get(i).getOccupied()){
				System.out.println("Table "+tableLayout.get(i).getTableID()+" status: Occupied");
			}else{
				System.out.println("Table "+tableLayout.get(i).getTableID()+" status: Available");
			}
		}
	}

}


