package Table;

import java.util.ArrayList;

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
}

