package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

public class Pion {
    private int pionId;
    private Kleur kleur;
    private int kolom;
    private int rij;
    private boolean isOpBord;
    private int aantalVakjesVer;
    private int veldNummer;
    private boolean isGefinished;
    private Speler eigenaar;

    // Constructor
    public Pion(int pionId, Kleur kleur, Speler eigenaar) {
        this.pionId = pionId;
        this.kleur = kleur;
        this.kolom = -1;  // Pion staat nog niet op het bord
        this.rij = -1;    // Pion staat nog niet op het bord
        this.isOpBord = false; // Pion is nog niet op het bord
        this.aantalVakjesVer = -1; // Pion is nog niet in het spel
        this.eigenaar = eigenaar;
    }

    // Getters en Setters
    public int getPionId() {
        return pionId;
    }

    public Kleur getKleur() {
        return kleur;
    }

    public int getKolom() {
        return kolom;
    }

    public int getRij() {
        return rij;
    }

    public boolean isOpBord() {
        return isOpBord;
    }

    public boolean isGefinished() {
        return isGefinished;
    }

    public int getAantalVakjesVer() {
        return aantalVakjesVer;
    }

    public void setAantalVakjesVer(int aantalVakjesVer) {
        this.aantalVakjesVer = aantalVakjesVer;
    }

    public int getVeldNummer() {
        return veldNummer;
    }

    public void setVeldNummer(int veldNummer) {
        this.veldNummer = veldNummer;
        if (this.veldNummer >= 56) {
            this.veldNummer -= 56;  // Loop back to start when finish line is passed
        }
    }

    public void setGefinished(boolean gefinished) {
        isGefinished = gefinished;
    }

    public Speler getEigenaar() {
        return eigenaar;
    }

    // Methode voor het plaatsen van de pion op het bord
    public void plaatsOpStartpositie(int startRij, int startKolom) {
        this.rij = startRij;
        this.kolom = startKolom;
        this.isOpBord = true;
        this.aantalVakjesVer = 0;
    }

    public boolean move(int nieuweRij, int nieuweKolom) {
        if (!isOpBord) {
            return false;
        }
        this.rij = nieuweRij;
        this.kolom = nieuweKolom;
        return true;
    }


    // Aangepaste toString() methode voor een leesbare weergave van de pion
    @Override
    public String toString() {
        return "Pion " + pionId + " (" + kleur + ")"; // Geeft een leesbare string terug
    }
}