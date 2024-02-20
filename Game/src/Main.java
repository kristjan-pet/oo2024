import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
        Ese m66k = new Ese("Mõõk",10,1, random, maailm);
        Ese haamer = new Ese("Haamer",5,3, random, maailm);
        Ese saabas = new Ese("Saabas",1,5, random, maailm);
        List<Ese> esemed = new ArrayList<>();
        esemed.add(m66k);
        esemed.add(haamer);
        esemed.add(saabas);

        // import java.util.Scanner;
        Scanner scanner = new Scanner(System.in); // järgmine tund selgitame lähemalt

        maailm.prindiKaart(mangija, draakon, ork, esemed);
        String sisend = scanner.nextLine();

        mangija.liigu(sisend, maailm);

        while (!sisend.equals("end")) { // .equals --> ==    !m.equals() --> !=
            maailm.prindiKaart(mangija, draakon, ork, esemed);
            sisend = scanner.nextLine();
            mangija.liigu(sisend, maailm);
        }



    } // main (args[])

    //private static int saaKoordinaat(Random random, int kaart) {return random.nextInt(1, kaart - 1);}
} // Main ()