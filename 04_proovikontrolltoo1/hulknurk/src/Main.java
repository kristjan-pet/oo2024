import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> kolmnurk1xCoords = new ArrayList<>();
        kolmnurk1xCoords.add(6);
        kolmnurk1xCoords.add(8);
        kolmnurk1xCoords.add(10);

        List<Integer> kolmnurk1yCoords = new ArrayList<>();
        kolmnurk1yCoords.add(2);
        kolmnurk1yCoords.add(5);
        kolmnurk1yCoords.add(1);

        kolmnurk kolmnurk1 = new kolmnurk(kolmnurk1xCoords, kolmnurk1yCoords);

        System.out.println(kolmnurk1.xCoords);
        System.out.println(kolmnurk1.yCoords);

        int summa = kolmnurk1.addCoords(5,10);
        System.out.println(summa);
    }
}