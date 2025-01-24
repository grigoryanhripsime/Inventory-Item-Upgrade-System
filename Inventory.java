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
        items.add(item);
        upgrade();
    }

    public void upgrade()
    {
        int count = 0;
        for (int i = 0; i < items.size(); i++)
        {
            for (int j = i + 1; j < items.size(); j++)
            {
                if (items.get(i).getRarity() == items.get(j).getRarity() && items.get(i).getName().equals(items.get(j).getName()))
                {
                    count++;
                    if (count == 3 || items.get(i).getRarity() == Rarity.Epic)
                    {
                        switch (items.get(i).getRarity())
                        {
                            case Common:
                                toGreat();
                                return;
                            case Great:
                                toRare();
                                return ;
                            case Rare:
                                toEpic();
                                return ;
                            case Epic:
                                toLegendary();
                                return ;
                        }
                    }
                }
            }
        }
    }

    void toGreat()
    {
        boolean checked = false;
        int deleted = 0;
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getRarity() == Rarity.Common)
            {
                if (!checked)
                {
                    items.get(i).rarity = Rarity.Great;
                    checked = true;
                }
                else if(deleted < 2)
                {
                    items.remove(i);
                    deleted++;
                    i--;
                }
            }
        }
    }

    void toRare()
    {
        boolean checked = false;
        int deleted = 0;
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getRarity() == Rarity.Great)
            {
                if (!checked)
                {
                    items.get(i).rarity = Rarity.Rare;
                    checked = true;
                }
                else if(deleted < 2)
                {
                    items.remove(i);
                    deleted++;
                    i--;
                }
            }
        }
    }

    void toEpic()
    {
        boolean checked = false;
        int deleted = 0;
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getRarity() == Rarity.Rare)
            {
                if (!checked)
                {
                    items.get(i).rarity = Rarity.Epic;
                    checked = true;
                }
                else if(deleted < 2)
                {
                    items.remove(i);
                    deleted++;
                    i--;
                }
            }
        }
    }

    void toLegendary()
    {
        boolean checked = false;
        int deleted = 0;
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getRarity() == Rarity.Epic)
            {
                if (items.get(i).upgrade_count == 2 && !checked)
                {
                    items.get(i).rarity = Rarity.Legendary;
                    items.get(i).upgrade_count = 0;
                    checked = true;
                }
                else if (items.get(i).upgrade_count < 2 && !checked)
                {
                    items.get(i).upgrade_count++;
                    checked = true;
                }
                else if (checked)
                {
                    items.remove(i);
                    i--;
                    deleted--;
                }
            }
        }
    }

    public void displayInventory()
    {
        for (Item i : items)
            System.out.println(i);
    }
}
