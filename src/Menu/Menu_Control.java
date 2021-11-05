package Menu;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Menu_Control {

    private ArrayList<MenuItem> MenuList = new ArrayList<MenuItem>();
    private ArrayList<PromotionPackage> PromoPackageList = new ArrayList<PromotionPackage>();

    public void printMenu() {

    }

    /**
     * 
     * @param name
     * @param description
     * @param price
     * @param foodType
     */
    public void createMenuItem(String name, String description, BigDecimal price, FoodType foodType) {
        MenuItem newItem = new MenuItem(MenuList.size(), name, description, price, foodType);
        MenuList.add(newItem);

    }

    /**
     * 
     * @param description
     * @param packagePrice
     */
    public void createNewPackage(String description, BigDecimal packagePrice) {
        PromotionPackage newPackage = new PromotionPackage(PromoPackageList.size(), description, packagePrice);
        PromoPackageList.add(newPackage);

    }

    /**
     * 
     * @param id
     */
    public void removeMenuItem(int id) {
        // TODO - implement Menu_Manager.removeMenuItem
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param MenuItem
     * @param name
     */
    public void updateMenuItemName(int MenuItem, int name) {
        // TODO - implement Menu_Manager.updateMenuItemName
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param MenuItem
     * @param desc
     */
    public void updateMenuItemDesc(int MenuItem, int desc) {
        // TODO - implement Menu_Manager.updateMenuItemDesc
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param MenuItem
     * @param orderPrice
     */
    public void updateMenuItemPrice(int MenuItem, int orderPrice) {
        // TODO - implement Menu_Manager.updateMenuItemPrice
        throw new UnsupportedOperationException();
    }

    public void updatePackageDescription() {

    }

    /**
     * 
     * @param PromotionPackage
     */
    public void printPromotionPackage(int PromotionPackage) {
        // TODO - implement Menu_Manager.printPromotionPackage
        throw new UnsupportedOperationException();
    }

}