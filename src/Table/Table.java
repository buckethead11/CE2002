package Table;

import Reservation.*;

public class Table {
    private int tableID;
    // private TableSize tableSize;
    private int pax;
    private Reservation[] Reservations;

    public Table(int tableID, int pax) {
        int start = 0;
        int end = 0;
        this.tableID = tableID;
        this.pax = pax;
        // Allow for 5 time slots in a day. 1000,1200,1400,1600,1800
        Reservations = new Reservation[5];
        // Fill in the reservations object array
        for (int i = 0; i < 5; i++) {
            // Create new reservation object and give it a start time and end time
            this.Reservations[i] = new Reservation(1000 + start, 1200 + end);
            start += 200;
            end += 200;
        }
    }

    // Getters
    public int getTableID() {
        return this.tableID;
    }

    public int getPax() {
        return this.pax;
    }

    // Takes in an index to specify which reservation from the array you would like
    // to get
    public Reservation getReservation(int index) {
        return this.Reservations[index];
    }

    // Takes in the time and returns the index of the reservation
    public int getReservationIndex(int startTime) {
        int index = -1;
        if (startTime == 1000) {
            index = 0;
            return index;
        } else if (startTime == 1200) {
            index = 1;
            return index;
        } else if (startTime == 1400) {
            index = 2;
            return index;
        } else if (startTime == 1600) {
            index = 3;
            return index;
        } else if (startTime == 1800) {
            index = 4;
            return index;
        } else {
            return index;
        }
    }

    // Setters
    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }
}
