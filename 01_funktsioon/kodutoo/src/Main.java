public class Main {
    public static void main(String[] args) {
        //KODUS: 3 funktsiooni, milles on kasutatud vähemalt
        // nelja erinevat tüüpi
        // void, String, int, char, long, double, float, boolean
        //tagastab int   parameetriks boolean
        //tagastab void  parameetriks boolean, int
        //tagastab String parameetriks String
        
        // teha igast funktioonist 2 erineva sisendiga väljakutset
        
        double kogumaksumus1 = arvutaTaksoMaksumus(3);
        System.out.println(kogumaksumus1);
        double kogumaksumus2 = arvutaTaksoMaksumus(6);
        System.out.println(kogumaksumus2);
        String temp1 = temperatuuriHinnang(4);
        System.out.println(temp1);
        prindiForTsükkel("Lsahf");
        prindiForTsükkel("safnjakjwww");
        
    }    
    private static double arvutaTaksoMaksumus(int tunnid) {
        return 3+ 0.9*tunnid;
    }

    private static String temperatuuriHinnang(int temp) {
        if (temp < 0) {
            return "Vesi on jääs";
        } else {
            return "On vesi";
        }
    }

    private static void prindiForTsükkel(String tähtedeArv) {
        for (int i = 0; i < tähtedeArv.length(); i++) {
            System.out.println(i);
        }
    }
}