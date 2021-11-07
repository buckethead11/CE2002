package Menu;

import java.util.Scanner;

import util.*;

public class Menu_UI {
    static int choice = 0;
    static Scanner sc = new Scanner(System.in);

    public static void start() {
        Menu_Control.loadMenuItem();
        Menu_Control.loadPromo();
        {
            do {
                System.out.println("================MENU/PROMO PACKAGE======================");
                System.out.println("What do you want to do?");
                System.out.println("(1) View Menu");
                System.out.println("(2) View Promo Package");
                System.out.println("(3) Add Menu Item");
                System.out.println("(4) Update Menu Item");
                System.out.println("(5) Delete Menu Item");
                System.out.println("(6) Add Promo Package");
                System.out.println("(7) Update Promo Package");
                System.out.println("(8) Delete Promo Package");
                System.out.println("(9) Go back");
                System.out.println("========================================================");
                choice = sc.nextInt();
                switch (choice) {
                case 1:
                    Menu_Control.showMenu();
                    break;
                case 2:
                    Menu_Control.showPromotionPackage();
                    break;
                case 3:
                    addMenuItem();
                    break;
                case 4:
                    updateMenuItem();
                    break;
                case 5:
                    deleteMenuItem();
                    break;
                case 6:
                    addPromoPackage();
                    break;
                case 7:
                    updatePromoPackage();
                    break;
                case 8:
                    deletePromoPackage();
                    break;
                case 9:
                    return;
                }
            } while (choice < 10);
        }
    }

    public static void addMenuItem() {
        System.out.print("The type of the new item (MAIN/DRINK/DESSERT):\t");
        String type = sc.nextLine();
        System.out.print("The name of the new item:\t");
        String name = sc.nextLine();
        System.out.print("The description of the new item:\t");
        String description = sc.nextLine();
        System.out.print("The price of the new item:\t");
        double price = sc.nextDouble();
        sc.nextLine();
        Menu_Control.createMenuItem(type, name, description, price);
        System.out.print(name + "added!\n");
    }

    public static void updateMenuItem() {
        System.out.println("What do you want to update?");
        System.out.println("(1) Update Menu Item Description");
        System.out.println("(2) Update Menu Item Price");
        System.out.println("(3) Go back!");
        choice = inputCheck.menuChoice(1, 3);
        if (choice == 1) {
            System.out.println("Current Menu for Reference");
            Menu_Control.showMenu();
            System.out.print("The item ID to be updated:\t");
            int id = sc.nextInt();
            System.out.print("The new description of the item:\t");
            String description = sc.nextLine();
            Menu_Control.updateMenuItemDesc(id, description);
        }
        if (choice == 2) {
            System.out.println("Current Menu for Reference");
            Menu_Control.showMenu();
            System.out.print("The item ID to be updated:\t");
            int id = sc.nextInt();
            System.out.print("The new price of the item:\t");
            double price = sc.nextDouble();
            Menu_Control.updateMenuItemPrice(id, price);
        }

    }

    public static void deleteMenuItem() {
        System.out.println("Current Menu for Reference");
        Menu_Control.showMenu();
        System.out.print("The item ID to be deleted:\t");
        int id = sc.nextInt();
        Menu_Control.removeMenuItem(id);
    }

    public static void addPromoPackage() {
        System.out.print("The description of the new promo package:\t");
        String description = sc.next();
        System.out.print("The price of the new promo package:\t");
        double price = sc.nextDouble();
        Menu_Control.createNewPackage(description, price);
        System.out.print("New promo package added!\n");
    }

    public static void updatePromoPackage() {
        System.out.println("What do you want to update?");
        System.out.println("(1) Update promo package Description");
        System.out.println("(2) Update promo package Price");
        System.out.println("(3) Go back!");
        choice = inputCheck.menuChoice(1, 3);
        if (choice == 1) {
            System.out.println("Current promo package for Reference");
            Menu_Control.showPromotionPackage();
            System.out.print("The promo package ID to be updated:\t");
            int id = sc.nextInt();
            System.out.print("The new description of the promo package:\t");
            String description = sc.nextLine();
            Menu_Control.updatePromoDesc(id, description);
        }
        if (choice == 2) {
            System.out.println("Current Menu for Reference");
            Menu_Control.showMenu();
            System.out.print("The promo package ID to be updated:\t");
            int id = sc.nextInt();
            System.out.print("The promo package price of the item:\t");
            double price = sc.nextDouble();
            Menu_Control.updatePromoPrice(id, price);
        }

    }

    public static void deletePromoPackage() {
        System.out.println("Current promo package for Reference");
        Menu_Control.showPromotionPackage();
        System.out.print("The promo package ID to be deleted:\t");
        int id = sc.nextInt();
        Menu_Control.removePackage(id);
    }
}
