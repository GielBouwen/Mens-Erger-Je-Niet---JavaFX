package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bord {
    private List<Veld> gewoneVelden = new ArrayList<>();
    private List<Veld> eindVeldenRood = new ArrayList<>();
    private List<Veld> eindVeldenGroen = new ArrayList<>();
    private List<Veld> eindVeldenGeel = new ArrayList<>();
    private List<Veld> eindVeldenBlauw = new ArrayList<>();
    private List<Veld> parkeerVeldenRood = new ArrayList<>();
    private List<Veld> parkeerVeldenGroen = new ArrayList<>();
    private List<Veld> parkeerVeldenGeel = new ArrayList<>();
    private List<Veld> parkeerVeldenBlauw = new ArrayList<>();
    private Map<Integer, Pion> pionnenOpBord = new HashMap<>();
    private Map<Integer, Pion> velden = new HashMap<>();


    private Veld[][] bord = new Veld[15][15]; //2D-array bord

    public Bord() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                bord[i][j] = new Veld(i, j, i * 15 + j, null);
            }
        }

        // Initialiseer gewone velden, parkeer velden, eind velden enz.
    }

    public void updatePionPosition(Pion pion, int nieuwePositie) {
        //bereken positie
        int row = nieuwePositie / 15;
        int col = nieuwePositie % 15;
        //verwijder pion van huidige plaats en uit de velden map
        velden.remove(pion.getVeldNummer());

        bord[row][col].setPion(pion);
        //verander positi pion en voeg toe aan velden map
        pion.setAantalVakjesVer(nieuwePositie);
        velden.put(nieuwePositie, pion);
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
        for (Pion p : pionnenOpBord.values()) { //checkt of de pion op de opgegeven rij en kolom staat
            if (p.getRij() == rij && p.getKolom() == kolom) {
                return true;
            }
        }
        return false;
    }

    public Map<Integer, Pion> getPionnenOpBord() {
        return pionnenOpBord;
    }

    public void verplaatsPion(Pion pion, int dobbelsteenWorp) {
        int huidigePositie = pion.getVeldNummer();
        int nieuwePositie = berekenNieuwePositie(pion, dobbelsteenWorp);

        pion.setAantalVakjesVer(pion.getAantalVakjesVer() + dobbelsteenWorp); //verander aantal vakjes

        Pion bestaandePion = velden.get(nieuwePositie); //kijkt na of veld bezet is
        if (bestaandePion != null) {
            System.out.println("Pion " + bestaandePion.getKleur() + " van " + bestaandePion.getEigenaar().getGebruikersnaam() + " wordt geslagen!");
            bestaandePion.setAantalVakjesVer(-1); //zet geslagen pion op start
            velden.remove(nieuwePositie);
        }

        velden.remove(huidigePositie); //pion weg van huidige plek
        pion.setAantalVakjesVer(nieuwePositie); //update pionpositie
        velden.put(nieuwePositie, pion); //pion op nieuwe plek.

        System.out.println("Pion " + pion.getKleur() + " van " + pion.getEigenaar().getGebruikersnaam() + " staat nu op veld " + nieuwePositie);
    }


    public int berekenNieuwePositie(Pion pion, int dobbelSteenWorp) {
        int huidigePositie = pion.getVeldNummer();
        return huidigePositie + dobbelSteenWorp;
    }

    public List<Veld> getParkeerVeldenRood() {
        return parkeerVeldenRood;
    }

    public List<Veld> getParkeerVeldenGroen() {
        return parkeerVeldenGroen;
    }

    public List<Veld> getParkeerVeldenGeel() {
        return parkeerVeldenGeel;
    }

    public List<Veld> getParkeerVeldenBlauw() {
        return parkeerVeldenBlauw;
    }

    public Veld getParkeerVeldRood(int index) {
        return parkeerVeldenRood.get(index);
    }

    public Veld getParkeerVeldGroen(int index) {
        return parkeerVeldenGroen.get(index);
    }

    public Veld getParkeerVeldGeel(int index) {
        return parkeerVeldenGeel.get(index);
    }

    public Veld getParkeerVeldBlauw(int index) {
        return parkeerVeldenBlauw.get(index);
    }

    public Veld getVeld(int rij, int kolom) {
        return bord[rij][kolom];
    }

    public void plaatsPionOpStartPositie(Pion pion) {
        int startPositie = bepaalStartPositie(pion);

        pion.setVeldNummer(startPositie); //pion op startpos.

        pionnenOpBord.put(pion.getPionId(), pion); //voeg pionnen toe op bord.

        System.out.println("Pion " + pion.getKleur() + " van speler " + pion.getEigenaar().getGebruikersnaam() + " is geplaatst op startpositie: " + startPositie);
    }

    private int bepaalStartPositie(Pion pion) {
        if (pion.getKleur() == Kleur.ROOD) {
            return 1;  //start rood
        } else if (pion.getKleur() == Kleur.GROEN) {
            return 10;  //start groen
        } else if (pion.getKleur() == Kleur.BLAUW) {
            return 20;  //start blauw
        } else if (pion.getKleur() == Kleur.GEEL) {
            return 30;  //start geel
        }
        return 0;
    }
}


