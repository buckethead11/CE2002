package Menu;

import java.math.BigDecimal;

public class PromotionPackage extends Item {

    /**
     * 
     * @param packageId
     * @param packagePrice
     * @param description
     */
    public PromotionPackage(int packageId, String description, double packagePrice) {
        this.id = packageId;
        this.price = packagePrice;
        this.description = description;
    }

    public int getID() {
        return this.id;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDesc() {
        return this.description;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public void updateDesc(String newDescription) {
        this.description = newDescription;
    }

}