package Order;

import java.util.InputMismatchException;
import java.util.Scanner;
import Menu.*;
import Table.Table_Control;
import Util.*;

public class Order_UI extends UI {
    private static Scanner sc = new Scanner(System.in);

    public void displayUI() {
        int choice;
        boolean run = true;
        do {
            System.out.println("\n===============ORDER================");
            System.out.println("(1) View a order");
            System.out.println("(2) View all open order");
            System.out.println("(3) Create a new order");
            System.out.println("(4) Add item(s) to Order");
            System.out.println("(5) Remove item(s) from Order");
            System.out.println("(6) Delete an Order");
            System.out.println("(7) Close a bill + Print Order Invoice");
            System.out.println("(8) Set and Change Tax Rate");
            System.out.println("(9) Return to main menu");
            System.out.println("====================================");
            System.out.print("What do you want to do? ");

            try {
                choice = sc.nextInt();
                if (!(choice >= 1 && choice <= 9)) {
                    System.out.println("Input must be an integer from 1-9!");
                }
                switch (choice) {
                case 1: // view an order
                    ViewOrderUI();
                    break;
                case 2: // view all current orders
                    viewAllCurrentOrdersUI();
                    break;
                case 3: // create a new Order
                    createNewOrderUI();
                case 4:// add an item into order
                    addItemUI();
                    break;

                case 5:// delete an item from order
                    deleteItemUI();

                    break;

                case 6: // Delete an order

                    deleteOrderUI();
                    break;
                case 7:
                    tableCheckoutUI();
                    break;
                case 8:
                    editRatesUI();
                    break;
                case 9:
                    run = false;
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer!");
                sc.nextLine();
                continue;
            }

        } while (run);
    }

    public static void ViewOrderUI() {
        System.out.println("Please enter the tableID to view order");
        int tableID = sc.nextInt();
        if (Order_Control.checkValidOrder(tableID))
            Order_Control.printOrderedItems(tableID);
    }

    public static void viewAllCurrentOrdersUI() {
        Order_Control.printAllCurrentOrders();
    }

    public static void createNewOrderUI() {
        System.out.println("Enter Table ID");
        int tableID = sc.nextInt();
        System.out.println("Enter your Staff ID");
        int staffID = sc.nextInt();
        Order_Control.makeOrder(tableID, staffID);

    }

    public static void deleteOrderUI() {
        System.out.println("Which tableID order do you want to delete?");
        int tableID = sc.nextInt();
        Order_Control.removeOrder(tableID);
    }

    public static void addItemUI() {
        System.out.println("Pleaes key in the tableID you want to add order");
        int tableID = sc.nextInt();
        if (Order_Control.checkValidOrder(tableID)) {
            System.out.println("(1) Add ala carte item");
            System.out.println("(2) Add promo package item");
            int choice = sc.nextInt();
            if (choice == 1)
                addMenuItemUI(tableID);
            if (choice == 2)
                addPackageUI(tableID);
        }

    }

    public static void deleteItemUI() {
        System.out.println("Please key in the tableID you want to remove order");
        // try {
        int tableID = sc.nextInt();
        if (Order_Control.checkValidOrder(tableID)) {
            System.out.println("(1) Remove ala carte item");
            System.out.println("(2) Remove promo package item");
            int choice = sc.nextInt();
            if (choice == 1)
                deleteMenuItemUI(tableID);
            if (choice == 2)
                deletePackageItemUI(tableID);
        }

        // } catch (Exception e) {
        // System.out.println("Error: Please enter a valid value");
        // }
    }

    public static void tableCheckoutUI() {
        System.out.println("Enter TableID to checkout");
        int tableID = sc.nextInt();
        if (Order_Control.checkValidOrder(tableID)) {
            System.out.println("Member? (TRUE/FALSE)");
            boolean member = sc.nextBoolean();
            Order_Control.printOrderInvoice(tableID, member);
            Order_Control.removeOrder(tableID);
            Table_Control.getTableLayout().get(tableID).setOccupied(false);

        }

    }

    public static void editRatesUI() {
        System.out.println("Enter new discount rate percentage");
        double discountRate = sc.nextDouble();
        System.out.println("Enter new government tax rate percentage");
        double governmentTaxRate = sc.nextDouble();
        OrderInvoice.setGSTRate(governmentTaxRate);
        OrderInvoice.setDiscountRate(discountRate);
        System.out.println("Updated Membership discount rate: " + discountRate + " Updated government tax rate: "
                + governmentTaxRate);
    }

    public static void addMenuItemUI(int tableID) {
        Menu_Control.showMenu();
        System.out.println("Please enter itemID to be added with above list for reference");
        int itemID = sc.nextInt();
        System.out.println("Please enter Quantity");
        int quanitity = sc.nextInt();

        Order_Control.addItemToOrder(tableID, itemID - 1, quanitity);

    }

    public static void addPackageUI(int tableID) {
        Menu_Control.showPromotionPackage();
        System.out.println("Please enter packageID to be added with above list for reference");
        int itemID = sc.nextInt();
        System.out.println("Please enter Quantity");
        int quanitity = sc.nextInt();

        Order_Control.addPackageToOrder(tableID, itemID - 1, quanitity);
    }

    public static void deleteMenuItemUI(int tableID) {
        Order_Control.printOrderedItems(tableID);
        System.out.println("Please enter ala carte itemID to be deleted ");
        int itemID = sc.nextInt();
        System.out.println("Please enter Quantity");
        int quantity = sc.nextInt();
        Order_Control.removeItemFromOrder(tableID, itemID - 1, quantity);
    }

    public static void deletePackageItemUI(int tableID) {
        Order_Control.printOrderedItems(tableID);
        System.out.println("Please enter package itemID to be deleted ");
        int itemID = sc.nextInt();
        System.out.println("Please enter Quantity");
        int quantity = sc.nextInt();
        Order_Control.removePackageFromOrder(tableID, itemID - 1, quantity);

    }

}
