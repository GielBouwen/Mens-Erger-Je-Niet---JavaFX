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
        this.bord = new Bord();  // Bord-object initialiseren
        this.spelers = new ArrayList<>();
        this.huidigeSpelerIndex = 0;  // Zet de index van de eerste speler
    }

    public void startSpel() {
        // Hier voeg je de spelers toe
        if (spelers.isEmpty()) {
            spelers.add(new Speler(Kleur.ROOD, 1, "Speler 1", false));
            spelers.add(new Speler(Kleur.GROEN, 2, "Speler 2", false));
        }
        System.out.println("Spelers zijn toegevoegd: " + spelers.size());  // Debugging output
    }

    // Haal de huidige speler op
    public Speler getHuidigeSpeler() {
        if (spelers == null || spelers.isEmpty()) {
            throw new IllegalStateException("Er zijn geen spelers beschikbaar.");
        }
        return spelers.get(0);  // Dit zou de eerste speler kunnen zijn
    }

    public void volgendeSpeler() {
        // Verander de index naar de volgende speler
        huidigeSpelerIndex = (huidigeSpelerIndex + 1) % spelers.size();  // Zorgt ervoor dat de index wordt herhaald na de laatste speler
    }


    public int gooiDobbelsteen() {
        dobbelsteen.werp();
        return dobbelsteen.getAantalOgen();
    }

    public Bord getBord() {
        return bord;  // Retourneer het bord-object
    }

    public List<Speler> getSpelers() {
        return spelers;  // Retourneer de lijst van spelers
    }

    // Laad het spel vanuit een bestand
    public void load(String filePath) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            // Laad het spelobject uit het bestand
            Spel geladenSpel = (Spel) ois.readObject();

            // Herstel de status van het spel
            this.spelers = geladenSpel.getSpelers();
            this.bord = geladenSpel.getBord();  // Bord ophalen
            this.huidigeSpelerIndex = 0;  // Start de index van de speler weer op 0 (eerste speler)

            System.out.println("Spel succesvol geladen vanuit " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception("Fout bij het laden van het spel: " + e.getMessage());
        }
    }

    public void verplaatsPion(Pion pion, int dobbelsteenWorp, int extraPositie) {
        int huidigePositie = pion.getVeldNummer();
        int nieuwePositie = berekenNieuwePositie(pion, dobbelsteenWorp, extraPositie);

        pion.setAantalVakjesVer(pion.getAantalVakjesVer() + dobbelsteenWorp);  // Update aantal vakjes verplaatst

        // Update de positie van de pion op het bord
        bord.updatePionPosition(pion, nieuwePositie);

        // Trigger de visuele update in de view (pas aan op basis van de implementatie van de view)
        System.out.println("Pion " + pion.getKleur() + " van " + pion.getEigenaar().getGebruikersnaam() + " is nu op veld " + nieuwePositie);
    }

    public int berekenNieuwePositie(Pion pion, int dobbelsteenWorp, int extraPositie) {
        // Logica om de nieuwe positie te berekenen
        int huidigePositie = pion.getVeldNummer();
        return huidigePositie + dobbelsteenWorp + extraPositie;  // Voeg extraPositie toe aan de nieuwe positie
    }

}