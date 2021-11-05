package Reservation;

public class Reservation {
    private int startDateTime;
    private int endDateTime;
    private int pax;
    private String name;
    private int contact;
    private boolean occupied;

    // Constructor
    public Reservation(int startDateTime, int endDateTime) {
        // Constructs reservation with a variable start and end time. pax name and
        // contact is defaulted as 0/NA
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.pax = 0;
        this.name = "NA";
        this.contact = 0;
        occupied = false;
    }

    // Getters
    public int getstartDateTime() {
        return this.startDateTime;
    }

    public int getendDateTime() {
        return this.endDateTime;
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

    public boolean getOccupied() {
        return this.occupied;
    }

    // Setters
    public void setOccupied(boolean bool) {
        this.occupied = bool;
    }

    public void setName(String name) {
        this.name = name;
    }

}
