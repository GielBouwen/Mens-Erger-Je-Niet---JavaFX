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
        if (newGameView.getVulNaamGroenIn() != null) {
            index++;
            spelers.add(new Speler(Kleur.GROEN, index, newGameView.getVulNaamGroenIn().getText(), newGameView.getCheckBoxGroen().isSelected()));
        }
        if (newGameView.getVulNaamGeelIn() != null) {
            index++;
            spelers.add(new Speler(Kleur.GEEL, index, newGameView.getVulNaamGeelIn().getText(), newGameView.getCheckBoxGeel().isSelected()));
        }
        if (newGameView.getVulNaamBlauwIn() != null) {
            index++;
            spelers.add(new Speler(Kleur.BLAUW, index, newGameView.getVulNaamBlauwIn().getText(), newGameView.getCheckBoxBlauw().isSelected()));
        }
        if (newGameView.getVulNaamRoodIn() != null) {
            index++;
            spelers.add(new Speler(Kleur.ROOD, index, newGameView.getVulNaamRoodIn().getText(), newGameView.getCheckBoxRood().isSelected()));
        }
        huidigeSpeler = spelers.get(beurtIndex);
        if (index <= 1) {
            throw new IllegalArgumentException("Vul de velden in voor minstens 2 kleuren");
        }
    }

    public Bord getBord() {
        return bord;  // Dit moet een Bord-object retourneren
    }


    public void pauzeerSpel(boolean pauzeerSpel) {
        if (pauzeerSpel) {
            //Game wordt opgeslagen (er wordt als het ware een soort van snapshot gemaakt) en vervolgens gesloten. Je kan het na het sluiten terug herstarten.
        }
    }

    public void setSpelerTeller(int spelerTeller) {
        // Mogelijke implementatie:
        // spelerTeller kan bijvoorbeeld het aantal spelers voorstellen.
        if (spelerTeller >= 0) {
            this.spelers = new ArrayList<>(spelerTeller);
        }
    }


    public void startSpel() {
        bord = new Bord();
        maakSpelersAan();
        zetPionnenOpParkeerplaats();
        while (!eindigSpel) {
            speelBeurt();
            veranderBeurt();
        }
    }

    private void zetPionnenOpParkeerplaats() {
        for (int i = 0; i < 4; i++) {
            bord.getParkeerVeldRood(i).setPionAlInVeld(getSpeler(getSpelerIdDoorKleur(Kleur.ROOD)).getPion(i));
            bord.getParkeerVeldGroen(i).setPionAlInVeld(getSpeler(getSpelerIdDoorKleur(Kleur.GROEN)).getPion(i));
            bord.getParkeerVeldGeel(i).setPionAlInVeld(getSpeler(getSpelerIdDoorKleur(Kleur.GEEL)).getPion(i));
            bord.getParkeerVeldBlauw(i).setPionAlInVeld(getSpeler(getSpelerIdDoorKleur(Kleur.BLAUW)).getPion(i));
        }
    }


    public void eindigSpel() {
        eindigSpel = true;
    }

    public void veranderBeurt() {
        beurtIndex = (beurtIndex + 1) % spelers.size();
        huidigeSpeler = spelers.get(beurtIndex);
        if ((beurtIndex + 1) % spelers.size() == 0) {
            aantalBeurten++;
        }
        System.out.println("Beurt " + aantalBeurten + " is nu aan " + huidigeSpeler.getGebruikersnaam());
    }

    public void speelBeurt() {
        System.out.println(huidigeSpeler.getGebruikersnaam() + " begint zijn beurt.");

        dobbelsteen.werp();
        int worp = dobbelsteen.getAantalOgen();

        if (worp == 6 || huidigeSpeler.getAantalPionnenInSpel() >= 1) {         //Als de worp 6 is OF er is 1 pion op het veld: kies pion

            // kiesPion en verplaats
        }
        //zetPionOpVeld(kleur, pionID, worp) en verplaatsPion(kleur, pionID, stappen)

        //controleerOfPionEenSpelerSlaat() -> if(isBezet == true), andere pion die matcht met veldnummer moet terug naar start, isThuis op true, aantalPionnenOpVeld -1
        controleerOfSpelerGewonnenHeeft(huidigeSpeler); //Done
    }

    public void verplaatsPion(int pionId, int dobbelsteenWorp) {
        Pion pion = huidigeSpeler.getPionnen().get(pionId);
        bord.verplaatsPion(pion, dobbelsteenWorp);

        if (pion.getAantalVakjesVer() >= 56) {
            pion.setGefinished(true);
        }
    }


    public int getSpelerTeller() {
        return spelers.size(); // Of een andere manier om de speler teller te bepalen
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
    public boolean controleerOfSpelerGewonnenHeeft(Speler speler) {
        if (speler.getAantalPionnenUitgespeeld() == 4) {
            eindigSpel = true;
            eindigSpel(); //Roept methode eindigSpel op. Het spel wordt geÃ«indigd
        }
        return eindigSpel;
    }

    public Pion kiesPion(int pionId) {
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

    public Speler getSpeler(int index) {
        return spelers.get(index);
    }

    public int getSpelerIdDoorKleur(Kleur kleur) {
        for (Speler speler : spelers) {
            if (speler.getKleur().equals(kleur)) {
                return speler.getSpelerId();
            }
        }
        throw new IllegalArgumentException("Geen speler gevonden met kleur: " + kleur);
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