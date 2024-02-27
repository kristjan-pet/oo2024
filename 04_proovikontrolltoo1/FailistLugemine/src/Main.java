import java.io.BufferedReader;
//import java.io.FileNotFoundException; <- see on vahetatud IOException'iga
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Lugemine.txt"));
        String rida = br.readLine();
        while (rida != null) {
            System.out.println(rida);
            String[] s6nad = rida.split(" ");
            System.out.println(Arrays.toString(s6nad));
            System.out.println("Rida läbi!");

            double ruutu = Math.pow(s6nad.length, 2);
            System.out.println(ruutu);

            double ruutjuur = Math.sqrt(s6nad.length);
            System.out.println(ruutjuur);

            System.out.println();

            rida = br.readLine();
        }
    }
}