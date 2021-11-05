package Reservation;

import java.util.Calendar;

public class Reservation {
	private Calendar dateTime;
	private String name;
	private int contact;
	private boolean occupied;
	// Constructor
	public Reservation( Calendar dateTime) {
		//Constructs reservation with a variable start and end time. pax name and contact is defaulted as 0/NA
		this.dateTime = dateTime;
		name = "NA";
		contact = 0;
		occupied = false;
		}
	
	//Getters
	public Calendar getDateTime() {
		
		return dateTime;
	}
	
	
	public String getName() {
		return this.name;
	}
	public int getContact() {
		return this.contact;
	}
	public boolean getOccupied() {
		return this.occupied;
	}
	
	//Setters
	public void setOccupied(boolean bool) {
		this.occupied = bool;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
}
