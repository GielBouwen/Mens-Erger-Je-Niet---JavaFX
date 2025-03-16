package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MensErgerJeNietControler {
    private Spel spel;
    private Dobbelsteen dobbelsteen;
    private Bord bord;
    private List<Speler> spelers;
    private int huidigeSpelerIndex;

    public MensErgerJeNietControler() {
        this.dobbelsteen = new Dobbelsteen();
        this.bord = new Bord();
        this.spelers = new ArrayList<>();
        this.huidigeSpelerIndex = 0;
    }

    public void startSpel() {
        if (spelers.isEmpty()) {
            spelers.add(new Speler(Kleur.ROOD, 1, "Speler 1", false));
            spelers.add(new Speler(Kleur.GROEN, 2, "Speler 2", false));
        }
        System.out.println("Spelers zijn toegevoegd: " + spelers.size());
    }


    public Speler getHuidigeSpeler() {
        if (spelers == null || spelers.isEmpty()) {
            throw new IllegalStateException("Er zijn geen spelers beschikbaar.");
        }
        return spelers.get(0);
    }

    public void volgendeSpeler() {
        huidigeSpelerIndex = (huidigeSpelerIndex + 1) % spelers.size();
    }


    public int gooiDobbelsteen() {
        dobbelsteen.werp();
        return dobbelsteen.getAantalOgen();
    }

    public Bord getBord() {
        return bord;
    }

    public List<Speler> getSpelers() {
        return spelers;
    }


    public void load(String filePath) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Spel geladenSpel = (Spel) ois.readObject();

            this.spelers = geladenSpel.getSpelers();
            this.bord = geladenSpel.getBord();
            this.huidigeSpelerIndex = 0;

            System.out.println("Spel succesvol geladen vanuit " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception("Fout bij het laden van het spel: " + e.getMessage());
        }
    }

   /*  public void loadGame(String filePath) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Spel geladenSpel = (Spel) ois.readObject();
            this.spel = geladenSpel;
            updateView();

            System.out.println("Spel succesvol geladen vanuit " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception("Fout bij het laden van het spel: " + e.getMessage());
        }
    }
    */

    public void verplaatsPion(Pion pion, int dobbelsteenWorp, int extraPositie) {
        int huidigePositie = pion.getVeldNummer();
        int nieuwePositie = berekenNieuwePositie(pion, dobbelsteenWorp, extraPositie);
        pion.setAantalVakjesVer(pion.getAantalVakjesVer() + dobbelsteenWorp);
        bord.updatePionPosition(pion, nieuwePositie);
        System.out.println("Pion " + pion.getKleur() + " van " + pion.getEigenaar().getGebruikersnaam() + " is nu op veld " + nieuwePositie);
    }

    public int berekenNieuwePositie(Pion pion, int dobbelsteenWorp, int extraPositie) {
        int huidigePositie = pion.getVeldNummer();
        return huidigePositie + dobbelsteenWorp + extraPositie;
    }

}