package Order;

import java.util.ArrayList;
import java.util.Scanner;

public class orderListManager{
    
    private static ArrayList<Order> orderList = new ArrayList<Order>();

    public static void createNewOrder(int orderID, char membership, int staffID){

        Scanner sc = new Scanner(System.in);
        //check if order ID have any duplicates
        int checkedOrderID =orderIDDuplicateCheck(orderID);
        //check if membership value is valid
        boolean membershipStatus =membershipInputValidityCheck(membership); 

        
        Order newOrder = new Order(checkedOrderID,membershipStatus,staffID);
        orderList.add(newOrder);
    }

    public static ArrayList<Order> getAllOrders(){
        // Read the list, for each object get the value 
        for (Order currentOrderList : orderList) { 
            System.out.println(currentOrderList.getOrderID()); 
        } 
        return orderList;
    }
    public static Order getSingleOrder(int orderID){
        // Read the list, for each object get the value 
        return orderList.get(orderID-1);
    }

    public static void deleteOrder(int orderID){
        try{
            if (orderID == -1) //to exit the method
                return;

            orderList.remove(orderID-1); //Deleting entire order from list
            System.out.println("Order " +orderID +" deleted");

        }catch (Exception e){
            System.out.println( "Order not found");

        }

    }







//--------------For the checking of errors---------------------------

public static boolean membershipInputValidityCheck(char userInput){
    Scanner sc = new Scanner(System.in);
    char membershipInput = userInput;
    boolean membershipStatus=false;
    //Error checking for memebrship
    while(true){
        if (membershipInput =='Y' || membershipInput == 'y' ){
            membershipStatus = true;
            break;
        }
        else if (membershipInput =='N' || membershipInput == 'n' ){
            membershipStatus = false;
            break;
        }
        else {
            System.out.println("Please key in membership status again (Y/N)");
            membershipInput = sc.next().charAt(0);
        }

    }
    return membershipStatus;
}

public static int orderIDDuplicateCheck(int orderID){
    Scanner sc = new Scanner(System.in);
    int checkOrderID =orderID;
    while(true){
        boolean flag= false;
        for (Order currentOrderList : orderList) { 
            if (checkOrderID == currentOrderList.getOrderID()){
                flag= true;
            }
        } 
        if (flag == true){
            System.out.println("Order ID number already exist. Please enter another number");
            try{
                checkOrderID = sc.nextInt();

            }catch (Exception e){
                System.out.println("Please enter an integer value for staff ID");
            }
        }
        else 
            break;
    }
    return checkOrderID;
}

public static int orderIDValidCheck (int orderID){
    Scanner sc = new Scanner(System.in);
    int checkedOrderID= orderID;
    while(true){
        boolean flag = false;
        for (Order currentOrderList : orderList){
            if (checkedOrderID == currentOrderList.getOrderID()){
                flag= true;
            }
        }
        if (flag == true)
            break;
        else{
            try{
                System.out.println("OrderID does not exist please enter a valid Order ID. To exit enter -1");
                checkedOrderID = sc.nextInt();
                if (checkedOrderID== -1)
                    break;


            }catch (Exception e){
                System.out.println("Please enter an integer value. To exit enter -1");
            }
        }
    }
    return checkedOrderID;
}

public static int getOrderIDIndex (int orderID){
    int checkedOrderID = orderIDValidCheck(orderID); // this will check if the order exisit or not
    int index=0;
    for (Order currentOrderList: orderList){
        if(checkedOrderID == currentOrderList.getOrderID()){
            return index+1;
        }
        else 
            index++;
    }
    //For debug- not needed because OrderID will always be valid becase of OrderIDValidCheck
    System.out.println("Error: OrderID not valid please try again");
    return index; 
}


}