package Table;

import java.util.Calendar;
import java.util.Hashtable;
import Reservation.Reservation;

public class Table {
	private int tableID;
	//private TableSize tableSize;
	private int pax;
	private boolean occupied;

	//private Hashtable<Calendar, Reservation> tableReservations;
	

	public Table(int tableID,int pax) {
		this.tableID = tableID;
		this.pax = pax;
		occupied = false;
		//this.tableReservations = new Hashtable<Calendar,Reservation>();

	}
/* code for the hash table not needed anymore right
	public Hashtable<Calendar, Reservation> getTableReservations(){
		return tableReservations;
	}
*/
	
	//Getters
	public int getTableID() {
		return this.tableID;
	}
	public int getPax() {
		return this.pax;
	}
	public boolean getOccupied() {
		return this.occupied;
	}
	//Setters
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	public void setPax(int pax) {
		this.pax = pax;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
}
