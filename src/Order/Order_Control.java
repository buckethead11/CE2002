package Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Menu.*;

public class Order_Control {

    private static HashMap<Integer, Order> orderList = new HashMap<Integer, Order>();
    // this is for invoice
    private static HashMap<Integer, OrderInvoice> paidOrderList = new HashMap<Integer, OrderInvoice>();

    private static int tableOrderID;

    // create a new blank order
    public static void makeOrder(int tableID, int staffID) {
        HashMap<Integer, Integer> orderedItems = new HashMap<Integer, Integer>();// empty orderItem hashmap
        HashMap<Integer, Integer> orderedPackages = new HashMap<Integer, Integer>();// empty packageItems hashmap
        // initial price 0.00
        Order newOrder = new Order(tableID, staffID, orderedItems, orderedPackages, 0.00);
        orderList.put(tableID, newOrder);
    }

    // delete tableID from orderList map
    public static void removeOrder(int tableID) {
        orderList.remove(tableID);
    }

    public static void addItemToOrder(int tableID, int itemID, int quantity) {

        orderList.get(tableID).addItems(itemID, quantity);

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
        System.out.println("\n===================  Order For Table " + tableID + " ======================");
        String orderFormat = "| %-3d | %-45s | %3d |%n";
        if (!orderItemsToBePrinted.isEmpty()) {// only print ala carte header when there is existing order
            System.out.format("+----------------------Ala Carte----------------------------+%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            System.out.format("| ID  |                Item Name                      | Qty |%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            // iterate through item hashmap, print ID, get name from ID and print
            // quantity
            orderItemsToBePrinted.forEach(
                    (key, value) -> System.out.printf(orderFormat, Menu_Control.getMenuArrayList().get(key).getID() + 1,
                            Menu_Control.getMenuArrayList().get(key).getName(), value));
        }
        if (!orderPackagesToBePrinted.isEmpty()) {// only print package header when there is existing order
            System.out.format("+----------------------Packages-----------------------------+%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            System.out.format("| ID  |         Package Description                   | Qty |%n");
            System.out.format("+-----+-----------------------------------------------+-----+%n");
            // iterate through package hashmap, print ID, get name from ID and print
            // quantity
            orderPackagesToBePrinted.forEach((key, value) -> System.out.printf(orderFormat,
                    Menu_Control.getPromoPackageList().get(key).getID() + 1,
                    Menu_Control.getPromoPackageList().get(key).getDesc(), value));
        }
        System.out.println("\n=============== Current Bill For Table " + tableID + " ====================");
        System.out.println("Subtotal (Before Discount and Tax): $" + orderList.get(tableID).getTotalPrice());

    }

    public static boolean checkValidOrder(int tableID) {
        if (orderList.containsKey(tableID))
            return true;
        else {
            System.out.println("No order for Table " + tableID + ". Please create an order first!");
            return false;
        }
    }

    public static void printOrderInvoice(int tableID, boolean member) {
        Order order = orderList.get(tableID);
        OrderInvoice orderInvoice = new OrderInvoice(order, member);
        orderInvoice.printInvoice();
    }

    public static HashMap<Integer, Order> getOrderList() {
        return orderList;
    }

    public static final HashMap<Integer, OrderInvoice> getPaidOrderList() {
        return paidOrderList;
    }

    public static void orderPaid(OrderInvoice orderInvoice) {
        int size = paidOrderList.size();
        paidOrderList.put(size, orderInvoice);
    }

    public static void printAllCurrentOrders() {
        System.out.println("Current Open Order: ");
        orderList.forEach((key, value) -> System.out.printf(key + ", "));
    }

}
