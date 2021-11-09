package Order;

import java.util.Scanner;
import Menu.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Order {

    private int tableID;
    // private float totalPriceBeforeTax;
    // private float totalPriceAfterTax;
    private boolean membershipStatus;
    private int staffID;
    private HashMap<Integer, Integer> orderedItems = new HashMap<Integer, Integer>();

    public Order(int tableID, boolean membershipStatus, int staffID, HashMap<Integer, Integer> orderedItems) {
        this.tableID = tableID;
        this.membershipStatus = membershipStatus;
        this.staffID = staffID;
        this.orderedItems = orderedItems;
    }

    public int getTableID() {
        return tableID;
    }

    public boolean isMembershipStatus() {
        return membershipStatus;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public HashMap<Integer, Integer> getOrderedItems() {
        return this.orderedItems;
    }

    public void addItems(int itemID, int quantity) {
        if (orderedItems.containsKey(itemID)) {
            incrementValueFromKey(itemID, quantity);
        } else {
            orderedItems.put(itemID, quantity);
        }

    }

    public void incrementValueFromKey(int key, int increment) {
        orderedItems.computeIfPresent(key, (k, v) -> v + increment);
    }

    public void removeItems(int itemID, int quantity) {
        if (orderedItems.containsKey(itemID)) {
            decrementValueFromKey(itemID, quantity);
        } else {
            System.out.println("No such item in the existing order");
        }

    }

    public void decrementValueFromKey(int key, int decrement) {
        orderedItems.computeIfPresent(key, (k, v) -> v - decrement);
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setMembershipStatus(boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }
}
