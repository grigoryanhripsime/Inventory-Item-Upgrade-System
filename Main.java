public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addItem(new Item("Iron Swords"));
        inv.addItem(new Item("Iron Swords"));
        inv.addItem(new Item("Iron Swords"));
        inv.addItem(new Item("Iron Swords"));
        inv.addItem(new Item("Iron Swords"));
        inv.displayInventory();
    }
}
