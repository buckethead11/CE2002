package Menu;

import java.math.BigDecimal;

public class PromotionPackage {

    private int packageId;
    private double packagePrice;
    private String description; // example of description: Package contains Carbonara+ Teh peng + ice cream. we
                                // can change to using arraylist of menuItemID in the future

    /**
     * 
     * @param packageId
     * @param packagePrice
     * @param description
     */
    public PromotionPackage(int packageId, String description, double packagePrice) {
        this.packageId = packageId;
        this.packagePrice = packagePrice;
        this.description = description;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public double getPackagePrice() {
        return this.packagePrice;
    }

    public String getDesc() {
        return this.description;
    }

    public void updatePackagePrice(double newPrice) {
        this.packagePrice = newPrice;
    }

    public void updateDesc(String newDescription) {
        this.description = newDescription;
    }

}