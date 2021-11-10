package Order;

import java.util.Scanner;
import Menu.*;

public class Order_UI {
    private static Scanner sc = new Scanner(System.in);

    public static void display() {
        int input;
        do {
            System.out.println("(1) View a order");
            System.out.println("(2) Create a new order");
            System.out.println("(3) Add item(s) to Order");
            System.out.println("(4) Remove item(s) from Order");
            System.out.println("(5) Delete an Order");
            System.out.println("(6) Close a bill + Print Order Invoice");
            System.out.println("(7) Set and Change Tax Rate\n");

            input = sc.nextInt();

            switch (input) {
            case 1: // view an order
                ViewOrder();
                break;
            // } catch (Exception e) {
            // System.out.println("Error: Please enter a valid input");
            // }

            case 2: // create a new Order
                // try {
                createNewOrder();
                // } catch (Exception e) {
                // System.out.println("Please enter an integer for Order Number or Staff ID");
                // }
                break;

            case 3:// add an item into order
                addItem();
                break;

            case 4:// delete an item from order
                deleteItem();

                break;

            case 5: // Delete an order
                // System.out.println("Printing out all the orders");
                // orderManager.getAllOrders();
                deleteOrder();
                break;
            case 6:
                System.out.println("Enter TableID to checkout");
                int tableID = sc.nextInt();
                System.out.println("Are you a member?");
                boolean member = sc.nextBoolean();
                orderManager.printOrderInvoice(tableID, member);
                break;
            case 7:
                System.out.println("Enter new discount rate percentage");
                double discountRate = sc.nextDouble();
                System.out.println("Enter new government tax rate percentage");
                double governmentTaxRate = sc.nextDouble();
                OrderInvoice.setGSTRate(governmentTaxRate);
                OrderInvoice.setDiscountRate(discountRate);
                System.out.println("Updated Membership discount rate: " + discountRate
                        + " Updated government tax rate: " + governmentTaxRate);
                break;

            }
        } while (true);
    }

    public static void ViewOrder() {
        System.out.println("Please enter the tableID to view order");
        int tableID = sc.nextInt();
        if (orderManager.checkValidOrder(tableID))
            orderManager.printOrderedItems(tableID);
    }

    public static void createNewOrder() {
        System.out.println("Enter Table ID");
        int tableID = sc.nextInt();
        System.out.println("Enter Staff ID");
        int staffID = sc.nextInt();
        orderManager.makeOrder(tableID, staffID);

    }

    public static void deleteOrder() {
        System.out.println("Which tableID order do you want to delete?");
        int tableID = sc.nextInt();
        orderManager.removeOrder(tableID);
    }

    public static void addItem() {
        System.out.println("Pleaes key in the tableID you want to add order");
        int tableID = sc.nextInt();
        System.out.println("(1) Add ala carte item");
        System.out.println("(2) Add promo package item");
        int choice = sc.nextInt();
        if (choice == 1)
            addMenuItem(tableID);
        if (choice == 2)
            addPackage(tableID);
    }

    public static void deleteItem() {
        System.out.println("Please key in the tableID you want to remove order");
        // try {
        int tableID = sc.nextInt();
        System.out.println("(1) Remove ala carte item");
        System.out.println("(2) Remove promo package item");
        int choice = sc.nextInt();
        if (choice == 1)
            deleteMenuItem(tableID);
        if (choice == 2)
            deletePackageItem(tableID);
        // } catch (Exception e) {
        // System.out.println("Error: Please enter a valid value");
        // }
    }

    public static void addMenuItem(int tableID) {
        Menu_Control.showMenu();
        System.out.println("Please enter itemID to be added with above list for reference");
        int itemID = sc.nextInt();
        System.out.println("Please enter Quantity");
        int quanitity = sc.nextInt();
        orderManager.addItemToOrder(tableID, itemID - 1, quanitity);
    }

    public static void addPackage(int tableID) {
        Menu_Control.showPromotionPackage();
        System.out.println("Please enter packageID to be added with above list for reference");
        int itemID = sc.nextInt();
        System.out.println("Please enter Quantity");
        int quanitity = sc.nextInt();
        orderManager.addPackageToOrder(tableID, itemID - 1, quanitity);
    }

    public static void deleteMenuItem(int tableID) {
        orderManager.printOrderedItems(tableID);
        System.out.println("Please enter ala carte itemID to be deleted ");
        int itemID = sc.nextInt();
        System.out.println("Please enter Quantity");
        int quantity = sc.nextInt();
        orderManager.removeItemFromOrder(tableID, itemID - 1, quantity);
    }

    public static void deletePackageItem(int tableID) {
        orderManager.printOrderedItems(tableID);
        System.out.println("Please enter package itemID to be deleted ");
        int itemID = sc.nextInt();
        System.out.println("Please enter Quantity");
        int quantity = sc.nextInt();
        orderManager.removePackageFromOrder(tableID, itemID - 1, quantity);

    }

}
