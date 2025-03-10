package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

public class Pion {
    private int pionId;
    private Kleur kleur;
    private int kolom;
    private int rij;
    private boolean isOpBord;


    public Pion(int pionId, Kleur kleur) {
        this.pionId = pionId;
        this.kleur = kleur;
        this.kolom = -1;
        this.rij = -1 ;
        this.isOpBord = false; //zien ofdat de pion op het bord staat (mag pas op het bord staan als er 6 wordt gegooid)
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

    public void plaatsOpStartpositie(int startRij, int startKolom) {
        this.rij = startRij;
        this.kolom = startKolom;
        this.isOpBord = true;
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
