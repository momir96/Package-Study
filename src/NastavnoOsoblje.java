public abstract class NastavnoOsoblje implements  UkupnoOpterecenje{

    private static final int normaNAST = 12;
    private static final int normaASIS = 20;
    private String ime;
    private int norma;
    private Predmet[] predaje = new Predmet[7];


    public int dodaliPredmet(Predmet p){
        for(int i = 0; i<predaje.length; i++) {
            if (predaje[i] == p)
                return -1;
        }
        for(int i = 0; i<predaje.length; i++) {
            if(predaje[i] == null) {
                predaje[i] = p;
                return 1;
            }
        }
        return -1;

    }
    public boolean oduzmiPredmet(Predmet p){
        for(int i =0; i<predaje.length; i++)
            if(predaje[i].getId() == p.getId())
            {
                predaje[i] = null;
                return true;
            }
        return false;
    }

    public NastavnoOsoblje(String ime) {
        this.ime = ime;
    }

    public static int getNormaNAST() {
        return normaNAST;
    }

    public static int getNormaASIS() {
        return normaASIS;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getNorma() {
        return norma;
    }

    public void setNorma(int norma) {
        this.norma = norma;
    }

    public Predmet[] getPredaje() {
        return predaje;
    }

    public void setPredaje(Predmet[] predaje) {
        this.predaje = predaje;
    }

    public abstract boolean mozeTip(int n);

    @Override
    public String toString() {
        return ime;
    }


}
