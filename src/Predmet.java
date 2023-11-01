public class Predmet {

    private int id, fondP, fondV, fondDON;
    private String naziv;
    private Profesor predavacP;
    private NastavnoOsoblje predavacV, predavacDON;

    public Predmet(int id, String naziv, int fondP, int fondV, int fondDON) {
        this.id = id;
        this.fondP = fondP;
        this.fondV = fondV;
        this.fondDON = fondDON;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFondP() {
        return fondP;
    }

    public void setFondP(int fondP) {
        this.fondP = fondP;
    }

    public int getFondV() {
        return fondV;
    }

    public void setFondV(int fondV) {
        this.fondV = fondV;
    }

    public int getFondDON() {
        return fondDON;
    }

    public void setFondDON(int fondDON) {
        this.fondDON = fondDON;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Profesor getPredavacP() {
        return predavacP;
    }

    public NastavnoOsoblje getPredavacV() {
        return predavacV;
    }

    public NastavnoOsoblje getPredavacDON() {
        return predavacDON;
    }

    public int angazovanje (NastavnoOsoblje nastavnik){
        int brCasova = 0;

        if (nastavnik == predavacP)
            brCasova += fondP;
        if (nastavnik == predavacV)
            brCasova += fondV;
        if(nastavnik == predavacDON)
            brCasova += fondDON;

        return brCasova;
    }

    public void dodeliCasove(NastavnoOsoblje nastavnik, int opcija){
        // proveravamo da li nastavnik moze da drzi ovaj tip nastave
        if (nastavnik.mozeTip(opcija) == false)
            return;

        if(opcija == 1 &&
                nastavnik.ukupnoOpterecenje()+fondP <= NastavnoOsoblje.getNormaNAST()
        &&
                predavacP == null
        ) {
            predavacP = (Profesor) nastavnik;
            nastavnik.dodaliPredmet(this);
        }

        if(opcija == 2
                &&
                nastavnik instanceof Profesor
                &&
                nastavnik.ukupnoOpterecenje()+fondV <= NastavnoOsoblje.getNormaNAST()
        &&
        predavacV == null){
            predavacV = nastavnik;
            nastavnik.dodaliPredmet(this);

        }

        if(opcija == 2
                &&
                nastavnik instanceof Asistent
                &&
                nastavnik.ukupnoOpterecenje()+fondV <= NastavnoOsoblje.getNormaASIS()
                &&
                predavacV == null){
            predavacV = nastavnik;
            nastavnik.dodaliPredmet(this);

        }
        if(opcija == 3
                &&
                nastavnik instanceof Profesor
                &&
                nastavnik.ukupnoOpterecenje()+fondDON<= NastavnoOsoblje.getNormaNAST()
                &&
                predavacDON == null){
            predavacDON = nastavnik;
            nastavnik.dodaliPredmet(this);

        }

        if(opcija == 3
                &&
                nastavnik instanceof Asistent
                &&
                nastavnik.ukupnoOpterecenje()+fondDON <= NastavnoOsoblje.getNormaASIS()
                &&
                predavacDON == null){
            predavacDON = nastavnik;
            nastavnik.dodaliPredmet(this);
        }

    }

    public void oduzmiCasove(NastavnoOsoblje nastavnik, int opcija){
        if (nastavnik.mozeTip(opcija) == false)
            return;
        int brTipovaNastave = 0;
        if(nastavnik == predavacP) {
            predavacP = null;
            brTipovaNastave++;
        }
        if(nastavnik == predavacV){
            predavacV = null;
            brTipovaNastave++;
        }
        if(nastavnik == predavacDON){
            predavacDON = null;
            brTipovaNastave++;
        }
        if(brTipovaNastave == 1)
            nastavnik.oduzmiPredmet(this);


    }
}
