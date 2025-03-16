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

    public Pion(int pionId, Kleur kleur, Speler eigenaar) {
        this.pionId = pionId;
        this.kleur = kleur;
        this.kolom = -1;
        this.rij = -1;
        this.isOpBord = false;
        this.aantalVakjesVer = -1;
        this.eigenaar = eigenaar;
    }

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
        //reset het naar het begin als het 56 of hoger is
        this.veldNummer = veldNummer;
        if (this.veldNummer >= 56) {
            this.veldNummer -= 56;
        }
    }

    public void setGefinished(boolean gefinished) {
        isGefinished = gefinished;
    }

    public Speler getEigenaar() {
        return eigenaar;
    }

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

}