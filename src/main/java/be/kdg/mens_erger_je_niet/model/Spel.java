package be.kdg.mens_erger_je_niet.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.model.Pion;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;

public class Spel {

    int spelerTeller;
    LocalDateTime datum;
    private boolean beurtGroen = true;
    private boolean beurtGeel = false;
    private boolean beurtBlauw = false;
    private boolean beurtRood = false;
    private Dobbelsteen dobbelsteen;
    private int aantalBeurten = 1;
    private Speler spelerGroen;
    private Speler spelerGeel;
    private Speler spelerBlauw;
    private Speler spelerRood;
    private List<Speler> spelers = new ArrayList<>();
    private NewGameView newGameView;
    private boolean eindigSpel = false;

    public Spel(NewGameView newGameView) {
        this.newGameView = newGameView;
    }



    public void maakSpelersAan() {
        //Maakt spelers aan
        spelerGroen = new Speler(Kleur.GROEN, 1, newGameView.getVulNaamGroenIn().getText());
        spelerGeel = new Speler(Kleur.GEEL, 2, newGameView.getVulNaamGeelIn().getText());
        spelerBlauw = new Speler(Kleur.BLAUW, 3, newGameView.getVulNaamBlauwIn().getText());
        spelerRood = new Speler(Kleur.ROOD, 4, newGameView.getVulNaamRoodIn().getText());

        //Kijkt of de speler een CPU is
        spelerGroen.setCPU(newGameView.getCheckBoxGroen().isSelected());
        spelerGeel.setCPU(newGameView.getCheckBoxGeel().isSelected());
        spelerBlauw.setCPU(newGameView.getCheckBoxBlauw().isSelected());
        spelerRood.setCPU(newGameView.getCheckBoxRood().isSelected());

        //Voegt de spelers toe aan een lijst "spelers"
        spelers.add(spelerGroen);
        spelers.add(spelerGeel);
        spelers.add(spelerBlauw);
        spelers.add(spelerRood);
    }

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
            maakSpelersAan();
            do{
                speelBeurt();
                veranderBeurt();
            }
            while(!eindigSpel);
        }
    }

    public void eindigSpel(){
        if (eindigSpel){

        }
    }

    public void kiesSpelerAantal(int aantalSpelers) throws IllegalArgumentException {  //Het spel moet minstens met twee spelers worden gespeeld. Hieronder vallen zowel menselijke als computergestuurde spelers. Wanneer men geen gebruikersnaam ingeeft, zal er automatisch worden gekozen voor een computergestuurde.
        if (aantalSpelers < 2 || aantalSpelers > 4){
            throw new IllegalArgumentException("Kies tussen 2 en 4 spelers.");
        }
        this.spelerTeller=aantalSpelers;
    }

    public void veranderBeurt(){
        //Verandert de beurt van het spel
        //Volgorde is groen, geel, blauw, rood
        System.out.println("Dit is de " + aantalBeurten + "e beurt van " + getSpelerAanBeurt().getGebruikersnaam());
        if(beurtGroen){
            beurtGroen = false;
            beurtGeel = true;
            System.out.println("De beurt van groen is gedaan. De beurt is nu aan geel.");
        } else if (beurtGeel){
            beurtGeel = false;
            beurtBlauw = true;
            System.out.println("De beurt van geel is gedaan. De beurt is nu aan blauw.");
        } else if (beurtBlauw){
            beurtBlauw = false;
            beurtRood = true;
            System.out.println("De beurt van blauw is gedaan. De beurt is nu aan rood.");
        } else if (beurtRood){
            beurtRood = false;
            beurtGroen = true;
            aantalBeurten++;
            System.out.println("De beurt van Rood is gedaan. De beurt is nu aan groen.");
        }
    }

    public void speelBeurt(){
        //Kijk wie zijn beurt het is met methode getSpelerAanBeurt() (done)
        System.out.println(getSpelerAanBeurt() + " begint zijn beurt.");

        //Gooi dobbelsteen (done)
        dobbelsteen.werp();
        int worp = dobbelsteen.getAantalOgen();

        //Als de worp 6 is OF er is 1 pion op het veld: kies pion
        if(worp == 6 || getSpelerAanBeurt().aantalPionnenInSpel >= 1){
            //kiesPion(getSpelerKleur(),int id, worp);
        }

        //zetPionOpVeld(kleur, pionID, worp) en verplaatsPion(kleur, pionID, stappen)


        //controleerOfPionEenSpelerSlaat() -> if(isBezet == true), andere pion die matcht met veldnummer moet terug naar start, isThuis op true, aantalPionnenOpVeld -1
        controleerOfSpelerGewonnenHeeft(getSpelerAanBeurt()); //Done
    }

    public void kiesPion(Kleur kleur, int id, int worp){ //Zet nieuwe pion op veld als de worp 6 is en/of verplaatst de gekozen pion met het aantal ogen
        /*if (pion.isThuis == true || worp = 6){
            zetPionOpVeld(kleur, id);
        }*/
        /*for(int i = 0, i < worp, i++){
            verplaatsPion();
        }*/
    }

    public Pion zoekPion(Kleur kleur, int pionId) {
        Speler speler = getSpelerAanBeurt();
        if (speler != null) {
            for (Pion pion : speler.getPionnen()) {
                if (pion.getPionId() == pionId) {
                    return pion; // Return de pion met het juiste ID
                }
            }
        }
        return null; //Geen pion gevonden
    }

    public void verplaatsPion(Kleur kleur, int id){ //Verplaatst de pion met 1 vakje
        //Of moet methode in klasse Pion??
        //pion.veldnummer += 1
    }

    public void zetPionOpVeld(Kleur kleur, int id){  //Zet de pion op het beginvakje van de juiste kleur
        //zoekPion(getSpelerKleur(), id).plaatsOpStartpositie(rij, kolom);

        //met switch werken,
        // als het rood is vakje 0,
        // als het blauw is vakje 10,
        // als het geel is vakje 20,
        // als het groen is vakje 30
    }

    public void verwijderPion(Speler speler, Pion pion){
        //Verandert aantal pionnen op het veld met -1, pion moet naar thuisveld gestuurd worden
        /*speler.aantalPionnenInSpel -= 1;
        speler.aantalPionnenUitgespeeld += 1;
        pion.huidigVeldNummer = -1;*/
    }

    public void controleerOfPionEenSpelerSlaat(Speler speler, int id){ //Als het vakje bezet is, staat er een andere pion, kill die pion
        /*if(getVakNummer.isBezet == true){
            verwijderPion(getSpelerAanBeurt(), Pion pion);
        }*/
    }

    public void controleerOfSpelerGewonnenHeeft(Speler speler){
        if(speler.aantalPionnenUitgespeeld == 4){
            eindigSpel = true;
            eindigSpel(); //Roept methode eindigSpel op. Het spel wordt geëindigd
        }
    }

    public Speler getSpelerAanBeurt() {
        if (beurtGroen) {return spelerGroen;}
        if (beurtGeel) {return spelerGeel;}
        if (beurtBlauw) {return spelerBlauw;}
        if (beurtRood) {return spelerRood;}
        return null;
    }

    public Kleur getSpelerKleur() {
        return getSpelerAanBeurt().getKleur();
    }

    public boolean isBeurtGroen() {
        return beurtGroen;
    }

    public boolean isBeurtGeel() {
        return beurtGeel;
    }

    public boolean isBeurtBlauw() {
        return beurtBlauw;
    }

    public boolean isBeurtRood() {
        return beurtRood;
    }

    public Dobbelsteen getDobbelsteen() {
        return dobbelsteen;
    }

    public int getAantalBeurten() {
        return aantalBeurten;
    }

    public Speler getSpelerGroen() {
        return spelerGroen;
    }

    public Speler getSpelerGeel() {
        return spelerGeel;
    }

    public Speler getSpelerBlauw() {
        return spelerBlauw;
    }

    public Speler getSpelerRood() {
        return spelerRood;
    }

    public List<Speler> getSpelers() {
        return spelers;
    }

    public NewGameView getNewGameView() {
        return newGameView;
    }

    public boolean isEindigSpel() {
        return eindigSpel;
    }

    public void setSpelerTeller(int spelerTeller) {
        this.spelerTeller = spelerTeller;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public void setBeurtGroen(boolean beurtGroen) {
        this.beurtGroen = beurtGroen;
    }

    public void setBeurtGeel(boolean beurtGeel) {
        this.beurtGeel = beurtGeel;
    }

    public void setBeurtBlauw(boolean beurtBlauw) {
        this.beurtBlauw = beurtBlauw;
    }

    public void setBeurtRood(boolean beurtRood) {
        this.beurtRood = beurtRood;
    }

    public void setDobbelsteen(Dobbelsteen dobbelsteen) {
        this.dobbelsteen = dobbelsteen;
    }

    public void setAantalBeurten(int aantalBeurten) {
        this.aantalBeurten = aantalBeurten;
    }

    public void setSpelerGroen(Speler spelerGroen) {
        this.spelerGroen = spelerGroen;
    }

    public void setSpelerGeel(Speler spelerGeel) {
        this.spelerGeel = spelerGeel;
    }

    public void setSpelerBlauw(Speler spelerBlauw) {
        this.spelerBlauw = spelerBlauw;
    }

    public void setSpelerRood(Speler spelerRood) {
        this.spelerRood = spelerRood;
    }

    public void setSpelers(List<Speler> spelers) {
        this.spelers = spelers;
    }

    public void setNewGameView(NewGameView newGameView) {
        this.newGameView = newGameView;
    }

    public void setEindigSpel(boolean eindigSpel) {
        this.eindigSpel = eindigSpel;
    }
}