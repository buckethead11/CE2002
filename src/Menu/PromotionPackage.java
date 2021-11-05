package Menu;

import java.math.BigDecimal;

public class PromotionPackage {

    private int packageId;
    private BigDecimal packagePrice;
    private String description; // example of description: Package contains Carbonara+ Teh peng + ice cream. we
                                // can change to using arraylist of menuItemID in the future

    /**
     * 
     * @param packageId
     * @param packagePrice
     * @param description
     */
    public PromotionPackage(int packageId, String description, BigDecimal packagePrice) {
        this.packageId = packageId;
        this.packagePrice = packagePrice;
        this.description = description;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public BigDecimal getPackagePrice() {
        return this.packagePrice;
    }

    public String getDesc() {
        return this.description;
    }

    public void updatePackagePrice(BigDecimal newPrice) {
        this.packagePrice = newPrice;
    }

    public void updateDesc(String newDescription) {
        this.description = newDescription;
    }

}