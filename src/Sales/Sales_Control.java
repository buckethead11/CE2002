package Sales;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import Order.*;
import Menu.*;

public class Sales_Control{

    private static HashMap<Integer, Integer> individualOrder = new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> individualPackage = new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> totalItemQty = new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> totalPackageQty = new HashMap<Integer, Integer>();


    private static double totalSales=0;
    private static int oldQty=0;



    public static void generateReportData( HashMap<Integer,OrderInvoice> orderListToSort){
        HashMap<Integer,OrderInvoice> totalOrders = new HashMap<Integer,OrderInvoice>();
        oldQty= 0;
        totalSales=0;
        totalOrders.clear();
        individualOrder.clear();
        individualPackage.clear();
        totalItemQty.clear();
        totalPackageQty.clear();
        totalOrders = orderListToSort;
        totalOrders.forEach((key,orderInvoice) ->{
            totalSales += orderInvoice.getTotalPrice();
            individualOrder = orderInvoice.getOrder().getOrderedItems();
            individualPackage = orderInvoice.getOrder().getOrderedPackages();

            if (!individualOrder.isEmpty()){

                individualOrder.forEach((itemID,qty)->{

                    oldQty = totalItemQty.getOrDefault(itemID,0);
    
                    if (oldQty == 0){ //not in the list
                        totalItemQty.put(itemID, qty);
                    }
                    else{
                        totalItemQty.replace(itemID, oldQty+qty);
                    }
                });
            }

            
            if(!individualPackage.isEmpty()){
                individualPackage.forEach((packageID,packageQty)->{

                    oldQty = totalPackageQty.getOrDefault(packageID,0);
    
                    if (oldQty == 0){ //not in the list
                        totalPackageQty.put(packageID, packageQty);
                    }
                    else{
                        totalPackageQty.replace(packageID, oldQty+packageQty);
                    }
                });
            }
               
    });

        printSales(totalSales);
    }
            

    public static void printSales(double totalFinalSales){
        System.out.println("--------------------Individual Sales Report---------------------");
        System.out.println("Item\t\t   |Qty\t\t ");
        totalItemQty.forEach((itemID,qty)->{
            if (qty!=0){
                System.out.println(
                    Menu_Control.getMenuItem(itemID+1).getName()
                    +"\t\t"+ qty //+ "\t\t"+(Menu_Control.getMenuItem(itemID+1).getPrice()*qty)
                    
                );
            }
        });


        System.out.println("--------------------Package Sales Report---------------------");
        System.out.println("Package\t\t   |qty\t\t |Price");
            totalPackageQty.forEach((packageID,qty)->{
                if (qty!=0){
                    packageID+=1;
                    System.out.println(
                        packageID
                        +"\t\t"+ qty +"\t\t\t" //+ (Menu_Control.getPromoPackageList().get(packageID).getPackagePrice())*qty
                    );
                }
            });

        System.out.println("\nTotal sale: "+ totalSales);    
    }
    public static Calendar getCurrentTime(){
        Calendar c= Calendar.getInstance();
        return c;
    }
/*
    public static HashMap<Integer,OrderInvoice> getTodaySalesReport(){
        HashMap<Integer,OrderInvoice> dailySaleReport = new HashMap<Integer,OrderInvoice>();
        totalOrders = Order_Control.getPaidOrderList();
        Calendar c = getCurrentTime();
        int currentDay= c.DAY_OF_MONTH;
        int currentMonth = c.MONTH;

        totalOrders.forEach((key,order)->{
            OrderInvoice orderInvoice =order; 
            int orderInvoiceDay = orderInvoice.getDateGenerated().DAY_OF_MONTH;
            int orderInvoiceMonth = orderInvoice.getDateGenerated().MONTH;
            if (currentDay == orderInvoiceDay || orderInvoiceMonth == currentMonth){ //if the day and month matches
                dailySaleReport.put(dailySaleReport.size(),order); //append that order the list
            }
        });
        return dailySaleReport;
    }
*/
    //same method as above but can specify what day and month
    public static HashMap<Integer,OrderInvoice> getDailySalesReport(int day, int month){

        HashMap<Integer,OrderInvoice> totalOrders = new HashMap<Integer,OrderInvoice>();
        HashMap<Integer,OrderInvoice> dailySaleReport = new HashMap<Integer,OrderInvoice>();

        totalOrders = Order_Control.getPaidOrderList();

        totalOrders.forEach((key,order)->{
            OrderInvoice orderInvoice =order; 
            int orderInvoiceDay = orderInvoice.getDateGenerated().DAY_OF_MONTH;
            int orderInvoiceMonth = orderInvoice.getDateGenerated().MONTH;
            if (day == orderInvoiceDay && orderInvoiceMonth == month){ //if the day and month matches
                //System.out.println("The input is valid");
                dailySaleReport.put(dailySaleReport.size(),order); //append that order the list
            }
   

        });
        return dailySaleReport;
    }

    public static HashMap<Integer,OrderInvoice> getWeeklySalesreport(int week){
        HashMap<Integer,OrderInvoice> totalOrders = new HashMap<Integer,OrderInvoice>();
        HashMap<Integer,OrderInvoice> weeklySalesReport = new HashMap<Integer,OrderInvoice>();

        totalOrders = Order_Control.getPaidOrderList();
        Calendar c = getCurrentTime();
        //int currentMonth = c.MONTH;
        totalOrders.forEach((key,order)->{
            OrderInvoice orderInvoice =order; 
            int orderInvoiceWeek = orderInvoice.getDateGenerated().WEEK_OF_YEAR;

            //int orderInvoiceMonth = orderInvoice.getDateGenerated().MONTH;
            if (week == orderInvoiceWeek){ //if the day and month matches
                weeklySalesReport.put(weeklySalesReport.size(),order); //append that order the list
            }
        });
        return weeklySalesReport;
    }

    
    public static HashMap<Integer,OrderInvoice> getMonthlySalesReport(int month){
        HashMap<Integer,OrderInvoice> totalOrders = new HashMap<Integer,OrderInvoice>();
        HashMap<Integer,OrderInvoice> monthlySalesReport = new HashMap<Integer,OrderInvoice>();

        totalOrders = Order_Control.getPaidOrderList();

        totalOrders.forEach((key,order)->{
            OrderInvoice orderInvoice =order; 
            int orderInvoiceMonth = orderInvoice.getDateGenerated().MONTH;
            //int orderInvoiceMonth = orderInvoice.getDateGenerated().MONTH;
            if (month == orderInvoiceMonth){ //if the day and month matches
                monthlySalesReport.put(monthlySalesReport.size(),order); //append that order the list
            }
        });
        return monthlySalesReport;
    }
}