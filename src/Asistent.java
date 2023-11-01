public class Asistent extends NastavnoOsoblje{

    static int[] dozvoljenTip = {2, 3};

    public Asistent(String ime) {
        super(ime);
        setNorma(getNormaASIS());
    }

    public boolean mozeTip(int n){
        for(int i = 0; i < dozvoljenTip.length; i++)
            if(dozvoljenTip[i] ==  n)
                return true;
        return false;
    }

    public String toString(){
        return "Asistent:" + getIme();
    }

    public int ukupnoOpterecenje() {
        int opterecenje = 0;
        Predmet[] predmeti = getPredaje();
        int brPredmeta = predmeti.length;
        for(int i = 0; i< brPredmeta; i++)
        {
            if(predmeti[i] == null)
                break;
            if(predmeti[i].getPredavacV() == this)
                opterecenje += predmeti[i].getFondV();
            if(predmeti[i].getPredavacDON() == this)
                opterecenje += predmeti[i].getFondDON();
        }
        return opterecenje;
    }

}
