package be.kdg.mens_erger_je_niet.model;

import java.util.List;
import java.util.ArrayList;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;

public class Spel {
    private int beurtIndex; //houdt bij wie er aan de beurt is.
    private Dobbelsteen dobbelsteen;
    private int aantalBeurten = 1;
    private Speler huidigeSpeler;
    private List<Speler> spelers = new ArrayList<>();
    private NewGameView newGameView;
    private boolean eindigSpel = false;
    private Bord bord;

    public Spel(NewGameView newGameView) {
        this.newGameView = newGameView; //voor namen te krijgen van de view
    }

    public void maakSpelersAan() {
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
        return bord;
    }


    public void setSpelerTeller(int spelerTeller) {
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

        if (worp == 6 || huidigeSpeler.getAantalPionnenInSpel() >= 1) {
        }
        controleerOfSpelerGewonnenHeeft(huidigeSpeler); //Done
    }

    public void verplaatsPion(int pionId, int dobbelsteenWorp) {
        Pion pion = huidigeSpeler.getPionnen().get(pionId);
        bord.verplaatsPion(pion, dobbelsteenWorp);

        if (pion.getAantalVakjesVer() >= 56) {
            pion.setGefinished(true);
        }
    }



    public boolean controleerOfSpelerGewonnenHeeft(Speler speler) {
        if (speler.getAantalPionnenUitgespeeld() == 4) {
            eindigSpel = true;
            eindigSpel(); //--> spel eindigen
        }
        return eindigSpel;
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


    public void setAantalBeurten(int aantalBeurten) {
        this.aantalBeurten = aantalBeurten;
    }

    public void setSpelers(List<Speler> spelers) {
        this.spelers = spelers;
    }


}