import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        
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
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static int getCoord(Random random, int area) {
        return random.nextInt(1, area - 1);
    }
}
