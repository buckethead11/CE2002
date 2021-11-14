
package Order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import Menu.*;
import Staff.*;

public class OrderInvoice {

    private Order order;

    private int invoiceNumber;

    private double price;

    private double gstAmount;

    private double discountAmount;

    private Calendar dateGenerated;

    private double totalPrice;

    private double finalPrice;

    private boolean haveMembership;

    private static double discountRatePercentage = 10;

    private static double gstRatePercentage = 7;

    public OrderInvoice(Order order, boolean member) {
        this.order = order;
        this.invoiceNumber = Math.abs(Calendar.getInstance().hashCode());
        this.price = order.getTotalPrice();
        this.gstAmount = gstRatePercentage / 100 * price;
        this.dateGenerated = Calendar.getInstance();
        this.totalPrice = (this.price + this.gstAmount);
        this.discountAmount = discountRatePercentage / 100 * totalPrice;
        this.haveMembership = member;
        if (haveMembership) {
            this.finalPrice = this.totalPrice - this.discountAmount;
        } else
            this.finalPrice = this.totalPrice;
    }

    /**
     * Get the date invoice was generated
     *
     * @return This invoice date
     */
    public Calendar getDateGenerated() {
        return dateGenerated;
    }

    public static void setGSTRate(double rate) {
        OrderInvoice.gstRatePercentage = rate;
    }

    public static void setDiscountRate(double rate) {
        OrderInvoice.discountRatePercentage = rate;
    }

    /**
     * Get the total price chargeable for the invoice
     *
     * @return This invoice price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Get the order of this invoice
     *
     * @return This invoice order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Print this invoice
     */
    public void printInvoice() {
        HashMap<Integer, Integer> orderItemsToBePrinted = this.order.getOrderedItems();
        HashMap<Integer, Integer> orderPackagesToBePrinted = this.order.getOrderedPackages();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        System.out.println(
                "\n================  Final Invoice For Table " + this.order.getTableID() + " =================");
        String invoiceInfoFormat = "|%-45s  %12d|%n";
        String invoiceStaffNameFormat = "|%-45s  %12s|%n";

        System.out.println(
                "---------------------" + formatter.format(this.dateGenerated.getTime()) + "---------------------");
        System.out.format("*************************************************************%n");
        System.out.format("~~~~~~~~~~~~~~~~~~~~~~~OODP RESTAURANT~~~~~~~~~~~~~~~~~~~~~~~%n");
        System.out.format("                       simply the best                       %n");
        System.out.format("          2002 Nanyang World, Singapore 632002               %n");
        System.out.format("                        Tel: 62353535                        %n");
        System.out.format("*************************************************************%n");
        System.out.printf(invoiceStaffNameFormat, "Order Taken by: ",
                Staff_Control.getStaffList().get(this.order.getStaffID() - 1).getName());
        System.out.printf(invoiceInfoFormat, "Invoice Number: ", this.invoiceNumber);

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

        String amountFormat = "|%-46s   %10.2f|%n";
        System.out.format("=============================================================%n");
        System.out.printf(amountFormat, "Subtotal:", this.price);
        System.out.printf(amountFormat, "GST(7%):", this.gstAmount);
        System.out.printf(amountFormat, "Total:", this.totalPrice);
        if (this.haveMembership)
            System.out.printf(amountFormat, "Member Discount(10%):", this.discountAmount);
        else
            System.out.printf(amountFormat, "Member Discount(10%):", 0.00);
        System.out.printf(amountFormat, "Grand Total:", this.finalPrice);
    }

}
