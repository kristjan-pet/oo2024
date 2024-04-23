import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int nihke = 3;

        //kirjutab faili sisse vajalikud andmed krüpteerimisek
        PrintWriter pw = new PrintWriter(new FileWriter("sipher.txt"));
        pw.println(nihke);
        pw.println("abcz");
        pw.println("hello world");
        pw.print("test");
        pw.close();
        //------------

        //loeb failist vajalikud andmed
        BufferedReader br = new BufferedReader(new FileReader("sipher.txt"));
        //krüpteerib need andmed uue faili sisse
        PrintWriter pw2 = new PrintWriter(new FileWriter("sipheredText.txt"));

        //loeb esimese rea niheks, millega ta pärast krüpteerib
        String rida = br.readLine();
        System.out.println(rida);
        int newNihke = Integer.parseInt(rida);
        rida = br.readLine();
        String siphered;

        // loeb esimesest failist ja krüpteerib teisse
        while (rida != null) {
            System.out.println(rida); //prindib krüpteerimata rea
            siphered = Sipher.muudaLause(rida, newNihke);
            rida = br.readLine();
            pw2.println(siphered);
        }
        pw2.close();
        //-------------

        System.out.println();

        //kontrolliks teeb uue faili kuhu dekrüpteerib teise faili andmed
        BufferedReader br2 = new BufferedReader(new FileReader("sipheredText.txt"));
        PrintWriter pw3 = new PrintWriter(new FileWriter("desiphered.txt"));
        String rida2 = br2.readLine();
        String desiphered;

        // loeb teisest failist ja dekrüpeerib olemas oleva nihke abil tagasi kolmandasse faili
        while (rida2 != null) {
            System.out.println(rida2); //prindib krüpteeritud rea
            desiphered = Sipher.desipherLause(rida2, newNihke);
            rida2 = br2.readLine();
            pw3.println(desiphered);
        }
        pw3.close();
    }
}