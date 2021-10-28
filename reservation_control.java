package reservations;

public class reservation_control{
	//Methods
	//Called when creating Reservation
	public static void createReservation(int startDateTime , int endDateTime, int pax, String name, int contact) {
		//Check if table is avaliable, assigns a table id to a variable. If theres no table ID should be 0
		int tableID =table_control.checktable(startDateTime, endDateTime, pax);
		//Pass this reservation object to the table array. Include table IDs
		table_control.assigntable(startDateTime , endDateTime, pax, name, contact,tableID);
	}
	//Called when deleting Reservations
	public static void deleteReservation(String name) {
		
	}
	//Called when viewing reservation
	public static void viewReservation(String name, int contact) {
		//Iterates through the tables
		for (int i =0;i<10;i++) {
			//Iterates through the reservations in the table
			for (int j =0;i<5;j++) {
				//Check if name and contact matches the table
				if (name == table_control.gettablelayout(i).getreservation(j).getname() & contact == table_control.gettablelayout(i).getreservation(j).getcontact()) {
					//Return reservation if matches
				}
			}
		}
	}
}
