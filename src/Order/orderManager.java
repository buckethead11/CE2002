package Order;

import java.util.ArrayList;
import java.util.Scanner;
import Menu.*;


public class orderManager {

    public static void addItemToOrder(int orderID, int itemID,int quantity){

        int checkedOrderID = orderListManager.orderIDValidCheck(orderID); //sanity check
        // int index = orderListManager.getOrderIDIndex (checkedOrderID);

        Order orderToAdd= orderListManager.getSingleOrder(orderID);
        ArrayList<MenuItem> singleOrder = orderToAdd.getOrderedItems();
        for( int i=0 ; i<quantity; i++){//if quantity exceeds one
            String itemName = Menu_Control.getMenuItem(itemID).getName();
            singleOrder.add(Menu_Control.getMenuItem(itemID));
            System.out.println("Item: "+ itemName+ " Added to "+ orderID);
        } 

    }

    public static void printOrderedItems( int orderIDParam){

        int orderID = orderListManager.orderIDValidCheck(orderIDParam); //sanity check

        Order order = orderListManager.getSingleOrder(orderID); //creating an order single order object
        
        ArrayList<MenuItem> orderedItems = order.getOrderedItems(); // creating an arraylist object with name orderedItems
        System.out.println("Items in "+orderID+" :");
        for (MenuItem item : orderedItems) {  
            System.out.println(item.getName());  //printing the names of the items 
        } 
    }

    public static void removeItemFromOrder(int orderID, int itemID,int quantity){

        int checkedOrderID = orderListManager.orderIDValidCheck(orderID); //sanity check
        //int index = orderListManager.getOrderIDIndex (checkedOrderID);

        Order orderToAdd= orderListManager.getSingleOrder(orderID);
        ArrayList<MenuItem> singleOrder = orderToAdd.getOrderedItems();
        for( int i=0 ; i<quantity; i++){//if quantity exceeds one

        } 
    }

}
