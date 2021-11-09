package Order;

import java.util.Scanner;
import Menu.*;

public class Order_UI {

    public static void main(String[] args) {
        Menu_Control.loadMenuItem();
        showOrderUI();
    }

    public static void showOrderUI() {
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("(1) View a order");
            System.out.println("(2) Create a new order");
            System.out.println("(3) Add an item to Order");
            System.out.println("(4) Delete an item from Order");
            System.out.println("(5) Delete an Order");
            System.out.println("(6) Set and Change Tax Rate");

            input = sc.nextInt();

            switch (input) {
            case 1: // view an order
                System.out.println("Please enter the tableID to view order");
                // try {
                input = sc.nextInt();
                orderManager.printOrderedItems(input);
                break;

            // } catch (Exception e) {
            // System.out.println("Error: Please enter a valid input");
            // }

            case 2: // create a new Order
                // try {
                System.out.println("Enter Table ID");
                int tableID = sc.nextInt();
                System.out.println("Enter Staff ID");
                int staffID = sc.nextInt();
                System.out.println("Membership (1/0)");
                boolean membership = sc.nextBoolean();
                orderManager.makeOrder(tableID, membership, staffID);
                // } catch (Exception e) {
                // System.out.println("Please enter an integer for Order Number or Staff ID");
                // }
                break;

            case 3:// add an item into order
                System.out.println("Pleaes key in the tableID you want to add order");
                int tableID2 = sc.nextInt();
                System.out.println("Please enter itemID to be added");
                int itemID = sc.nextInt();
                System.out.println("Please enter Quantity");
                int quanitity = sc.nextInt();
                orderManager.addItemToOrder(tableID2, itemID, quanitity);
                /*
                 * try{
                 * 
                 * 
                 * } catch (Exception e){
                 * System.out.println("Error: Please enter a valid value"); }
                 */
                break;

            case 4:// delete an item from other
                System.out.println("Please key in the tableID you want to remove order");
                // try {
                int tableID3 = sc.nextInt();
                System.out.println("Please enter itemID to be deleted ");
                int itemID2 = sc.nextInt();
                System.out.println("Please enter Quantity");
                int quantity = sc.nextInt();
                orderManager.removeItemFromOrder(tableID3, itemID2, quantity);

                // } catch (Exception e) {
                // System.out.println("Error: Please enter a valid value");
                // }
                break;

            case 5: // Delete an order
                // System.out.println("Printing out all the orders");
                // orderManager.getAllOrders();
                System.out.println("Which tableID order do you want to delete?");
                tableID = sc.nextInt();
                orderManager.removeOrder(tableID);
                break;
            case 6:
                System.out.println("Enter new service charge rate percentage (whole numbers only)");
                int serviceChargeRate = sc.nextInt();
                System.out.println("Enter new government tax rate percentage (whole numbers only)");
                int governmentTaxRate = sc.nextInt();
                // orderPriceCalculator.taxRate(serviceChargeRate,governmentTaxRate)
                System.out.println("Updated Service Charge: " + serviceChargeRate + " Updated government tax rate: "
                        + governmentTaxRate);
                break;

            }
        } while (true);
    }

}
