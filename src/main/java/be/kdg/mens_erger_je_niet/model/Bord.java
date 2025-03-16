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

    // Gebruik een 2D-array voor het bord
    private Veld[][] bord = new Veld[15][15]; // Aanpassen afhankelijk van je bordgrootte

    public Bord() {
        // Initialiseer velden en bord
        // Voeg velden toe aan de arrays, bijvoorbeeld:
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                bord[i][j] = new Veld(i, j, i * 15 + j, null); // Veld initialisatie (pas aan naar jouw bordregels)
            }
        }

        // Initialiseer gewone velden, parkeer velden, eind velden enz.
        // Dit kun je doen op basis van de specificaties van je bord
    }

    public void updatePionPosition(Pion pion, int nieuwePositie) {
        int row = nieuwePositie / 15;  // Bereken de rij op basis van de positie
        int col = nieuwePositie % 15;  // Bereken de kolom op basis van de positie

        // Verwijder de pion van de huidige plaats
        velden.remove(pion.getVeldNummer());  // Verwijder de pion uit de velden map

        // Zet de pion op de nieuwe positie
        bord[row][col].setPion(pion);  // Dit werkt omdat we het bord als een 2D-array hebben

        // Zet de pion in de velden map met de nieuwe positie
        pion.setAantalVakjesVer(nieuwePositie); // Verander het veldnummer van de pion
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

    public void verplaatsPion(Pion pion, int dobbelsteenWorp) {
        int huidigePositie = pion.getVeldNummer();
        int nieuwePositie = berekenNieuwePositie(pion, dobbelsteenWorp);

        pion.setAantalVakjesVer(pion.getAantalVakjesVer() + dobbelsteenWorp); // Verandert het aantal vakjes van de pion.

        Pion bestaandePion = velden.get(nieuwePositie); // Haalt de pion die al staat op de locatie waar de huidige pion naartoe gaat.
        if (bestaandePion != null) { // Als de nieuwe positie bezet is, wordt er geslagen.
            System.out.println("Pion " + bestaandePion.getKleur() + " van " + bestaandePion.getEigenaar().getGebruikersnaam() + " wordt geslagen!");
            bestaandePion.setAantalVakjesVer(-1); // Zet geslagen pion naar start
            velden.remove(nieuwePositie); // Haalt pion weg uit de hashmap
        }

        velden.remove(huidigePositie); // Haalt pion weg van de huidige positie
        pion.setAantalVakjesVer(nieuwePositie); // Verplaatst de pion naar de nieuwe positie
        velden.put(nieuwePositie, pion); // Plaatst de pion terug in de map met de nieuwe positie

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

    // Functie om de pion op de startpositie te plaatsen
    public void plaatsPionOpStartPositie(Pion pion) {
        // Hier bepalen we de startpositie voor de pion op basis van zijn kleur of speler
        // Dit is een vereenvoudigde versie, je kunt de startpositie aanpassen afhankelijk van de regels
        int startPositie = bepaalStartPositie(pion);

        // Zet de pion op de startpositie
        pion.setVeldNummer(startPositie);

        // Voeg de pion toe aan de lijst van pionnen op het bord
        pionnenOpBord.put(pion.getPionId(), pion);

        System.out.println("Pion " + pion.getKleur() + " van speler " + pion.getEigenaar().getGebruikersnaam() + " is geplaatst op startpositie: " + startPositie);
    }

    // Functie om te bepalen op welke startpositie de pion moet beginnen (afhankelijk van de kleur of speler)
    private int bepaalStartPositie(Pion pion) {
        // Stel voor dat elke speler een andere startpositie heeft op het bord
        if (pion.getKleur() == Kleur.ROOD) {
            return 1;  // Startpositie voor rood
        } else if (pion.getKleur() == Kleur.GROEN) {
            return 10;  // Startpositie voor groen
        } else if (pion.getKleur() == Kleur.BLAUW) {
            return 20;  // Startpositie voor blauw
        } else if (pion.getKleur() == Kleur.GEEL) {
            return 30;  // Startpositie voor geel
        }

        // Defaultwaarde als er een onbekende kleur is
        return 0;
    }
}


