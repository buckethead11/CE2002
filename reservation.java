package reservations;

public class reservation {
	private int startDateTime;
	private int endDateTime;
	private int pax;
	private String name;
	private int contact;
	private boolean occupied;
	// Constructor
	public reservation( int startDateTime , int endDateTime) {
		//Constructs reservation with a variable start and end time. pax name and contact is defaulted as 0/NA
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.pax = 0;
		this.name = "NA";
		this.contact = 0;
		occupied = false;
		}
	
	//Getters
	public int getstartDateTime() {
		return this.startDateTime;
	}
	public int getendDateTime() {
		return this.endDateTime;
	}
	public int getpax() {
		return this.pax;
	}
	public String getname() {
		return this.name;
	}
	public int getcontact() {
		return this.contact;
	}
	public boolean getoccupied() {
		return this.occupied;
	}
	//Setters
	public void setoccupied(boolean bool) {
		this.occupied = bool;
	}
	public void setname(String name) {
		this.name = name;
	}
	
}
