package Menu;

import java.math.BigDecimal;

enum FoodType {
    MAIN, DRINK, DESSERT
};

public class MenuItem {

    private int id;
    private String name;
    private String description;
    private double price;
    private String type;

    /**
     * 
     * @param id
     * @param name
     * @param description
     * @param price
     * @param type
     */

    public MenuItem(int id, String type, String name, String description, double price) {
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

    public double getPrice() {
        return this.price;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public void updateDesc(String newDescription) {
        this.description = newDescription;
    }

    public String getType() {
        return this.type;
    }

}