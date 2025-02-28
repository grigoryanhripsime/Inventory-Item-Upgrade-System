package org.InventoryItemUpgradeSystem;

import java.util.Objects;

public class Item {
    private String name;
    private Rarity rarity;
    private int upgradeCount;

    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

    public Item(String name, Rarity rarity, int upgradeCount) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = upgradeCount;
    }

    public Item(String name) {
        this.name = name;
        this.rarity = Rarity.Common;
        this.upgradeCount = 0;
    }

    public Item(Item item) {
        this.name = item.name;
        this.rarity = item.rarity;
        this.upgradeCount = item.upgradeCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", rarity=" + rarity +
                ", upgradeCount=" + upgradeCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Item other = (Item) o;
        return Objects.equals(this.name, other.name) && Objects.equals(this.rarity, other.rarity) && this.upgradeCount == other.upgradeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.rarity, this.upgradeCount);
    }
}
