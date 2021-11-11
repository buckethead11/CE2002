package Sales;

import java.util.*;

import Order.*;
public class Sales_UI {
    
    private HashMap<Integer,Integer> totalOrders = new HashMap<Integer,Integer>();
    public static void main(String[] args) {
    
    }
    public void start(){
        this.totalOrders = Order.getOrderedItems();
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
