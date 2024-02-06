import java.util.Random;
import java.util.Scanner;

<<<<<<< Updated upstream
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
=======
>>>>>>> Stashed changes
public class Main {
    public static void main(String[] args) {

        Random random = new Random();

<<<<<<< Updated upstream
        int kaardiKorgus = 5;
        int kaardiLaius = 10;
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int mangijaXCoord = saaKoordinaat(random, kaardiLaius);
        int mangijaYCoord = saaKoordinaat(random, kaardiKorgus);
        char mangijaSymbol = 'x';

        int draakonXCoord = saaKoordinaat(random, kaardiLaius);
        int draakonYCoord = saaKoordinaat(random, kaardiKorgus);
        char draakonSymbol = 'D';

        int orkXCoord = saaKoordinaat(random, kaardiLaius);
        int orkYCoord = saaKoordinaat(random, kaardiKorgus);
        char orkSymbol = 'O';

        // import java.util.Scanner;
        Scanner scanner = new Scanner(System.in); // järgmine tund selgitame lähemalt

        prindiKaart(kaardiKorgus, kaardiLaius, mangijaXCoord, mangijaYCoord, mangijaSymbol, draakonXCoord, draakonYCoord, draakonSymbol, orkXCoord, orkYCoord, orkSymbol);
        String sisend = scanner.nextLine();

        switch (sisend) {
            case "w" -> mangijaYCoord--;
            case "s" -> mangijaYCoord++;
            case "a" -> mangijaXCoord--;
            case "d" -> mangijaXCoord++;
        }

//        if (sisend.equals("w")) {
//            mangijaYCoord--;
//        } else if (sisend.equals("s")) {
//            mangijaYCoord++;
//        }  else if (sisend.equals("a")) {
//            mangijaXCoord--;
//        } else if (sisend.equals("d")) {
//            mangijaXCoord++;
//        }

        // if (boolean || andbmebaasiKüsimine())
        // if (boolean && andbmebaasiKüsimine())
        while (!sisend.equals("end")) { // .equals --> ==    !m.equals() --> !=
            prindiKaart(kaardiKorgus, kaardiLaius, mangijaXCoord, mangijaYCoord, mangijaSymbol, draakonXCoord, draakonYCoord, draakonSymbol, orkXCoord, orkYCoord, orkSymbol);
            sisend = scanner.nextLine();
            switch (sisend) {
                case "w" -> mangijaYCoord--;
                case "s" -> mangijaYCoord++;
                case "a" -> mangijaXCoord--;
                case "d" -> mangijaXCoord++;
            }
        }



    } // main (args[])

    private static void prindiKaart(int kaardiKorgus, int kaardiLaius, int mangijaXCoord, int mangijaYCoord, char mangijaSymbol, int draakonXCoord, int draakonYCoord, char draakonSymbol, int orkXCoord, int orkYCoord, char orkSymbol) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol;
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    if (x == mangijaXCoord && y == mangijaYCoord) {
                        symbol = mangijaSymbol;
                    } else if (x == draakonXCoord && y == draakonYCoord) {
                        symbol = draakonSymbol;
                    } else if (x == orkXCoord && y == orkYCoord) {
                        symbol = orkSymbol;
                    } else  {
=======
        /* play area boundaries */
        int areaH = 10;
        int areaW = 25;

        // player
        int playerY = getCoord(random, areaH);
        int playerX = getCoord(random, areaW);
        char playerSymbol = 'p';

        int dragonY = getCoord(random, areaH);
        int dragonX = getCoord(random, areaW);
        char dragonSymbol = 'D';

        int orcY = getCoord(random, areaH);
        int orcX = getCoord(random, areaW);
        char orcSymbol = 'O';

        // if (boolean || andmebaasiKüsimine()) "||" = or
        // if (boolean && andmebaasiKüsimine()) "&&" = and
        // "alati on vaja hoida suuremat/mahukamat asja vasakul pool (boolean > andmebaas)"

        // scanner code
        Scanner scanner = new Scanner(System.in); // järgmine tund selgitame lähemalt (input kood)

        extracted(areaH, areaW, playerX, playerY, playerSymbol, dragonX, dragonY, dragonSymbol, orcX, orcY, orcSymbol);

        String input = scanner.nextLine();

        switch (input) {
            case "w" -> playerY--;
            case "s" -> playerY++;
            case "a" -> playerX--;
            case "d" -> playerX++;
        }

        while (!input.equals("end")) { // n.equals --> "==" and !n.equals --> "!="
            extracted(areaH, areaW, playerX, playerY, playerSymbol, dragonX, dragonY, dragonSymbol, orcX, orcY, orcSymbol);

            input = scanner.nextLine();

            switch (input) {
                case "w" -> playerY--;
                case "s" -> playerY++;
                case "a" -> playerX--;
                case "d" -> playerX++;
            }
        }

    }

    private static void extracted(int areaH, int areaW, int playerX, int playerY, char playerSymbol, int dragonX, int dragonY, char dragonSymbol, int orcX, int orcY, char orcSymbol) {
        for (int y = 0; y < areaH; y++) {
            for (int x = 0; x < areaW; x++) {
                char symbol;
                if (y == 0 || y == areaH - 1) {
                    symbol = '-';
                } else if (x == 0 || x == areaW - 1) {
                    symbol = '|';
                } else {
                    if (x == playerX && y == playerY) {
                        symbol = playerSymbol;
                    } else if (x == dragonX && y == dragonY) {
                        symbol = dragonSymbol;
                    } else if (x == orcX && y == orcY) {
                        symbol = orcSymbol;
                    }else {
>>>>>>> Stashed changes
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

<<<<<<< Updated upstream
    private static int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
} // Main ()
=======
    private static int getCoord(Random random, int area) {
        return random.nextInt(1, area - 1);
    }
}
>>>>>>> Stashed changes
