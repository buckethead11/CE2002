package Menu;

import java.math.BigDecimal;

enum FoodType {
    MAIN, DRINK, DESSERT
};

public class MenuItem {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private FoodType type;

    /**
     * 
     * @param id
     * @param name
     * @param description
     * @param price
     * @param type
     */

    public MenuItem(int id, String name, String description, BigDecimal price, FoodType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public int getItemId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void updatePrice(BigDecimal newPrice) {
        this.price = newPrice;
    }

    public void updateDesc(BigDecimal newDescription) {
        this.price = newDescription;
    }

    public FoodType getType() {
        return this.type;
    }

}