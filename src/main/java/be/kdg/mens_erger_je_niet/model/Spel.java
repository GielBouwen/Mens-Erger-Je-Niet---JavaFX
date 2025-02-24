package be.kdg.mens_erger_je_niet.model;

import java.time.LocalDateTime;
import be.kdg.mens_erger_je_niet.Kleur;

public class Spel {
    int spelerTeller;
    LocalDateTime datum;
    private boolean beurtGroen = true;
    private boolean beurtGeel = false;
    private boolean beurtBlauw = false;
    private boolean beurtRood = false;
    private Dobbelsteen dobbelsteen;

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

    public void veranderBeurt(){ //Verandert de beurt van het spel, volgorde is groen, geel, blauw, rood
        if(beurtGroen){
            beurtGroen = false;
            beurtGeel = true;
        } else if (beurtGeel){
            beurtGeel = false;
            beurtBlauw = true;
        } else if (beurtBlauw){
            beurtBlauw = false;
            beurtRood = true;
        } else if (beurtRood){
            beurtRood = false;
            beurtGroen = true;
        }
    }

    public void speelBeurt(Kleur kleur){
        //Kijk wie zijn beurt het is, meegegeven in methode

        //Gooi dobbelsteen (done)
        //dobbelsteen.gooiDobbelsteen();
        //int worp = dobbelsteen.getAantalOgen();

        //Als de worp 6 is OF er is 1 pion op het veld: kies pion
        /*if(worp == 6 || kleur.aantalPionnenInSpel >= 1){
            kiesPion(Kleur kleur, int id)
        } */

        //zetPionOpVeld(kleur, pionID, worp) en verplaatsPion(kleur, pionID, stappen)


        //controleerOfPionEenSpelerSlaat() -> if(isBezet == true), andere pion die matcht met veldnummer moet terug naar start, isThuis op true, aantalPionnenOpVeld -1
        //controleerOfSpelerGewonnenHeeft() -> if(speler.aantalPionnenUitgespeeld == 4), speler heeft gewonnen
    }

    public void kiesPion(Kleur kleur, int id, int worp){ //Zet nieuwe pion op veld als de worp 6 is en/of verplaatst de gekozen pion met het aantal ogen
        /*if (pion.isThuis == true || worp = 6 ||){
            zetPionOpVeld(kleur, id)
        }
         */

        /*for(int i = 0, i < worp, i++){
            verplaatsPion();
        }*/
    }

    public void verplaatsPion(Kleur kleur, int id){ //Verplaatst de pion met 1 vakje
        /*
        pion.veldnummer += 1
         */
    }

    public void zetPionOpVeld(Kleur kleur, int id){  //Zet de pion op het beginvakje van de juiste kleur
        //met switch werken,
        // als het rood is vakje 0,
        // als het blauw is vakje 10,
        // als het geel is vakje 20,
        // als het groen is vakje 30
    }

    public void controleerOfPionEenSpelerSlaat(){ //Als het vakje bezet is, staat er een andere pion, kill die pion
        /*if(getVakNummer.isBezet == true){
            verwijderPion();
        }*/
    }

    public void verwijderPion(){
        //Verandert aantal pionnen op het veld met +1, pion moet naar thuisveld gestuurd worden
        //
    }
}