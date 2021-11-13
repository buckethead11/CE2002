package Sales;

import java.util.*;
import java.util.Calendar;
import Menu.Menu_Control;
import Menu.PromotionPackage;
import Order.*;
public class Sales_UI {
    private static Scanner sc = new Scanner(System.in);
    private static Calendar c = Calendar.getInstance();


    public static void displayUI(){


        do {
            System.out.println("--------------------Sales Report----------------------");
            System.out.println("(1) Today's Sales Report");
            System.out.println("(2) Sales report by day");
            System.out.println("(3) Sales report by week");
            System.out.println("(4) Sales report by month");
            System.out.println("(5) Return to main menu");
    
            int input= sc.nextInt();

            System.out.println("Current Date and Time:" + c.getTime()+ " Week: "+ c.getWeekYear());
            switch(input){
                case 1: //today's sales report
                    dailyInstance_UI();
                    break;
                case 2:// daily
                    daily_UI();
                    break;
                case 3: //weekly
                    weekly_UI();
                    break;
                case 4:
                    month_UI();
                    break;
                case 5:
                    return;
            }
        } while(true);
    }

    public static void dailyInstance_UI(){
        c = Calendar.getInstance();
        int currentDay= c.DAY_OF_MONTH;
        int currentMonth = c.MONTH;
        Sales_Control.generateReportData(Sales_Control.getDailySalesReport(currentDay, currentMonth));
    }

    public static void daily_UI(){
        System.out.println("[Daily sales report]: Enter the day (dd)");
        int inputDay= sc.nextInt();
        System.out.println("[Daily sales report]: Enter the Month (mm)");
        int inputMonth= sc.nextInt();
        Sales_Control.generateReportData(Sales_Control.getDailySalesReport(inputDay, inputMonth));
    }
    
    public static void weekly_UI(){
        System.out.println("[Weekly sales report]: Enter the Week (ww)");
        int inputWeek = sc.nextInt();
        Sales_Control.generateReportData(Sales_Control.getWeeklySalesreport(inputWeek));
    }

    public static void month_UI(){
        System.out.println("[Monthly sales report]: Enter the Month (mm)");
        int inputMonth1 = sc.nextInt();
        Sales_Control.generateReportData(Sales_Control.getMonthlySalesReport(inputMonth1));
    }
}
