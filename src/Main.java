public class Main {
    public static void main(String[] args) {
        try {
            Profesor p = new Profesor("Aleksandar Cvetkovic", "Vanredni");
            Asistent a = new Asistent("AKM");


            Predmet predmet = new Predmet(1, "OOP - JAVA", 3, 2, 1);
            predmet.dodeliCasove(p, 1);
            predmet.dodeliCasove(a, 2);
            predmet.dodeliCasove(a, 3);


            NastavnoOsoblje nastavnici[] = new NastavnoOsoblje[2];
            nastavnici[0] = p;
            nastavnici[1] = a;

            for (int i = 0; i < nastavnici.length; i++) {
                System.out.println(nastavnici[i]);
                System.out.println(nastavnici[i].ukupnoOpterecenje());
                int norma = 0;
                if (nastavnici[i] instanceof Asistent)
                    norma = Asistent.getNormaASIS();
                if (nastavnici[i] instanceof Profesor)
                    norma = Asistent.getNormaNAST();
                double procenatOpterecenja =
                        100.0 * nastavnici[i].ukupnoOpterecenje() / norma;

                System.out.println("opterecenje = " + procenatOpterecenja + "%");
            }
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }

    }
}
