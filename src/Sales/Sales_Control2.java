package Sales;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.Calendar;

import Table.*;
import Order.*;
import Reservation.Reservation;



public class Sales_Control2 {

    private static Hashtable< Integer, OrderInvoice> paidOrderList;
    //for the CSV file
    private static String userHome = System.getProperty("user.dir");
	public static String pathSeparator = File.separator; 
	private static String pathToCsv = userHome+ pathSeparator + "data"+ pathSeparator + "paidOrderList.csv";


    public static void init(){
        paidOrderList = new Hashtable< Integer, OrderInvoice>();
        OrderInvoice orderInvoice;

        Calendar date = Calendar.getInstance();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy");
        // Loads table layout
        try {
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        csvReader.readLine(); // this will read the first line
        String line1=null;//skips first line
        String row ="";

        while ((row = csvReader.readLine()) != null) {
            //reads each line and split it by comma into an array
            String[] line = row.split(",");
            
            String datestr = line[0];
            date.setTime(dateFormatter.parse(datestr));
            int invoiceNumber = Integer.parseInt(line[1]);
            String itemListString = line[2];
            String itemListQtyString = line[4];
            String packageListString = line[3];
            String packageListQtyString = line[5];
            float finalPrice = Float.parseFloat(line[6]);
            String memberShipStatus = line[7];


            reservation = new Reservation(date,pax,name,contact,tableID);
            //Sets the tables with occupied to have a status that is true
            Table_Control.getTableLayout().get(tableID-1).setOccupied(true);
            reservationList.add(reservation);
        }

        System.out.println("Reservations loaded");
        csvReader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void convertItemListString( Hashtable< Integer, OrderInvoice> paidOrderedList, String itemListString, String itemListQtyString){
        for (int i=0; i<itemListString.length(); i++){
            int itemID = itemListString.charAt(i);
            int itemQty =itemListQtyString.charAt(i);
            MenuItem menuItemToBeAdded = 
 

        }
    }
    
}
