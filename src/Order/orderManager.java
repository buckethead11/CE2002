package Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Menu.*;

public class orderManager {
    private static HashMap<Integer, Order> orderList = new HashMap<Integer, Order>();

    public static void displayUI() {
        Order_UI.display();
    }

    public static void makeOrder(int tableID, boolean membershipStatus, int staffID) {
        HashMap<Integer, Integer> orderedItems = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> orderedPackages = new HashMap<Integer, Integer>();
        Order newOrder = new Order(tableID, membershipStatus, staffID, orderedItems, orderedPackages);
        orderList.put(tableID, newOrder);
    }

    public static void removeOrder(int tableID) {
        orderList.remove(tableID);
    }

    public static void addItemToOrder(int tableID, int itemID, int quantity) {
        orderList.get(tableID).addItems(itemID, quantity);
        // int checkedOrderID = orderListManager.orderIDValidCheck(orderID); // sanity
        // check
        // // int index = orderListManager.getOrderIDIndex (checkedOrderID);

        // Order orderToAdd = orderListManager.getSingleOrder(orderID);
        // ArrayList<MenuItem> singleOrder = orderToAdd.getOrderedItems();
        // for (int i = 0; i < quantity; i++) {// if quantity exceeds one
        // String itemName = Menu_Control.getMenuItem(itemID).getName();
        // singleOrder.add(Menu_Control.getMenuItem(itemID));
        // System.out.println("Item: " + itemName + " Added to " + orderID);
        // }

    }

    public static void addPackageToOrder(int tableID, int packageID, int quantity) {
        orderList.get(tableID).addPackages(packageID, quantity);
    }

    public static void removeItemFromOrder(int tableID, int itemID, int quantity) {
        orderList.get(tableID).removeItems(itemID, quantity);
    }

    public static void removePackageFromOrder(int tableID, int packageID, int quantity) {
        orderList.get(tableID).removePackages(packageID, quantity);
    }

    public static void printOrderedItems(int tableID) {
        HashMap<Integer, Integer> orderItemsToBePrinted = orderList.get(tableID).getOrderedItems();
        HashMap<Integer, Integer> orderPackagesToBePrinted = orderList.get(tableID).getOrderedPackages();
        System.out.println("\n=========== Current Order For Table " + tableID + " ==================");
        System.out.format("+----------------------Ala Carte----------------------------+%n");
        System.out.format("+-----+-----------------------------------------------+-----+%n");
        System.out.format("| ID  |                Item Name                      | Qty |%n");
        System.out.format("+-----+-----------------------------------------------+-----+%n");
        String orderFormat = "| %-3d | %-45s | %3d |%n";
        orderItemsToBePrinted.forEach(
                (key, value) -> System.out.printf(orderFormat, Menu_Control.getMenuArrayList().get(key).getItemId() + 1,
                        Menu_Control.getMenuArrayList().get(key).getName(), value));
        System.out.format("+----------------------Packages-----------------------------+%n");
        System.out.format("+-----+-----------------------------------------------+-----+%n");
        System.out.format("| ID  |                Item Name                      | Qty |%n");
        System.out.format("+-----+-----------------------------------------------+-----+%n");
        orderPackagesToBePrinted.forEach((key, value) -> System.out.printf(orderFormat,
                Menu_Control.getPromoPackageList().get(key).getPackageId() + 1,
                Menu_Control.getPromoPackageList().get(key).getDesc(), value));
    }

    // int orderID = orderListManager.orderIDValidCheck(orderIDParam); // sanity
    // check

    // Order order = orderListManager.getSingleOrder(orderID); // creating an order
    // single order object

    // ArrayList<MenuItem> orderedItems = order.getOrderedItems(); // creating an
    // arraylist object with name
    // // orderedItems
    // System.out.println("Items in " + orderID + " :");
    // for (MenuItem item : orderedItems) {
    // System.out.println(item.getName()); // printing the names of the items
    // }
    // }

    public static boolean checkValidOrder(int tableID) {
        if (orderList.containsKey(tableID))
            return true;
        else {
            System.out.println("No order for Table " + tableID + ". Please create an order first!");
            return false;
        }
    }
}
