import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public Inventory(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item)
    {
        upgrade(item);
    }

    public void upgrade(Item item)
    {
        for (Item i : items)
        {
            if (i.getName().equals(item.getName()) && (i.getRarity() == item.getRarity() || item.rarity == Rarity.Epic && i.rarity == Rarity.Epic_1) && item.rarity != Rarity.Epic_1)
            {
                switch (i.rarity)
                {
                    case Common:
                        if (i.upgrade_count == 2) {
                            i.rarity = Rarity.Great;
                            i.upgrade_count = 0;
                            return ;
                        }
                        i.upgrade_count++;
                        return ;
                    case Great:
                        if (i.upgrade_count == 2) {
                            i.rarity = Rarity.Rare;
                            i.upgrade_count = 0;
                            return ;
                        }
                        i.upgrade_count++;
                        return ;
                    case Rare:
                        if (i.upgrade_count == 2) {
                            i.rarity = Rarity.Epic;
                            i.upgrade_count = 0;
                            return ;
                        }
                        i.upgrade_count++;
                        return ;
                    case Epic:
                        if (i.upgrade_count == 1) {
                            i.rarity = Rarity.Epic_1;
                            i.upgrade_count = 0;
                            return ;
                        }
                        i.upgrade_count++;
                        return ;
                    case Epic_1:
                        if (i.upgrade_count == 1) {
                            i.rarity = Rarity.Great;
                            i.upgrade_count = 0;
                            return ;
                        }
                        i.upgrade_count++;
                        return ;
                    case Epic_2:
                        if (i.upgrade_count == 2) {
                            i.rarity = Rarity.Legendary;
                            i.upgrade_count = 0;
                            return ;
                        }
                        i.upgrade_count++;
                        return ;
                }
            }
        }
        items.add(item);
    }

    public void displayInventory()
    {
        for (Item i : items)
            System.out.println(i);
    }
}
