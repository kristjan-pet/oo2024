import java.util.ArrayList;
import java.util.List;

public class Triangle {
    List<Double> xCoord = new ArrayList<>();
    List<Double> yCoord = new ArrayList<>();

    public void addCoords(double x, double y) {
        xCoord.add(x);
        yCoord.add(y);
    }

    public void printOutCoords(List<Double> xCoord, List<Double> yCoord) {
        for (int i = 0; i < xCoord.size(); i++) {
            System.out.print(xCoord.get(i));
            System.out.print(yCoord.get(i));
        }
    }
}
