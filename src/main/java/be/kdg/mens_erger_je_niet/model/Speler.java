package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

import java.util.ArrayList;
import java.util.List;


public class Speler {
    Kleur kleur;
    int spelerId;
    String gebruikersnaam;
    boolean isCPU;
    int aantalPionnenInStart;
    int aantalPionnenInSpel;
    int aantalPionnenUitgespeeld; //als het 4 is stopt het spel
    List<Pion> pionnen;

    public Speler(Kleur kleur, int spelerId, String gebruikersnaam, boolean isCPU) {
        this.kleur = kleur;
        this.spelerId = spelerId;
        this.gebruikersnaam = gebruikersnaam;
        this.isCPU = isCPU;
        this.pionnen = new ArrayList<>();
        for(int i = 1; i <= 4; i++){
            pionnen.add(new Pion(i, kleur, this)); //this, want deze speler
        }
        aantalPionnenInStart = 4;
        aantalPionnenInSpel = 0;
        aantalPionnenUitgespeeld = 0;
    }

    public String getGebruikersnaam() {
        return this.gebruikersnaam;
    }

    public Kleur getKleur() {
        return this.kleur;
    }

    public int getSpelerId() {
        return this.spelerId;
    }

    public boolean GetIsCPU() {
        return this.isCPU;
    }

    public void setCPU(boolean isCpu) {
        this.isCPU = isCpu;
    }

    public List<Pion> getPionnen() {
        return pionnen;
    }

    public int getAantalPionnenInStart() {
        return aantalPionnenInStart;
    }

    public int getAantalPionnenInSpel() {
        return aantalPionnenInSpel;
    }

    public int getAantalPionnenUitgespeeld() {
        return aantalPionnenUitgespeeld;
    }

    public Pion getPion (int pionId){
        return pionnen.get(pionId);
    }
}