package Order;
import java.util.Scanner;

import Menu.MenuItem;

import java.util.ArrayList;

public class Order {

    private int orderID;
    //private float totalPriceBeforeTax;
    //private float totalPriceAfterTax;
    private int staffID;
    private boolean membershipStatus;
    private ArrayList<MenuItem> orderedItems;

    public Order(int orderID, boolean membershipStatus, int staffID){
        this.orderID= orderID;
        this.membershipStatus= membershipStatus;
        this.staffID = staffID;
        this.orderedItems = new ArrayList<MenuItem>();
        
    }

    public ArrayList<MenuItem> getSingleOrderItems(){
        return orderedItems;
    }

    

    public int getOrderID() {
        return orderID;
    }

    public int getStaffID() {
        return staffID;
    }

    public boolean isMembershipStatus() {
        return membershipStatus;
    }

    public ArrayList<MenuItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setMembershipStatus(boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }
}
