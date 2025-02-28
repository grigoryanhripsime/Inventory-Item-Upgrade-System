package org.InventoryItemUpgradeSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Inventory {
    Map<Item, Integer> items;
    Rarity flag;

    public Inventory() {
        this.items = new HashMap<Item, Integer>();
    }

    public Inventory(Map<Item, Integer> other) {
        this.items = new HashMap<Item, Integer>();
        this.items.putAll(other);
    }

    public void addItem(Item item) {
        items.compute(item, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public void addRandomItem() {
        //for generating random rarity, with mentioned probabilities
        //lets define that if num is (1 - 50) its Common, (51 - 75) its Great, (76 - 90) -> Rare, (91 - 98) -> Epic, other is Legendary
        Random random = new Random();
        int rand = random.nextInt(100) + 1;
        Rarity rarity;
        if (rand <= 50)
            rarity = Rarity.Common;
        else if (rand <= 75)
            rarity = Rarity.Great;
        else if (rand <= 90)
            rarity = Rarity.Rare;
        else if (rand <= 98)
            rarity = Rarity.Epic;
        else rarity = Rarity.Legendary;
        String[] weapons = {"Wooden Sword", "Rusty Dagger", "Training Spear", "Iron Sword", "Bronze Axe", "Reinforced Mace", "Diamond Sword", "Enchanted Bow", "Shadow Dagger", "Dragon Slayer", "Obsidian Katana", "Phoenix Spear", "Excalibur", "Doomhammer", "Celestial Blade"};
        rand = random.nextInt(15);
        this.addItem(new Item(weapons[rand], rarity));
    }

    public void addItemsFromFile(String arg) throws FileNotFoundException {
        File file = new File(arg);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            if (line.isEmpty())
                break ;
            if (!line.contains(","))
                throw new RuntimeException("Invalid line");
            addItem(new Item(line.substring(0, line.indexOf(',')), Rarity.getByStr(line.substring(line.indexOf(',') + 1))));
        }
        scanner.close();
    }

    private boolean upgrading(Integer res, Item item, Item tmpItem) {
        if (res == null)
            return false;
        flag = item.getRarity();
        int count = 3;
        if (item.getRarity() == Rarity.Epic) {
            if (item.getUpgradeCount() != 2 && item.getUpgradeCount() != tmpItem.getUpgradeCount())
                count = 1;
            else
                count = 2;
        }
        if (res < count)
            return false;
        if (res == count) {
            items.remove(tmpItem);
            if (count == 1)
                items.remove(item);
        }
        else
            items.put(tmpItem, res - count);
        if (count <= 2)
            item.setUpgradeCount(item.getUpgradeCount() + 1);
        else
            item.setRarity(Rarity.getByVal(flag.getVal() + 1));
        items.compute(item, (k, v) -> (v == null) ? 1 : v + 1);
        return true;
    }

    private boolean finding_and_upgrading(Item item) {
        Item tmpItem = item;

        Integer res = this.items.get(tmpItem);
        // if it's epic look for Epics, then Epic 1s, after all for Epic 2s.
        if (res != null && item.getRarity() == Rarity.Epic && item.getUpgradeCount() != 2) {
            for (int i = 0; i < 3; i++) {
                tmpItem = new Item(item.getName(), Rarity.Epic, i);
                res = this.items.get(tmpItem);
                if (res != null && (res > 1 || (res == 1 && !tmpItem.equals(item))))
                    break;
            }
        }
        return upgrading(res, item, tmpItem);
    }

    public void upgrade(Item item) {
        if (item.getRarity() == Rarity.Legendary)
            throw new RuntimeException("There is no way to upgrade Legendary yet!");
        flag = null;
        if (!finding_and_upgrading(item)) {
            if (flag != null)
                throw new RuntimeException("You don't have enough " + item.getName() + " to upgrade it!");
            else
                throw new RuntimeException("You don't have that kind of item!");
        }
        else if (item.getRarity() == Rarity.Epic) {
            switch (item.getUpgradeCount()) {
                case 1:
                    System.out.println("Item named " + item.getName() + " was upgraded from Epic to Epic 1 successfully!");
                    break;
                case 2:
                    System.out.println("Item named " + item.getName() + " was upgraded from Epic 1 to Epic 2 successfully!");
                    break;
            }
        } else {
            System.out.println("Item named " + item.getName() + " was upgraded from " + item.getRarity() + " to " + Rarity.getByVal(item.getRarity().getVal() + 1) + " successfully!");
        }
    }

    public void displayInventory() {
        if (this.items.isEmpty()) {
            System.out.println("Your inventory is empty!");
            return ;
        }
        System.out.println("In your inventory you have: ");
        for (Map.Entry<Item, Integer> i : items.entrySet()) {
            System.out.print(i.getValue() + " " + i.getKey().getName() + "s with " + i.getKey().getRarity() + " rarity");
            if (i.getKey().getRarity() == Rarity.Epic)
                System.out.print(" and " + i.getKey().getUpgradeCount() + " upgrade count");
            System.out.println("!");
        }
    }
}