public class Info {
    String name;
    int ram;
    String graphicsCard;
    String resolution;

    public Info(String name, int ram, String graphicsCard, String resolution) {
        this.name = name;
        this.ram = ram;
        this.graphicsCard = graphicsCard;
        this.resolution = resolution;
    }

    public void changeName(String newName) {
        name = newName;
    }

    public void changeRes(String newRes) {
        resolution = newRes;
    }

    public int addRam(int addRam) {
        ram = ram + addRam;
        return ram;
    }
}
