package Order;

import java.util.Scanner;
import Menu.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Order {

    private int tableID;
    // private float totalPriceBeforeTax;
    // private float totalPriceAfterTax;
    // private boolean membershipStatus;
    private int staffID;
    private HashMap<Integer, Integer> orderedItems = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> orderedPackages = new HashMap<Integer, Integer>();
    private double totalPrice;

    public Order(int tableID, int staffID, HashMap<Integer, Integer> orderedItems,
            HashMap<Integer, Integer> orderedPackages, double totalPrice) {
        this.tableID = tableID;
        // this.membershipStatus = membershipStatus;
        this.staffID = staffID;
        this.orderedItems = orderedItems;
        this.orderedPackages = orderedPackages;
        this.totalPrice = totalPrice;
    }

    public int getTableID() {
        return tableID;
    }

    // public boolean isMembershipStatus() {
    // return membershipStatus;
    // }

    public int getStaffID() {
        return staffID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public HashMap<Integer, Integer> getOrderedItems() {
        return this.orderedItems;
    }

    public HashMap<Integer, Integer> getOrderedPackages() {
        return this.orderedPackages;
    }

    public void addItems(int itemID, int quantity) {
        // access the price of the item from Menu object and add it to order total price
        this.totalPrice += (Menu_Control.getMenuArrayList().get(itemID).getPrice() * quantity);
        if (orderedItems.containsKey(itemID)) {
            incrementPromoValueFromKey(itemID, quantity);
        } else {
            orderedItems.put(itemID, quantity);
        }

    }

    public void addPackages(int packageID, int quantity) {
        // access the price of the package from Menu object and add it to order total
        // price
        this.totalPrice += (Menu_Control.getPromoPackageList().get(packageID).getPackagePrice() * quantity);
        if (orderedPackages.containsKey(packageID)) {
            incrementPromoValueFromKey(packageID, quantity);
        } else {
            orderedPackages.put(packageID, quantity);
        }

    }

    public void incrementItemValueFromKey(int key, int increment) {
        orderedItems.computeIfPresent(key, (k, v) -> v + increment);
    }

    public void incrementPromoValueFromKey(int key, int increment) {
        orderedPackages.computeIfPresent(key, (k, v) -> v + increment);
    }

    public void removeItems(int itemID, int quantity) {
        if (orderedItems.containsKey(itemID)) {
            // access the price of item from Menu object and subtract from order total
            this.totalPrice -= (Menu_Control.getMenuArrayList().get(itemID).getPrice() * quantity);
            decrementItemValueFromKey(itemID, quantity);
        } else {
            System.out.println("No such item in the existing order");
        }

    }

    public void removePackages(int packageID, int quantity) {
        if (orderedPackages.containsKey(packageID)) {
            // access the price of package from Menu object and subtract from order total
            this.totalPrice -= (Menu_Control.getPromoPackageList().get(packageID).getPackagePrice() * quantity);
            decrementPromoValueFromKey(packageID, quantity);
        } else {
            System.out.println("No such package in the existing order");
        }

    }

    public void decrementItemValueFromKey(int key, int decrement) {
        orderedItems.computeIfPresent(key, (k, v) -> v - decrement);
    }

    public void decrementPromoValueFromKey(int key, int decrement) {
        orderedPackages.computeIfPresent(key, (k, v) -> v - decrement);
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    // public void setMembershipStatus(boolean membershipStatus) {
    // this.membershipStatus = membershipStatus;
    // }

    public double getTotalPrice() {
        return this.totalPrice;
    }
}
