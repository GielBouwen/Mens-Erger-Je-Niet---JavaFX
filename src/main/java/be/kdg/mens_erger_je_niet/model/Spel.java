package be.kdg.mens_erger_je_niet.model;

import java.time.LocalDateTime;

public class Spel {
    int spelerTeller;
    LocalDateTime datum;

    public int getSpelerTeller() {
        return spelerTeller;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void pauzeerSpel(boolean pauzeerSpel){
        if (pauzeerSpel){
            //Game wordt opgeslagen (er wordt als het ware een soort van snapshot gemaakt) en vervolgens gesloten. Je kan het na het sluiten terug herstarten.
        }
    }

    public void startSpel(boolean startSpel){
        if (startSpel){

        }
    }
    public void kiesSpelerAantal(int aantalSpelers) throws IllegalArgumentException {  //Het spel moet minstens met twee spelers worden gespeeld. Hieronder vallen zowel menselijke als computergestuurde spelers. Wanneer men geen gebruikersnaam ingeeft, zal er automatisch worden gekozen voor een computergestuurde.
        if (aantalSpelers < 2 || aantalSpelers > 4){
            throw new IllegalArgumentException("Kies tussen 2 en 4 spelers.");
        }
        this.spelerTeller=aantalSpelers;
    }

    public void eindigSpel(boolean eindigSpel){
        if (eindigSpel){

        }

    }
}