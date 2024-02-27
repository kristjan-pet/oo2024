import java.util.List;

public class kolmnurk {
    List<Integer> xCoords;
    List<Integer> yCoords;

    public kolmnurk(List<Integer> xCoords, List<Integer> yCoords) {
        this.xCoords = xCoords;
        this.yCoords = yCoords;
    }

    public int addCoords(int newXCoord, int newYCoord) {
        xCoords.add(newXCoord);
        yCoords.add(newYCoord);

        int summa = 0;
        for (int x: xCoords) {
            summa += x;
            //summa = summa + x;
        }
        return summa;
    }
}
