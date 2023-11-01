public class Profesor extends NastavnoOsoblje {
    static int[] dozvoljenTip = {1, 2, 3};
    private String status;

    public Profesor(String ime, String status) throws IllegalArgumentException{
        super(ime);

            if (!status.equalsIgnoreCase("Docent") &&
                    !status.equalsIgnoreCase("Vanredni") &&
                    !status.equalsIgnoreCase("Redovni"))
                throw new IllegalArgumentException("Nepoznat status profesora");

            this.status = status;
            int normaNastavnika = getNormaNAST();
            setNorma(normaNastavnika);


    }

    public Profesor(String ime) {
        super(ime);
        setNorma(getNormaNAST());
        status = "Docent";
    }

    public String toString() {
        return status + ":" + getIme();
    }

    public boolean mozeTip(int n) {
        for (int i = 0; i < dozvoljenTip.length; i++)
            if (dozvoljenTip[i] == n)
                return true;
        return false;
    }


    public int ukupnoOpterecenje() {
        int opterecenje = 0;
        Predmet[] predmeti = getPredaje();
        int brPredmeta = predmeti.length;
        for (int i = 0; i < brPredmeta; i++) {
            if (predmeti[i] == null)
                break;
            if (predmeti[i].getPredavacP() == this)
                opterecenje += predmeti[i].getFondP();
            if (predmeti[i].getPredavacV() == this)
                opterecenje += predmeti[i].getFondV();
            if (predmeti[i].getPredavacDON() == this)
                opterecenje += predmeti[i].getFondDON();
        }
        return opterecenje;
    }
}
