package Sales;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import Order.*;
import Menu.*;

public class Sales_Control {

    public static void printDailyReport(String date) {
        try {
            double totalRevenue = 0;
            int quantity[] = new int[10];
            File revenueFile = new File("data", "sales.txt");
            Scanner myReader = new Scanner(revenueFile);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arrLinedata = data.split(",", 15);
                if (date.equals(arrLinedata[0])) {
                    totalRevenue += Double.parseDouble(arrLinedata[1]);
                    for (int i = 0; i < 10; i++) {
                        quantity[i] += Integer.parseInt(arrLinedata[i + 2]);
                    }
                }
            }
            myReader.close();
            System.out.format("*************************************************************%n");
            System.out.format("  OODP RESTAURANT SALES REVENUE REPORT FOR THE DAY " + date + "%n");
            System.out.format("*************************************************************%n");
            String orderFormat = "| %-3d | %-45s | %3d |%n";
            System.out.format("+==========Total Quantity Sold for Ala Carte Items==========+%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            System.out.format("| ID  |                Item Name                      | Qty |%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            for (int i = 0; i < 7; i++) {
                System.out.printf(orderFormat, Menu_Control.getMenuArrayList().get(i).getID() + 1,
                        Menu_Control.getMenuArrayList().get(i).getName(), quantity[i]);
            }
            System.out.format("+========Total Quantity Sold for Promo Package Items========+%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            System.out.format("| ID  |               Description                     | Qty |%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            for (int i = 0; i < 3; i++) {
                System.out.printf(orderFormat, Menu_Control.getPromoPackageList().get(i).getID() + 1,
                        Menu_Control.getPromoPackageList().get(i).getDesc(), quantity[i]);
            }
            String amountFormat = "|%-46s   %10.2f|%n";
            System.out.format("=============================================================%n");
            System.out.printf(amountFormat, "TOTAL REVENUE GENERATED TODAY IS:", totalRevenue);
            System.out.println("");
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Menu not updated");
            e.printStackTrace();
        }
    }

    public static void printMonthlyReport(String date) {
        try {
            double totalRevenue = 0;
            int quantity[] = new int[10];
            File revenueFile = new File("data", "sales.txt");
            Scanner myReader = new Scanner(revenueFile);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arrLinedata = data.split(",", 15);
                if (arrLinedata[0].indexOf("date") != 0) {
                    totalRevenue += Double.parseDouble(arrLinedata[1]);
                    for (int i = 0; i < 10; i++) {
                        quantity[i] += Integer.parseInt(arrLinedata[i + 2]);
                    }
                }
            }
            myReader.close();
            System.out.format("*************************************************************%n");
            System.out.format("  OODP RESTAURANT SALES REVENUE REPORT FOR THE MONTH " + date + "%n");
            System.out.format("*************************************************************%n");
            String orderFormat = "| %-3d | %-45s | %3d |%n";
            System.out.format("+==========Total Quantity Sold for Ala Carte Items==========+%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            System.out.format("| ID  |                Item Name                      | Qty |%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            for (int i = 0; i < 7; i++) {
                System.out.printf(orderFormat, Menu_Control.getMenuArrayList().get(i).getID() + 1,
                        Menu_Control.getMenuArrayList().get(i).getName(), quantity[i]);
            }
            System.out.format("+========Total Quantity Sold for Promo Package Items========+%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            System.out.format("| ID  |               Description                     | Qty |%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            for (int i = 0; i < 3; i++) {
                System.out.printf(orderFormat, Menu_Control.getPromoPackageList().get(i).getID() + 1,
                        Menu_Control.getPromoPackageList().get(i).getDesc(), quantity[i]);
            }
            String amountFormat = "|%-46s   %10.2f|%n";
            System.out.format("=============================================================%n");
            System.out.printf(amountFormat, "TOTAL REVENUE GENERATED IN THE MONTH IS:", totalRevenue);
            System.out.println("");
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Menu not updated");
            e.printStackTrace();
        }

    }

}