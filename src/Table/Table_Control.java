package Table;

import java.util.Calendar;

public class Table_Control {
	//create table layout with 10 tables
	private static Table[] table_layout = new Table[10];
	
	public static void init() {
		// Fill in the table object array
		for (int i =0;i<10;i++) {
			// Create new Table object and give it a table id and pax number
			table_layout[i] = new Table(i,5);
		}
	}
	
	//Getter
	public static Table getTableLayout(int index) {
		return table_layout[index];
	}
	//Methods
	public static int checkTable(Calendar dateTime, int pax) {
		int i = 0;
		int index = 0;
		//Iterates through the table layout
		for (i =0;i<10;i++) {
			//If table can fit the pax and is not occupied
			if (table_layout[i].getPax() >= pax && table_layout[i].getReservation(i).getOccupied() == false ){
				System.out.println("Table found!");
				index = i;
				return index;
				}else{
					System.out.println ("There are no tables avaliable");
					return 0;
				}
			}
		//returns the table id to the reservation controller
		return table_layout[index].getTableID();
		}	
	//assigns the reservation to the table
	public static void assignTable(Calendar dateTime, int pax, String name, int contact,int tableID) {
		//Pushes the reservation to the table
		//Gets the index of the reservation array based on the timing
		int index = Table_Control.getTableLayout(tableID).getReservationIndex(dateTime);
		//Sets the name of the reservation
		Table_Control.getTableLayout(tableID).getReservation(index).setName(name);
		//Sets the contact of the reservation
		Table_Control.getTableLayout(tableID).getReservation(index).setContact(contact);
		//Sets occupied to true
		Table_Control.getTableLayout(tableID).getReservation(index).setOccupied(true);
		System.out.println("Table assigned!");
		
	}
}

