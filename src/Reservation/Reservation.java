package Reservation;

import java.util.Calendar;

public class Reservation {
	private Calendar dateTime;
	private int pax;
	private String name;
	private int contact;
	private int tableID;
	
	// Constructor
	public Reservation( Calendar dateTime, int pax, String name, int contact, int tableID) {
		//Constructs reservation with a variable start and end time. pax name and contact is defaulted as 0/NA
		this.dateTime = dateTime;
		this.pax = pax;
		this.name = name;
		this.contact = contact;
		this.tableID = tableID;
		}
	
	//Getters
	public Calendar getDateTime() {
		return this.dateTime;
	}
	public int getPax() {
		return this.pax;
	}
	public String getName() {
		return this.name;
	}
	public int getContact() {
		return this.contact;
	}
	
	public int getTableID() {
		return this.tableID;
	}
	
	
	//Setters
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}
	public void setPax(int pax) {
		this.pax = pax;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public void getTableID(int tableID) {
		this.tableID = tableID;
	}
	
	
}
