package be.kdg.mens_erger_je_niet.model;

import java.util.HashMap;
import java.util.Map;

public class Bord {
    private Map<Integer, Pion> pionnenOpBord = new HashMap<>();

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
        for (Pion p : pionnenOpBord.values()) {
            if (p.getRij() == rij && p.getKolom() == kolom) {   // checkt of de pion op de opgegeven rij en kolom staat
                return true;
            }
        }
        return false;
    }

    public boolean verplaatsPion(Pion pion, int newRij, int newKolom) {
        if (!pion.isOpBord()) {
            System.out.println("De pion moet nog op het bord worden gezet");
            return false;
        }
        if (isBezet(newRij, newKolom)) {
            System.out.println("Plek is al bezet. ");
            return false;
        }
        pion.move(newRij, newKolom);
        return true;
    }



}