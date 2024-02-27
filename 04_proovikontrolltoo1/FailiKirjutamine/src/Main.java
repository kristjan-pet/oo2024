import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("väljund.txt"));
        pw.print("Elas");
        pw.print(" ");
        pw.print("metsas");
        pw.print(" ");
        pw.println("mutionu");
        pw.println("keset kuuski noori vanu");
        pw.println("eluruum tal sügaval");
        pw.close();
    }
}