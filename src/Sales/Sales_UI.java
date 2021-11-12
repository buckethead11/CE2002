package Sales;

import java.util.*;

import Menu.Menu_Control;
import Order.*;
public class Sales_UI {
    
    private static HashMap<Integer,Order> totalOrders = new HashMap<Integer,Order>();
    private static HashMap<Integer, Integer> individualOrder ;//= new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> individualPackage ;//= new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> totalQty ;
    public static void main(String[] args) {
        start();
    }
    private static double totalSales;
    private static int itemID;
    private static int itemQty;
    private static int oldQty; 

    public static void start(){

        totalOrders = Order_Control.getOrderList();
        totalOrders.forEach((key,order) ->{
            totalSales += order.getTotalPrice();
            individualOrder = order.getOrderedItems();
            individualPackage = order.getOrderedPackages();

            individualOrder.forEach((itemID,qty)->{
                oldQty = totalQty.getOrDefault(itemID,0);
                totalQty.put(itemID,oldQty +qty);
                
            });
            individualPackage.forEach((itemID,qty)->{
                oldQty = totalQty.getOrDefault(itemID,0);
                totalQty.put(itemID,oldQty +qty);
            });
        });

       // printSales();

        System.out.println("Total sale: "+ totalSales);
    }
            
    /*
    public static void printSales(){
        
        totalQty.forEach((itemID,qty)->{
                System.out.println(
                    "Item: " +Menu_Control.getMenuItem(itemID)
                    +" Qty: "+ qty
                );
            }
        );
    }
    */

    public static void displayUI(){

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--------------------Sales Report----------------------");
            System.out.println("(1) Sales report by day");
            System.out.println("(2) Sales report by week");
            System.out.println("(3) Sales report by month");
            System.out.println("(4) Return to main menu");
    
            int input= sc.nextInt();
    
            switch(input){
                case 1:
                    start();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while(true);
        

        


    }
    
}
