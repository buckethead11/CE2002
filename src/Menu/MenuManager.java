package OOP.Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuManager {
    double price = 0;
    boolean validInput = false;
    static private ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>();
    static private ArrayList<PromotionPackage> promotionPackage = new ArrayList<PromotionPackage>();
    private static Scanner sc = new Scanner(System.in);

    //return promotional package array list
    public static ArrayList<PromotionPackage> getPromotionPackageObject() {
        updateMenuItem();
        return promotionPackage;
    }

    //return menu item array list
    public static ArrayList<MenuItem> getMenuObject() {
        updateMenuItem();
        return menuItem;
    }

    public static boolean checkItemName(String NameCheck) {
        updateMenuItem();
        for(int i = 0; i < menuItem.size(); i++) {
            if(menuItem.get(i).getName().equals(NameCheck)) {
                return true;
            }
        }
        return false;
    }

    public static double getItemPrice(String NameOfItem) {
        updateMenuItem();
        for(int i = 0; i < menuItem.size(); i++) {
            if(menuItem.get(i).getName().equals(NameOfItem)) {
                return menuItem.get(i).getPrice();
            }
        }
        System.out.println("Price not found");
        return 0;
    }

    public static boolean checkPromotionalPackageIndex(int IndexOfPackage) {
        updateMenuItem();
        for(int i = 0; i < promotionPackage.size(); i++) {
            if(promotionPackage.get(i).getIndex() == IndexOfPackage) {
                return true;
            }
        }
        return false;
    }

    public static double getPackagePrice(int IndexOfPackage) {
        updateMenuItem();
        for(int i = 0; i < promotionPackage.size(); i++) {
            if(promotionPackage.get(i).getIndex() == IndexOfPackage) {
                return promotionPackage.get(i).getPrice();
            }
        }
        return 0;
    }

    //create menu item
    public ArrayList<MenuItem> createMenuItem() {
        System.out.println("Enter item type: ");
        String type = sc.nextLine();
        System.out.println("Enter the name: ");
        String name = sc.nextLine();
        System.out.println("Enter the decription: ");
        String desc = sc.nextLine();
        System.out.println("Enter the price: ");
        while(!validInput) {
            try {
                price = sc.nextDouble();
                validInput = true;
            } catch(InputMismatchException e) {
                System.out.println("Enter a number");
                sc.next();
            }
        }
        System.out.println("Enter the discount: ");
        while(!validInput) {
            try {
                discount = sc.nextDouble();
                validInput = true; 
            } catch(InputMismatchException e) {
                System.out.println("Enter a number");
                sc.next();
            }
        }

        menuItem.add(new MenuItem(type, name, desc, price, discount));
        System.out.println("Menu Item was added");
        convertMenuData();
        return menuItem;
    }

    public static void createPromotionalPackageItem(){
        boolean validInput = false;
        double setPrice = 0;
        ArrayList<String> setList = new ArrayList<String>();

        System.out.println("Enter number of items in Package");
        int size = sc.nextInt();
        
        for(int i = 0; i < size; i++)
        {
            if(i == 0){
                sc.nextLine();
            }

            System.out.println("Enter name of item");
            String SetNames = sc.nextLine();
            if(checkItemName(SetNames)) {
                setList.add(SetNames);
            }

            else{
                System.out.println("Item does not exists please re-enter name from menu");
                SetNames = sc.nextLine();
                if(checkItemName(SetNames)) {
                    setList.add(SetNames);
                }
                else {
                    System.out.println("Item is not part of the menu");
                    viewMenu();
                }
            }
        }

        while(!validInput) {
            try {
                setPrice = sc.nextDouble();
                validInput = true;
            } catch(InputMismatchException e) {
                System.out.println("Enter a number");
            sc.next();
            }
        }

        promotionPackage.add(new PromotionPackage(promotionPackage.size(), setList, setPrice));
        convertPromotionPackageData();
        viewMenu();
    }

    public static void removeMenuItem() {
        int index = 1;
        System.out.println("Reference to current menu");
        for(int i = 0; i < menuItem.size(); i++) {
            System.out.print(index);
            System.out.print(")  ");
            System.out.print(menuItem.get(i).getType());
            System.out.print(" ");
            System.out.print(menuItem.get(i).getName());
            System.out.print(" ");
            System.out.print(menuItem.get(i).getPrice());
            System.out.print(" ");
            System.out.print(menuItem.get(i).getDesc());
            System.out.print(" ");
            System.out.println(menuItem.get(i).getDiscount());
            index++;
        }

        System.out.println("Enter item name to delete : ");
        String delete = sc.nextLine();

        for(int j = 0; j < menuItem.size(); j++) {
            if(menuItem.get(j).getName().equals(delete)) {
                menuItem.remove(j);
            }
        }

        convertMenuData();
    }

    public static void removePackageItem() {
        System.out.println("Enter the index of the package you want to delete : ");
        int delete = sc.nextInt();

        for(int j = 0; j < promotionPackage.size(); j++) {
            if(promotionPackage.get(j).getIndex() == delete) {
                promotionPackage.remove(j);
            }
        }

        convertPromotionPackageData();
    }

    public static void viewMenu() {
        updateMenuItem();

    }


    public static void updateMenuItem() {
        boolean itemadded = false;
        boolean packageadded = false;

        try {
            File myObj = new File("data", "Menu.txt");
            Scanner reader = new Scanner(myObj);
            reader.nextLine();
            while(reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] arrLinedata = data.split(",",7);

                for(int i = 0; i < menuItem.size(); i++) {
                    if(menuItem.get(i).getName().equals(arrLinedata[2])) {
                        itemadded = true;
                    }
                }
                if(itemadded == false) {
                    menuItem.add(new MenuItem(arrLinedata[1], arrLinedata[2], arrLinedata[3], Double.parseDouble(arrLinedata[4]), Double.parseDouble(arrLinedata[5])));
                }

            }
            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        promotionPackage.removeAll(promotionPackage);
        try {
            File myObj = new File("data", "PromotionalPackage.txt");
            Scanner reader = new Scanner(myObj);
            while(reader.hasNextLine()) {
                ArrayList<String> setList = new ArrayList<String>();
                String data = reader.nextLine();
                String[] arrLinedata = data.split(",", 100);
                for(int i = 1; i < arrLinedata.length - 1; i++) {
                    setList.add(arrLinedata[i]);
                }

                for(int i = 0; i < promotionPackage.size(); i++) {
                    if(promotionPackage.get(i).getIndex() == Integer.parseInt(arrLinedata[0])) {
                        packageadded = true;
                    }
                }

                if(packageadded == false) {
                    promotionPackage.add(new PromotionPackage(Integer.parseInt(arrLinedata[0]), setList, Double.parseDouble(arrLinedata[arrLinedata.length - 1])));
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }


    public static void convertMenuData() {
        int index = 1;
        try {
            File myObj = new File("data", "Menu.txt");
            FileWriter writer = new FileWriter(myObj);
            writer.write("Menu\n");

            for(int i = 0; i < menuItem.size(); i++) {
                writer.write(String.valueOf(index));
                writer.write("),");
                writer.write(menuItem.get(i).getType());
                writer.write(",");
                writer.write(menuItem.get(i).getName());
                writer.write(",");
                writer.write(menuItem.get(i).getDesc());
                writer.write(",");
                writer.write(String.valueOf(menuItem.get(i).getPrice()));
                writer.write(",");
                writer.write(String.valueOf(menuItem.get(i).getDiscount()));
                writer.write("),");
                index++;
            }
            writer.close();
            System.out.println("Wrote to the file succesfully");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public static void convertPromotionPackageData() {
        int index = 1;
        try {
            File myObj = new File("data", "PromotionalPackage.txt");
            FileWriter writer = new FileWriter(myObj);

            for(int i = 0; i < promotionPackage.size(); i++){
                writer.write(String.valueOf(index));
                writer.write(",");

                for(int k = 0; k < promotionPackage.get(i).getSetList().size();k++) {
                    writer.write(promotionPackage.get(i).getSetList().get(k));
                    writer.write(",");
                }
                writer.write(String.valueOf(promotionPackage.get(i).getPrice()));
                writer.write("\n");
                index++;
            }
            writer.close();
            System.out.println("Wrote to the file");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }

    public static void editMenuItem() {
        boolean valid  = false;
        int index = 0;
        System.out.println("Enter the name of the item you would like to edit: ");
        String name = sc.nextLine();
        for(int i = 0; i < menuItem.size();i++) {
            if(menuItem.get(i).getName().equals(name)) {
                valid = true;
                index = i;
            }
        }
        if(valid == true) {
            System.out.println("Would you like to edit the description (Y=1/N=0) :");
            int choice1 = sc.nextInt();
            if(choice1 == 1) {
                System.out.println("Enter the new description :");
                String newDesc = sc.next();
                menuItem.get(index).setDesc(newDesc);
            }
            System.out.println("Would you like to edit the Price (Y=1/N=0) :");
            int choice2 = sc.nextInt();
            if(choice2 == 1) {
                System.out.println("Enter the new price :");
                double newPrice = sc.nextDouble();
                menuItem.get(index).setPrice(newPrice);
            }
            System.out.println("Would you like to edit the Discount (Y=1/N=0) :");
            int choice3 = sc.nextInt();
            if(choice3 == 1) {
                System.out.println("Enter the new discount :");
                double newDisc = sc.nextDouble();
                menuItem.get(index).setDiscount(newDisc);
            }
        }
    }






}
