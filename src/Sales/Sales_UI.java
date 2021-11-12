package Sales;

import java.util.*;

import Menu.Menu_Control;
import Menu.PromotionPackage;
import Order.*;
public class Sales_UI {
    
    private static HashMap<Integer,Order> totalOrders = new HashMap<Integer,Order>();
    private static HashMap<Integer, Integer> individualOrder ;//= new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> individualPackage ;//= new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> totalItemQty = new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> totalPackageQty = new HashMap<Integer, Integer>();

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

            if (!individualOrder.isEmpty()){

                individualOrder.forEach((itemID,qty)->{
                    System.out.println("ItemID:" +itemID + "Qty :"+qty);
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
                    System.out.println("Package:" +packageID + "Qty :"+packageQty);
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

        printSales();

        System.out.println("Total sale: "+ totalSales);
        
    }
            

    public static void printSales(){
        System.out.println("--------------------Individual Sales Report---------------------");
        System.out.println("Item\t\t   |Qty\t\t |Total Price");
        totalItemQty.forEach((itemID,qty)->{
            if (qty!=0){
                System.out.println(
                    Menu_Control.getMenuItem(itemID+1).getName()
                    +"\t\t"+ qty + (Menu_Control.getMenuItem(itemID+1).getPrice()*qty)
                    
                );
            }
        });

//This does not work because the promotion package class contains the description and not the itemID
    System.out.println("--------------------Package Sales Report---------------------");
    System.out.println("Package\t\t   |qty\t\t |Price");
        totalPackageQty.forEach((packageID,qty)->{
            if (qty!=0){
                packageID+=1;
                System.out.println(
                    packageID
                    +"\t\t"+ qty +"\t\t" + (Menu_Control.getPromoPackageList().get(packageID).getPackagePrice())*qty
                );
            }
        });
        
    }


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
