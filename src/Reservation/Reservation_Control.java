package Reservation;

import Table.*;

public class Reservation_Control {
    // Methods
    // Called when creating Reservation
    public static void createReservation(int startDateTime, int endDateTime, int pax, String name, int contact) {
        // Check if table is avaliable, assigns a table id to a variable. If theres no
        // table ID should be 0
        int tableID = Table_Control.checkTable(startDateTime, endDateTime, pax);
        // Pass this reservation object to the table array. Include table IDs
        Table_Control.assignTable(startDateTime, endDateTime, pax, name, contact, tableID);
    }

    // Called when deleting Reservations
    public static void deleteReservation(String name) {

    }

    // Called when viewing reservation
    public static void viewReservation(String name, int contact) {
        // Iterates through the tables
        for (int i = 0; i < 10; i++) {
            // Iterates through the reservations in the table
            for (int j = 0; i < 5; j++) {
                // Check if name and contact matches the table
                if (name == Table_Control.getTableLayout(i).getReservation(j).getName()
                        & contact == Table_Control.getTableLayout(i).getReservation(j).getContact()) {
                    // Return reservation if matches
                }
            }
        }
    }
}