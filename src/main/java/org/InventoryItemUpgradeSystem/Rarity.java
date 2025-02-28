package org.InventoryItemUpgradeSystem;

public enum Rarity {
    Common(0),
    Great(1),
    Rare(2),
    Epic(3),
    Legendary(4);

    private int val;

    Rarity(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setRarity(int val) {
        this.val = val;
    }

    public static Rarity getByVal(int val) {
        for (Rarity i : Rarity.values())
        {
            if (i.getVal() == val)
                return i;
        }
        throw new IllegalArgumentException("No Rarity for " + val);
    }

    public static Rarity getByStr(String str) {
        for (Rarity i : Rarity.values())
        {
            if (i.toString().equals(str))
                return i;
        }
        throw new IllegalArgumentException("No Rarity for " + str);
    }
}
