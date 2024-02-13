import java.util.Random;

public class Mangija {
    int xCoord;
    int yCoord;
    char Symbol;
    Suund suund;

    public Mangija(Random random, int kaardiKorgus, int kaardiLaius) {
        xCoord = saaKoordinaat(random, kaardiLaius);
        yCoord = saaKoordinaat(random, kaardiKorgus);
        Symbol = 'x';
        suund = Suund.YLES;
    }

    public void liigu(String sisend, Maailm maailm) {
        switch (sisend) {
            case "w" -> suund = Suund.YLES;
            case "s" -> suund = Suund.ALLA;
            case "a" -> suund = Suund.VASAKULE;
            case "d" -> suund = Suund.PAREMALE;
        }
        switch (suund) {
            case YLES -> {
                if (yCoord > 1) yCoord--;
            }
            case ALLA -> {
                if (yCoord < maailm.kaardiKorgus - 1) yCoord++;
            }
            case VASAKULE -> {
                if (xCoord > 1) xCoord--;
            }
            case PAREMALE -> {
                if (xCoord < maailm.kaardiLaius - 1) xCoord++;
            }
        }
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
