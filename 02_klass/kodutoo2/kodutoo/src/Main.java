public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("6 pack Toilet paper", 100, 12.99);
        Item item2 = new Item("1L Ketchup", 250, 1.79);
        Item item3 = new Item("Logitech Computer Mouse", 20, 69.99);

        item1.addAmount(50);
        System.out.println(item1.name + " amount: " + item1.amount);

        item2.changePrice(2.19);
        System.out.println(item2.name + " price: " + item2.price);

        item3.addAmount(20);
        item3.changePrice(49.99);
        System.out.println(item3.name + " , amount: " + item3.amount + " price: " + item3.price);
    }
}
