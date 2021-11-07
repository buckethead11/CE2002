package Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu_Control {

    private static ArrayList<MenuItem> MenuList = new ArrayList<MenuItem>();
    private ArrayList<PromotionPackage> PromoPackageList = new ArrayList<PromotionPackage>();

    public static void showMenu() {
        System.out.println(
                "\n======================================================= Menu =======================================================");

        System.out.format(
                "+-----+------------+----------------------+--------------------------------------------------------------+----------+%n");
        System.out.format(
                "| ID  | Type       |       Name           |                        Description                           | Price($) |%n");
        System.out.format(
                "+-----+------------+----------------------+--------------------------------------------------------------+----------+%n");

        String menuFormat = "| %-3d | %-10s | %-20s | %-60s | %7.2f |%n";
        for (int i = 0; i < MenuList.size(); i++) {
            MenuItem item = MenuList.get(i);
            System.out.printf(menuFormat, i + 1, item.getType(), item.getName(), item.getDesc(), item.getPrice());
        }

    }

    public static void loadMenuItem() {
        // load menu from pre-populated textfile
        boolean itemexist = false;
        try {
            File MenuFile = new File("data", "Menu.txt");
            Scanner myReader = new Scanner(MenuFile);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arrLinedata = data.split(",", 8);
                for (int i = 0; i < MenuList.size(); i++) {
                    if (MenuList.get(i).getName().equals(arrLinedata[2])) {
                        itemexist = true;
                    }
                }
                if (itemexist == false) {
                    createMenuItem(arrLinedata[1], arrLinedata[2], arrLinedata[3], Double.parseDouble(arrLinedata[4]));
                }
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
     * @param type
     * @param name
     * @param description
     * @param price
     */
    public static void createMenuItem(String type, String name, String description, double price) {
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
    public static void removeMenuItem(int id) {
        MenuList.remove(id - 1); // remove item from menu by accessing their index.
        // TODO implement removing by item name
    }

    /**
     * 
     * @param id
     * @param newDesc
     */
    public static void updateMenuItemDesc(int id, String newDesc) {
        MenuList.get(id - 1).updateDesc(newDesc);
    }

    /**
     * 
     * @param id
     * @param newPrice
     */
    public void updateMenuItemPrice(int id, double newPrice) {
        MenuList.get(id - 1).updatePrice(newPrice);
    }

    public void updatePackageDescription() {

    }

    /**
     * 
     * @param PromotionPackage
     */
    public void showPromotionPackage(int PromotionPackage) {
        // TODO - implement Menu_Manager.printPromotionPackage
        throw new UnsupportedOperationException();
    }

}