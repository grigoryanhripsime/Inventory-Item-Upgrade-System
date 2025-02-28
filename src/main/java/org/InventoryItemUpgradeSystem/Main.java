package org.InventoryItemUpgradeSystem;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static boolean execution(Inventory inv, Scanner scanner) throws FileNotFoundException {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Here are some options, for choosing one of them just enter the number!");
        System.out.println("1 - display inventory\n" +
                            "2 - add an item to the inventory\n" +
                            "3 - add an random item to the inventory\n" +
                            "4 - fill the inventory from file\n" +
                            "5 - upgrade the item\n" +
                            "6 - exit");
        System.out.println("-----------------------------------------------------------------");
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                break;
            }
            scanner.nextLine();
        }
        String name, rarity;
        int upgradeCount = 0;
        switch (choice) {
            case 1:
                inv.displayInventory();
                return false;
            case 2:
                System.out.print("Name: ");
                name = scanner.nextLine();
                System.out.print("Rarity(Common, Great, Rare, Epic, Legendary): ");
                rarity = scanner.nextLine();
                inv.addItem(new Item(name, Rarity.getByStr(rarity)));
                return false;
            case 3:
                inv.addRandomItem();
                return false;
            case 4:
                System.out.print("Enter file path: ");
                String file_name = scanner.nextLine();
                inv.addItemsFromFile(file_name);
                return false;
            case 5:
                System.out.print("Name: ");
                name = scanner.nextLine();
                System.out.print("Rarity(Common, Great, Rare, Epic, Legendary): ");
                rarity = scanner.nextLine();
                if (rarity.equals("Epic")) {
                    System.out.print("Upgrade count(0 - 2): ");
                    upgradeCount = scanner.nextInt();
                }
                inv.upgrade(new Item(name, Rarity.getByStr(rarity), upgradeCount));
                return false;
            case 6:
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        try {
            for (int i = 0; i < args.length; i++)
                inv.addItemsFromFile(args[i]);
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Welcome to our Iventory Item Upgrading system!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                if (execution(inv, scanner))
                    break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}