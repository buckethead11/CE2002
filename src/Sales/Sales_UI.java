package Sales;

import java.util.*;
import java.util.Calendar;
import Util.*;

public class Sales_UI extends UI {
    private static Scanner sc = new Scanner(System.in);
    private static Calendar c = Calendar.getInstance();

    public void displayUI() {

        do {
            System.out.println("--------------------Sales Report----------------------");
            System.out.println("(1) Sales report by day");
            System.out.println("(2) Sales report by month");
            System.out.println("(3) Return to main menu");

            int input = sc.nextInt();
            switch (input) {
            case 1: // daily
                dailyReport_UI();
                break;
            case 2:// month
                monthlyReport_UI();
                break;
            case 3:
                return;
            }
        } while (true);
    }

    public static void dailyReport_UI() {
        System.out.println("[Daily sales report]: Enter the day in the format dd-mm-yy");
        String date = sc.next();
        Sales_Control.printDailyReport(date);
    }

    public static void monthlyReport_UI() {
        System.out.println("[Monthly sales report]: Enter the month in the format mm-yy");
        String date = sc.next();
        Sales_Control.printMonthlyReport(date);
    }
}
