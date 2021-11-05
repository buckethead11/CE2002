package Table;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import reservations.Reservation;

import java.util.ArrayList;
import java.util.Arrays;

public class Table {
	private int tableID;
	//private TableSize tableSize;
	private int pax;
	private Reservation[] Reservations;
	
	public Table(int tableID,int pax) {
		this.tableID = tableID;
		this.pax = pax;
		//Allow for 5 time slots in a day. 1000,1200,1400,1600,1800
		//Get todays date as a string without time
		String dateToday = new SimpleDateFormat("dd/MM/yy").format(new Date());
		//Create an array list for each of the time slots
		ArrayList<String> timeslot = new ArrayList<String>(Arrays.asList("10:00","12:00","14:00","16:00","18:00"));
		
		Reservations = new Reservation[5];
		// Fill in the reservations object array
		for (int i =0;i<5;i++) {
			// Create a Calendar object to assign to reservation slot based on the index
			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy HH:mm");
		    try {
		    //Parse the date and time into a single string, to format to the requested reservation date
		    Date dateTime = dateFormatter.parse(dateToday + " "+timeslot.get(i));
		    //Calendar instance cal is set as a calendar object
		    cal.setTime(dateTime);
		    }catch(java.text.ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
			// Create new reservation object and assign the time of the day to each object in the array
			this.Reservations[i] = new Reservation(cal);
			
		}
	}
	
	//Getters
	public int getTableID() {
		return this.tableID;
	}
	public int getPax() {
		return this.pax;
	}
	//Takes in an index to specify which reservation from the array you would like to get
	public Reservation getReservation(int index){
		return this.Reservations[index];
	}
	//Takes in the time and returns the index of the reservation
	public int getReservationIndex(Calendar dateTime) {
		int index =-1;
		// Convert calendar date time into a string
		Date date = dateTime.getTime();  
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy HH:mm");  
		String dateTimeString = dateFormatter.format(date); 
		// Returns the index depending on the time of the reservation
		if (dateTimeString.contains("10:00")) {
			index = 0;
			return index;
		}else if (dateTimeString.contains("12:00")) {
			index = 1;
			return index;
		}else if (dateTimeString.contains("14:00")) {
			index = 2;
			return index;
		}else if (dateTimeString.contains("16:00")) {
			index = 3;
			return index;
		}else if (dateTimeString.contains("18:00")) {
			index = 4;
			return index;
		}else {
			return index;
		}
	}
	//Setters
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	public void setPax(int pax) {
		this.pax = pax;
	}
}
