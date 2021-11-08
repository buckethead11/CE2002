package Order;

import java.util.Calendar;

public class OrderInvoice {

    /**
     * Order for which this invoice was generated for
     */
    private Order order; // to combine with order class

    /**
     * Auto-generated invoice number of this invoice
     */
    private int invoiceNumber;

    /**
     * Gst charged for the order
     */
    private double gstAmount;

    private double discountAmount;

    /**
     * Price charge for the order, excluding gst
     */
    private double price;

    /**
     * Total price charged for the order
     */
    private double totalPrice;

    private double finalPrice; // final price after member discount
    /**
     * Date the invoice was generated
     */
    private Calendar dateGenerated;

    private boolean haveMembership;

    private static final double discountRate = 0.15;

    /**
     * GST percentage to be applied on price charged on order
     */
    public static final double GSTPERCENTAGE = 0.07;

    /**
     * Create a new invoice which will be tagged to an order.
     * 
     * @param order Order the invoice is generated for
     */
    public OrderInvoice(Order order) {
        this.order = order;
        this.invoiceNumber = Calendar.getInstance().hashCode();
        this.price = order.calculateTotalOrderPrice();
        this.dateGenerated = Calendar.getInstance();
        this.gstAmount = Math.round(GSTPERCENTAGE * this.price * 100.0) / 100.0;
        this.totalPrice = (this.price + this.gstAmount);
        this.discountAmount = Math.round(discountRate * this.totalPrice * 100.0) / 100.0;
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
        System.out.println("Date & Time: " + this.order.getDateTime());
        System.out.println("Order Taken by: " + this.order.getStaffName());
        System.out.println("Invoice Number: " + this.invoiceNumber);
        System.out.println("Items ordered: " + this.order);
        System.out.println("Subtotal: " + price);
        System.out.println("GST: " + gstAmount);
        System.out.println("Total: " + totalPrice);
        System.out.println("Member Discount: " + discountAmount);
        System.out.println("Grand Total: " + finalPrice);
    }

}