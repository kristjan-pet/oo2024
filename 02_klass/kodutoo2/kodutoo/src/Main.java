public class Main {
    // public static void main(String[] args) {
    //     Kasutaja kasutaja = new Kasutaja("M", true, 30, 'x', 0.0);
    //     Kasutaja kasutaja2 = new Kasutaja("S", false, 35, 'y', 100.0);

    //     kasutaja.muudaAktiivne();
    //     System.out.println(kasutaja.aktiivne);
    //     double kasutaja2Raha = kasutaja2.lisaRaha(500.0);
    //     System.out.println(kasutaja2Raha);

    //     Tellimus tellimus1 = new Tellimus("M", 199.0, "Coca");
    //     Tellimus tellimus2 = new Tellimus("S", 299.5, "Fanta");

    //     double dollarites = tellimus1.tellimuseSummaDollarites();
    //     System.out.println(dollarites);

    //     tellimus2.tellijaNimeVahetus("Y");
    //     System.out.println(tellimus2.tellija);
    // }

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
