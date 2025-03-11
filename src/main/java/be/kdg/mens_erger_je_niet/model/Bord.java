package be.kdg.mens_erger_je_niet.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bord {
    private Map<Integer, Pion> pionnenOpBord = new HashMap<>();

    public Bord() {
        ArrayList<Veld> velden = new ArrayList<Veld>();
        velden.add(new Veld(8,0,0)); //Startveld Rood
        velden.add(new Veld(8,1,1));
        velden.add(new Veld(8,2,2));
        velden.add(new Veld(8,3,3));
        velden.add(new Veld(8,4,4));
        velden.add(new Veld(8,5,5));
        velden.add(new Veld(8,6,6)); //Grijs vakje in hoek rood/groen
        velden.add(new Veld(9,6,7));
        velden.add(new Veld(10,6,8));
        velden.add(new Veld(11,6,9));
        velden.add(new Veld(12,6,10));
        velden.add(new Veld(13,6,11));
        velden.add(new Veld(14,6,12));
        velden.add(new Veld(14,7,13));
        velden.add(new Veld(14,8,14)); //Startveld Groen
        velden.add(new Veld(13,8,15));
        velden.add(new Veld(12,8,16));
        velden.add(new Veld(11,8,17));
        velden.add(new Veld(10,8,18));
        velden.add(new Veld(9,8,19));
        velden.add(new Veld(8,8,20)); //Grijs vakje in hoek groen/geel
        velden.add(new Veld(8,9,21));
        velden.add(new Veld(8,10,22));
        velden.add(new Veld(8,11,23));
        velden.add(new Veld(8,12,24));
        velden.add(new Veld(8,13,25));
        velden.add(new Veld(8,14,26));
        velden.add(new Veld(7,14,27));
        velden.add(new Veld(6,14,28)); //Startveld Geel
        velden.add(new Veld(6,13,29));
        velden.add(new Veld(6,12,30));
        velden.add(new Veld(6,11,31));
        velden.add(new Veld(6,10,32));
        velden.add(new Veld(6,9,33));
        velden.add(new Veld(6,8,34)); //Grijs vakje in hoek geel/blauw
        velden.add(new Veld(5,8,35));
        velden.add(new Veld(4,8,36));
        velden.add(new Veld(3,8,37));
        velden.add(new Veld(2,8,38));
        velden.add(new Veld(1,8,39));
        velden.add(new Veld(0,8,40));
        velden.add(new Veld(0,7,41));
        velden.add(new Veld(0,6,42)); //Startveld Blauw
        velden.add(new Veld(1,6,43));
        velden.add(new Veld(2,6,44));
        velden.add(new Veld(3,6,45));
        velden.add(new Veld(4,6,46));
        velden.add(new Veld(5,6,47));
        velden.add(new Veld(6,6,48)); //Grijs vakje in hoek blauw/rood
        velden.add(new Veld(6,5,49));
        velden.add(new Veld(6,4,50));
        velden.add(new Veld(6,3,51));
        velden.add(new Veld(6,2,52));
        velden.add(new Veld(6,1,53));
        velden.add(new Veld(6,0,54));
        velden.add(new Veld(7,0,55));
    }


    public boolean zetPionOpBord(Pion pion, int rij, int kolom) {
        if (isBezet(rij, kolom)) {
            System.out.println("Deze plek is bezet");
            return false;
        }
        pion.plaatsOpStartpositie(rij, kolom);
        pionnenOpBord.put(pion.getPionId(), pion);
        return true;
    }

    private boolean isBezet(int rij, int kolom) {
        for (Pion p : pionnenOpBord.values()) { // checkt of de pion op de opgegeven rij en kolom staat
            if (p.getRij() == rij && p.getKolom() == kolom) {
                return true;
            }
        }
        return false;
    }

    public Map<Integer, Pion> getPionnenOpBord() {
        return pionnenOpBord;
    }
}


