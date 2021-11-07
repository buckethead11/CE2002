package Table;

import java.util.ArrayList;
import java.util.Calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class Table_Control {
	
	private static ArrayList<Table> tableLayout;
	//Gets path of the project directory
	private static String userHome = System.getProperty("user.dir");
	public static String pathSeparator = File.separator; 
	private static String pathToCsv = userHome+ pathSeparator + "src" + pathSeparator + "data"+ pathSeparator + "tables.csv";
	
	
	
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
	
	
	//Methods
	public static int checkTable(Calendar dateTime, int pax) {
		int i = 0;
		int index = 0;
		//Iterates through the table layout
		for (i =0;i<10;i++) {
			//If table can fit the pax and is not occupied
			if (tableLayout.get(i).getPax() >= pax && tableLayout.get(i).getReservation(i).getOccupied() == false ){
				System.out.println("Table found!");
				index = i;
				return index;
				}else{
					System.out.println ("There are no tables avaliable");
					return 0;
				}
			}
		//returns the table id to the reservation controller
		return tableLayout.get(i).getTableID();
		}	
	//assigns the reservation to the table
	public static void assignTable(Calendar dateTime, int pax, String name, int contact,int tableID) {
		//Pushes the reservation to the table
		//Gets the index of the reservation array based on the timing
		int index = tableLayout.get(tableID).getReservationIndex(dateTime);
		//Sets the name of the reservation
		tableLayout.get(tableID).getReservation(index).setName(name);
		//Sets the contact of the reservation
		tableLayout.get(tableID).getReservation(index).setContact(contact);
		//Sets occupied to true
		tableLayout.get(tableID).getReservation(index).setOccupied(true);
		System.out.println("Table assigned!");
		
	}
}

