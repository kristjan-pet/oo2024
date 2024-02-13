import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        System.out.println(random);

        //Maailm
        Maailm maailm = new Maailm(5,10);
        System.out.println(maailm);


        //mängija
        Mangija mangija = new Mangija(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        //draakon
        Draakon draakon = new Draakon(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        //ork
        Ork ork = new Ork(random, maailm.kaardiKorgus, maailm.kaardiLaius);

        // import java.util.Scanner;
        Scanner scanner = new Scanner(System.in); // järgmine tund selgitame lähemalt

        maailm.prindiKaart(mangija, draakon, ork);
        String sisend = scanner.nextLine();

        //mängija switch

        mangija.liigu(sisend, maailm);

        // if (boolean || andbmebaasiKüsimine())
        // if (boolean && andbmebaasiKüsimine())
        while (!sisend.equals("end")) { // .equals --> ==    !m.equals() --> !=
            maailm.prindiKaart(mangija, draakon, ork);
            sisend = scanner.nextLine();
            mangija.liigu(sisend, maailm);
        }



    } // main (args[])

    //private static int saaKoordinaat(Random random, int kaart) {return random.nextInt(1, kaart - 1);}
} // Main ()