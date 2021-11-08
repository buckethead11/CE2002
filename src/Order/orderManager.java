package Order;

import java.util.ArrayList;
import java.util.Scanner;
import Menu.*;


public class orderManager {

    public static void addItemToOrder(int orderID, int itemID,int quantity){

        int checkedOrderID = orderListManager.orderIDValidCheck(orderID); //sanity check
        int index = orderListManager.getOrderIDIndex (checkedOrderID);
        
        for( int i=0 ; i<quantity; i++){//if quantity exceeds one

        } 

    }

    public static void removeItemFromOrder(int orderID, int itemID,int quantity){

        int checkedOrderID = orderListManager.orderIDValidCheck(orderID); //sanity check
        int index = orderListManager.getOrderIDIndex (checkedOrderID);
        
        //Order orderToAdd= orderListManager.getAllOrders.get(index);;

        for( int i=0 ; i<quantity; i++){//if quantity exceeds one
            //orderToAdd.orderedItems.delete(new MenuItem())
        } 

    }

}
