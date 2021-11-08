package Order;

import java.util.Scanner;




public class Order_UI {

    public static void main(String[] args){
        showOrderUI();
    }
    

    public static void showOrderUI(){
        Scanner sc = new Scanner(System.in);
        int input;
        do{
            System.out.println("(1) View a order");
            System.out.println("(2) Create a new order");
            System.out.println("(3) Add an item to Order");
            System.out.println("(4) Delete an item from Order");
            System.out.println("(5) Delete an Order");
            System.out.println("(6) Set and Change Tax Rate");

            input = sc.nextInt();

            switch(input){
                case 1: //view an order
                    System.out.println("Please enter the orderID to view");
                    try{
                        input = sc.nextInt();
                        orderManager.printOrderedItems(input);
                        break;
    
                    }catch (Exception e){
                        System.out.println("Error: Please enter a valid input");
                    }
                    break;
                    
                case 2: // create a new Order
                try{
                    System.out.println("Enter Order Number");
                    int orderNumber = sc.nextInt();
                    System.out.println("Enter Staff ID");
                    int staffID = sc.nextInt();
                    System.out.println("Membership (Y/N)");
                    char membership= sc.next().charAt(0);
                    orderListManager.createNewOrder(orderNumber,membership,staffID);
                }catch (Exception e){
                    System.out.println("Please enter an integer for Order Number or Staff ID");
                }
                break;
                    

                case 3:// add an item into order
                    System.out.println("Pleaes key in the order you want to edit");
                    int orderID = sc.nextInt();
                    System.out.println("Please enter itemID to be added");
                    int itemID = sc.nextInt();
                    System.out.println("Please enter Quantity");
                    int quanitity = sc.nextInt();
                    orderManager.addItemToOrder(orderID, itemID, quanitity);
                    /*
                    try{


                    } catch (Exception e){
                        System.out.println("Error: Please enter a valid value");
                    }*/
                    break;

                case 4:// delete an item from other
                    System.out.println("Pleaes key in the order you want to edit");
                    try{
                        orderID = sc.nextInt();
                        System.out.println("Please enter itemID to be deleted ");
                        itemID = sc.nextInt();
                        System.out.println("Please enter Quantity");
                        int quantity = sc.nextInt();
                        orderManager.removeItemFromOrder(orderID, itemID, quantity);
                    
                    } catch (Exception e){
                        System.out.println("Error: Please enter a valid value");
                    }
                    break;



                case 5: // Delete an order
                    System.out.println("Printing out all the orders");
                    orderListManager.getAllOrders();
                    System.out.println("Which order do you want to delete?");
                    orderID= sc.nextInt();
                    orderListManager.deleteOrder(orderID);
                    break;
                case 6 :
                    System.out.println("Enter new service charge rate percentage (whole numbers only)");
                    int serviceChargeRate =sc.nextInt();
                    System.out.println("Enter new government tax rate percentage (whole numbers only)");
                    int governmentTaxRate =sc.nextInt();
                    //orderPriceCalculator.taxRate(serviceChargeRate,governmentTaxRate)
                    System.out.println("Updated Service Charge: "+ serviceChargeRate+" Updated government tax rate: "+governmentTaxRate);
                    break;
                 
            }
        }while(true);
    }



}
