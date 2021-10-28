package reservations;


public class table_control {
	//create table layout with 10 tables
	private static table[] table_layout = new table[10];
	
	public table_control() {
		// Fill in the table object array
		for (int i =0;i<10;i++) {
			// Create new Table object and give it a table id and pax number
			table_layout[i] = new table(i,5);
		}
	}
	
	//Getter
	public static table gettablelayout(int index) {
		return table_layout[index];
	}
	//Methods
	public static int checktable(int startDateTime, int endDateTime, int pax) {
		int i = 0;
		//Iterates through the table layout
		for (i =0;i<10;i++) {
			//If table can fit the pax and is not occupied
			//how to refer to non static object in a static method
			if (table_layout[i].getpax() >= pax && table_layout[i].getreservation(startDateTime).getoccupied() == false ){
				System.out.println("Table found!");
				return i;
				}else{
					System.out.println ("There are no tables avaliable");
					return 0;
				}
			}
		//returns the table id to the reservation controller
		return table_layout[i].gettableID();
		}	
	//assigns the reservation to the table
	public static void assigntable(int startDateTime , int endDateTime, int pax, String name, int contact,int tableID) {
		//Pushes the reservation to the table
		//Gets the index of the reservation array based on the timing
		int index = table_control.gettablelayout(tableID).getreservationindex(startDateTime);
		//Sets the details of the reservation
		table_control.gettablelayout(tableID).getreservation(index).setname(name);
		//Sets occupied to true
		table_control.gettablelayout(tableID).getreservation(index).setoccupied(true);
		
		
	}
}

