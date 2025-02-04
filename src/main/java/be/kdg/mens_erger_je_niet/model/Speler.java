package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

public class Speler {
    Kleur kleur;
    int spelerId;
    String gebruikersnaam;
    int aantalPionnenUitgespeeld; //Teller die bijhoudt hoeveel pionnen van een speler het einde hebben bereikt, als het 4 is, stopt het spel


    public Kleur getKleur() {
        return kleur;
    }

    public int getSpelerId() {
        return spelerId;
    }
}
