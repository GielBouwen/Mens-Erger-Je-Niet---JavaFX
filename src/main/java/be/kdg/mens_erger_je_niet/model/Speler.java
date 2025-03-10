package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;

import java.util.ArrayList;
import java.util.List;


public class Speler {
    Kleur kleur;
    int spelerId;
    String gebruikersnaam;
    boolean isCPU;
    int aantalPionnenInStart;
    int aantalPionnenInSpel;
    int aantalPionnenUitgespeeld; //Teller die bijhoudt hoeveel pionnen van een speler het einde hebben bereikt, als het 4 is, stopt het spel
    List<Pion> pionnen;

    public Speler(Kleur kleur, int spelerId, String gebruikersnaam) {
        this.kleur = kleur;
        this.spelerId = spelerId;
        this.gebruikersnaam = gebruikersnaam;
        this.isCPU = false;
        this.pionnen = new ArrayList<>();
        for(int i = 1; i <= 4; i++){ //Vult arraylist
            pionnen.add(new Pion(i, kleur));
        }
        aantalPionnenInStart = 4;
        aantalPionnenInSpel = 0;
        aantalPionnenUitgespeeld = 0;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public Kleur getKleur() {
        return kleur;
    }

    public int getSpelerId() {
        return spelerId;
    }

    public boolean isCPU() {
        return isCPU;
    }

    public void setCPU(boolean CPU) {
        isCPU = CPU;
    }

    public List<Pion> getPionnen() {
        return pionnen;
    }
}
