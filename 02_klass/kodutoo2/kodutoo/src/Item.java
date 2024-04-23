public class Item {
    String name;
    int amount;
    double price;

    public Item(String name, int amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int addAmount(int addAmount) {
        amount = amount + addAmount;
        return amount;
    }

    public double changePrice(double newPrice) {
        price = newPrice;
        return price;
    }
}
