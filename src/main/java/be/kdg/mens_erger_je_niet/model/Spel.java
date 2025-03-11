package be.kdg.mens_erger_je_niet.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.model.Pion;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;

public class Spel {
    private int aantalSpelers;
    private int beurtIndex; //houdt bij wie er aan de beurt is.
    private Dobbelsteen dobbelsteen;
    private int aantalBeurten = 1; //
    private Speler huidigeSpeler;
    private List<Speler> spelers = new ArrayList<>();
    private NewGameView newGameView;
    private boolean eindigSpel = false;
    private Bord bord;

    public Spel(NewGameView newGameView) {
        this.newGameView = newGameView;
    }

    public void maakSpelersAan() {
        //Maakt spelers aan
        int index = 0;
        if(newGameView.getVulNaamGroenIn() != null){
            index++;
            spelers.add(new Speler(Kleur.GROEN, index, newGameView.getVulNaamGroenIn().getText(), newGameView.getCheckBoxGroen().isSelected()));
        }
        if(newGameView.getVulNaamGeelIn() != null){
            index++;
            spelers.add(new Speler(Kleur.GEEL, index, newGameView.getVulNaamGeelIn().getText(), newGameView.getCheckBoxGeel().isSelected()));
        }
        if(newGameView.getVulNaamBlauwIn() != null){
            index++;
            spelers.add(new Speler(Kleur.BLAUW, index, newGameView.getVulNaamBlauwIn().getText(), newGameView.getCheckBoxBlauw().isSelected()));
        }
        if(newGameView.getVulNaamRoodIn() != null){
            index++;
            spelers.add(new Speler(Kleur.ROOD, index, newGameView.getVulNaamRoodIn().getText(), newGameView.getCheckBoxRood().isSelected()));
        }
        huidigeSpeler = spelers.get(beurtIndex);
        if(index <= 1){
            throw new IllegalArgumentException("Vul de velden in voor minstens 2 kleuren");
        }
    }




    public void pauzeerSpel(boolean pauzeerSpel){
        if (pauzeerSpel){
            //Game wordt opgeslagen (er wordt als het ware een soort van snapshot gemaakt) en vervolgens gesloten. Je kan het na het sluiten terug herstarten.
        }
    }

    public void startSpel() {
        maakSpelersAan();
        zetPionnenOpParkeerplaats();
        while (!eindigSpel) {
            speelBeurt();
            veranderBeurt();
        }
    }

    private void zetPionnenOpParkeerplaats() {
    }

    public void eindigSpel(){
        eindigSpel = true;
    }

    public void veranderBeurt() {
        beurtIndex = (beurtIndex + 1) % spelers.size();
        huidigeSpeler = spelers.get(beurtIndex);
        if((beurtIndex + 1) % spelers.size() == 0){
            aantalBeurten++;
        }
        System.out.println("Beurt " + aantalBeurten + " is nu aan " + huidigeSpeler.getGebruikersnaam());
    }

    public void speelBeurt(){
        System.out.println(huidigeSpeler.getGebruikersnaam()+ " begint zijn beurt.");

        dobbelsteen.werp();
        int worp = dobbelsteen.getAantalOgen();

        if (worp == 6 || huidigeSpeler.getAantalPionnenInSpel() >= 1) {         //Als de worp 6 is OF er is 1 pion op het veld: kies pion

            // kiesPion en verplaats
        }
        //zetPionOpVeld(kleur, pionID, worp) en verplaatsPion(kleur, pionID, stappen)

        //controleerOfPionEenSpelerSlaat() -> if(isBezet == true), andere pion die matcht met veldnummer moet terug naar start, isThuis op true, aantalPionnenOpVeld -1
        controleerOfSpelerGewonnenHeeft(huidigeSpeler); //Done
    }

    public void verplaatsPion(int pionId, int dobbelsteenWorp){ //Verplaatst de pion van kleur met id met 1 vakje
        Pion pion = huidigeSpeler.getPionnen(huidigeSpeler, pionId);
        bord.verplaatsPion(pion, dobbelsteenWorp);

        if(pion.getAantalVakjesVer() >= 56){
            pion.setGefinished(true);
        }
       /*bord.verplaatsPion(getSpelerAanBeurt().getPion(getSpelerAanBeurt(), pionId), dobbelsteenWorp); //Verplaatst de pion

        if(getSpelerAanBeurt().getPion(getSpelerAanBeurt(), pionId).getAantalVakjesVer() >= 56){ //Controleert of de pion het einde heeft gehaald
            getSpelerAanBeurt().getPion(getSpelerAanBeurt(),pionId).setGefinished(true); //Zet de pion op gefinished
            getSpelerAanBeurt().aantalPionnenInSpel -= 1; //Verlaagt de pionnen van de speler met 1
            getSpelerAanBeurt().aantalPionnenUitgespeeld += 1; //Verhoogt de uitgespeelde pionnen met 1
        }*/
    }

    /*public void zetPionOpVeld(Kleur kleur, int id){  //Zet de pion op het beginvakje van de juiste kleur, gekozen pion mag niet al op het veld of gefinished staan
        //zoekPion(getSpelerKleur(), id).plaatsOpStartpositie(rij, kolom);

        //met switch werken,
        // als het rood is vakje 0,
        // als het blauw is vakje 10,
        // als het geel is vakje 20,
        // als het groen is vakje 30
    }*/

    /*public void verwijderPion(Speler speler, Pion pion){
        //Verandert aantal pionnen op het veld met -1, pion moet naar thuisveld gestuurd worden
        speler.aantalPionnenInSpel -= 1;
        speler.aantalPionnenUitgespeeld += 1;
        pion.huidigVeldNummer = -1;
    }*/

    /*public void controleerOfPionEenSpelerSlaat(int id){ //Als het vakje bezet is, staat er een andere pion, kill die pion
        /*if(getVakNummer.isBezet == true){
            verwijderPion(getSpelerAanBeurt(), Pion pion);
        }
        //if(getSpelerAanBeurt().getPion().getAantalVakjesVer());
    }*/
    public boolean controleerOfSpelerGewonnenHeeft(Speler speler){
        if(speler.getAantalPionnenUitgespeeld() == 4){
            eindigSpel = true;
            eindigSpel(); //Roept methode eindigSpel op. Het spel wordt geëindigd
        }
        return eindigSpel;
    }

    public Pion kiesPion(int pionId){
       return huidigeSpeler.getPion(pionId);
    }

    public Kleur getSpelerKleur() {
        return huidigeSpeler.getKleur();
    }


    public Dobbelsteen getDobbelsteen() {
        return dobbelsteen;
    }

    public int getAantalBeurten() {
        return aantalBeurten;
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


    public void setDobbelsteen(Dobbelsteen dobbelsteen) {
        this.dobbelsteen = dobbelsteen;
    }

    public void setAantalBeurten(int aantalBeurten) {
        this.aantalBeurten = aantalBeurten;
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