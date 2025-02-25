package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

public class Pion {
    private int pionId;
    private Kleur kleur;
    int huidigVeldNummer;


    public Pion(int pionId, Kleur kleur) {
        this.pionId = pionId;
        this.kleur = kleur;
        this.huidigVeldNummer = -1;
    }

    public void beweegPion(int stappen) {

        for(int i = 0; i < stappen; i++) {
            huidigVeldNummer += 1;
            if (huidigVeldNummer >= 40) { //Als de waarde 40 of groter is, moeten we deze waarde met 40 verkleinen (gaat van groen gebied 39 naar rood gebied 0)
                huidigVeldNummer -= 40;
            }
        }
    }

    public void zetPionOpVeld(Kleur kleur) {
        //Kijken welke kleur een pion is voor startpositie

        switch(kleur){
            case ROOD -> this.huidigVeldNummer = 0; //Startlocatie ROOD is op veldnummer 0
            case BLAUW -> this.huidigVeldNummer = 10; //Startlocatie BLAUW is op veldnummer 10
            case GEEL -> this.huidigVeldNummer = 20; //Startlocatie GEEL is op veldnummer 20
            case GROEN -> this.huidigVeldNummer = 30; //Startlocatie GROEN is op veldnummer 30
        }
    }
}
