public class Sipher {
    public static String muudaLause(String lause, int nihke) {
        StringBuilder tulemus = new StringBuilder();
        for (int i = 0; i < lause.length(); i++) {
            char t9ht = lause.charAt(i);
            if (Character.isLetter(t9ht)) {
                char algust9ht = Character.isLowerCase(t9ht) ? 'a' : 'A';
                tulemus.append((char) ((t9ht - algust9ht + nihke) % 26 + algust9ht));
            } else {
                tulemus.append(t9ht);
            }
        }
        return tulemus.toString();
    }

    public static String desipherLause(String kooditudLause, int nihke) {
        StringBuilder tulemus = new StringBuilder();
        for (int i = 0; i < kooditudLause.length(); i++) {
            char t9ht = kooditudLause.charAt(i);
            if (Character.isLetter(t9ht)) {
                char algust9ht = Character.isLowerCase(t9ht) ? 'a' : 'A';
                tulemus.append((char) ((t9ht - algust9ht - nihke + 26) % 26 + algust9ht));
            } else {
                tulemus.append(t9ht);
            }
        }
        return tulemus.toString();
    }
}
