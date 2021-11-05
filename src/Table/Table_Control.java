package Table;

public class Table_Control {
    // create table layout with 10 tables
    private static Table[] table_layout = new Table[10];

    public Table_Control() {
        // Fill in the table object array
        for (int i = 0; i < 10; i++) {
            // Create new Table object and give it a table id and pax number
            table_layout[i] = new Table(i, 5);
        }
    }

    // Getter
    public static Table getTableLayout(int index) {
        return table_layout[index];
    }

    // Methods
    public static int checkTable(int startDateTime, int endDateTime, int pax) {
        int i = 0;
        // Iterates through the table layout
        for (i = 0; i < 10; i++) {
            // If table can fit the pax and is not occupied
            // how to refer to non static object in a static method
            if (table_layout[i].getPax() >= pax
                    && table_layout[i].getReservation(startDateTime).getOccupied() == false) {
                System.out.println("Table found!");
                return i;
            } else {
                System.out.println("There are no tables avaliable");
                return 0;
            }
        }
        // returns the table id to the reservation controller
        return table_layout[i].getTableID();
    }

    // assigns the reservation to the table
    public static void assignTable(int startDateTime, int endDateTime, int pax, String name, int contact, int tableID) {
        // Pushes the reservation to the table
        // Gets the index of the reservation array based on the timing
        int index = Table_Control.getTableLayout(tableID).getReservationIndex(startDateTime);
        // Sets the details of the reservation
        Table_Control.getTableLayout(tableID).getReservation(index).setName(name);
        // Sets occupied to true
        Table_Control.getTableLayout(tableID).getReservation(index).setOccupied(true);

    }
}
