public class Item {
    public String name;
    public Rarity rarity;
    public int upgrade_count;

    public Item() {
        name = "Default";
        rarity = Rarity.Common;
        upgrade_count = 0;
    }

    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgrade_count = 0;
    }

    public Item(String name) {
        this.name = name;
        this.rarity = Rarity.Common;
        this.upgrade_count = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public void setUpgrade_count(int upgrade_count) {
        this.upgrade_count = upgrade_count;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getUpgrade_count() {
        return upgrade_count;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", rarity=" + rarity +
                ", upgrade_count=" + upgrade_count +
                '}';
    }
};
