import java.util.Random;

public class Ese {
    String nimetus;
    double tugevus;
    int kasutuskorrad;
    boolean aktiivne;
    int xCoord;
    int yCoord;
    char symbol;

    // how to generate a contructor: parem klõps --> generate --> contructor --> vali kõik mis vaja ja vajuta generete
    public Ese(String nimetus, double tugevus, int kasutuskorrad, Random random, Maailm maailm) {
        this.nimetus = nimetus;
        this.tugevus = tugevus;
        this.kasutuskorrad = kasutuskorrad;
        this.aktiivne = true;
        xCoord = saaKoordinaat(random, maailm.kaardiLaius);
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        this.symbol = 'I';
    }

    public void hit() {
        System.out.println("Hit enemy!");
    }
    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
