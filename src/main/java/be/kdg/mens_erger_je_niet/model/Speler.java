package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;

import java.util.ArrayList;
import java.util.List;


public class Speler {
    Kleur kleur;
    int spelerId;
    String gebruikersnaam;
    int aantalPionnenInStart;
    int aantalPionnenInSpel;
    int aantalPionnenUitgespeeld; //Teller die bijhoudt hoeveel pionnen van een speler het einde hebben bereikt, als het 4 is, stopt het spel
    NewGameView newGameView;
    private List<Pion> pionnen;

    Speler spelerGroen;
    Speler spelerGeel;
    Speler spelerBlauw;
    Speler spelerRood;

    public Speler(Kleur kleur, int spelerId, String gebruikersnaam) {
        this.kleur = kleur;
        this.spelerId = spelerId;
        this.gebruikersnaam = gebruikersnaam;
        this.pionnen = new ArrayList<>();
        for(int i = 1; i <= 4; i++){ //Vult arraylist
            pionnen.add(new Pion(i, kleur));
        }
        aantalPionnenInStart = 4;
        aantalPionnenInSpel = 0;
        aantalPionnenUitgespeeld = 0;
    }

    public void maakSpelersAan() {
        spelerGroen = new Speler(Kleur.GROEN, 1, newGameView.getVulNaamGroenIn().getText());
        spelerGeel = new Speler(Kleur.GEEL, 2, newGameView.getVulNaamGeelIn().getText());
        spelerBlauw = new Speler(Kleur.BLAUW, 3, newGameView.getVulNaamBlauwIn().getText());
        spelerRood = new Speler(Kleur.ROOD, 4, newGameView.getVulNaamRoodIn().getText());
    }

    public String printSpelersInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(spelerGroen.toString());
        stringBuilder.append(spelerGeel.toString());
        stringBuilder.append(spelerBlauw.toString());
        stringBuilder.append(spelerRood.toString());
        return stringBuilder.toString();
    }

    public Kleur getKleur() {
        return kleur;
    }

    public int getSpelerId() {
        return spelerId;
    }
}
