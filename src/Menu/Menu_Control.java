package Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu_Control {

    private ArrayList<MenuItem> MenuList = new ArrayList<MenuItem>();
    private ArrayList<PromotionPackage> PromoPackageList = new ArrayList<PromotionPackage>();

    public void printMenu() {

    }

    public void loadMenuItem() {
        // load menu from pre-populated textfile
        try {
            File MenuFile = new File("data", "Menu.txt");
            Scanner myReader = new Scanner(MenuFile);
            myReader.nextLine();
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arrLinedata = data.split("|", 7);

                // for(int i=0; i< MenuList.size(); i++) {
                // if(MenuList.get(i).getName().equals(arrLinedata[2]) ) {
                // itemloaded = true;
                // }
                // }
                // if(itemloaded == false) {
                MenuList.add(new MenuItem(i, FoodType.valueOf(arrLinedata[1]), arrLinedata[2], arrLinedata[3],
                        Double.parseDouble(arrLinedata[4])));
                // createMenuItem(FoodType.valueOf(arrLinedata[1]), arrLinedata[2],
                // arrLinedata[3], Double.parseDouble(arrLinedata[4]));
                // }
                i++;
            }
            myReader.close();
            // System.out.print("\nMenu was loaded from Menu Item text file\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Menu not updated");
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param name
     * @param description
     * @param price
     * @param foodType
     */
    public void createMenuItem(FoodType type, String name, String description, double price) {
        MenuItem newItem = new MenuItem(MenuList.size(), type, name, description, price);
        MenuList.add(newItem);

    }

    /**
     * 
     * @param description
     * @param packagePrice
     */
    public void createNewPackage(String description, double packagePrice) {
        PromotionPackage newPackage = new PromotionPackage(PromoPackageList.size(), description, packagePrice);
        PromoPackageList.add(newPackage);

    }

    /**
     * 
     * @param id
     */
    public void removeMenuItem(int id) {
        MenuList.remove(id); // remove item from menu by accessing their index. //TODO Implement removing
                             // item by searching the item name
    }

    /**
     * 
     * @param MenuItem
     * @param name
     */
    public void updateMenuItemName(int id, int name) {

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