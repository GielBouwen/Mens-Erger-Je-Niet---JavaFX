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

    public Speler(Kleur kleur, int spelerId, String gebruikersnaam, boolean isCPU) {
        this.kleur = kleur;
        this.spelerId = spelerId;
        this.gebruikersnaam = gebruikersnaam;
        this.isCPU = false;
        this.pionnen = new ArrayList<>();
        for(int i = 1; i <= 4; i++){ //Vult arraylist
            pionnen.add(new Pion(i, kleur, this));
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

    public Pion getPion(Speler speler, int pionId) {
        if(pionId < 1 || pionId > 4){ //Speler kan maar tussen 4 pionnen kiezen
            throw new IllegalArgumentException("Geef een getal tussen 1 en 4.");
        }
        if(speler.pionnen.get(pionId).isGefinished()){ //Speler kan alleen maar pionnen kiezen die niet gefinished zijn
            throw new IllegalArgumentException("Deze pion is al gefinished.");
        }
        pionId -= 1; //Als speler Pion "1" ingeeft, wordt er in de array gezocht naar het 0e element om overeen te komen
        return speler.pionnen.get(pionId);
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
}
