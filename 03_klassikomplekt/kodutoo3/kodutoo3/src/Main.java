public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer(new Info("MacBook", 16, "Intel", "1080p"), 1000, "Euronics");
        computer.changeStore("ONOFF");
        computer.info.changeName("Mac Pro");
        System.out.println(computer.store + " " + computer.info.name + " " + computer.cost + "€ " + computer.info.ram + " RAM");

        Computer computer2 = new Computer(new Info("Dell", 32, "Intel", "720p"), 1100, "ONOFF");
        computer2.getDiscount(200);
        computer2.info.changeRes("2k");
        computer2.info.addRam(32);
        System.out.println(computer2.store + " " + computer2.info.name + " " + computer2.cost + "€ "  + computer2.info.ram + " RAM " + computer2.info.resolution + " Resolution");
    }
}