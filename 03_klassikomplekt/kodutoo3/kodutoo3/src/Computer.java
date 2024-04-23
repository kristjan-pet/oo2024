public class Computer {
    Info info;
    int cost;
    String store;

    public Computer(Info info, int cost, String store) {
        this.info = info;
        this.cost = cost;
        this.store = store;
    }

    public void changeStore(String store) {
        this.store = store;
    }

    public int getDiscount(int discount) {
        this.cost = this.cost - discount;
        return this.cost;
    }
}
