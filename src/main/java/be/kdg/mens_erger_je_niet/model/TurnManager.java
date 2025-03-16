package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.view.playboard.PlayboardView;

public class TurnManager {
    private int huidigeSpelerIndex;   // Houdt bij wie de huidige speler is
    private final String[] spelers;   // Een lijst van speler namen (of kleuren, afhankelijk van je implementatie)
    private final PlayboardView playboardView;

    // Constructor
    public TurnManager(PlayboardView playboardView) {
        this.playboardView = playboardView;
        this.spelers = new String[]{"Speler 1", "Speler 2", "Speler 3", "Speler 4"}; // Voorbeeld, kan ook de kleur van de pion zijn
        this.huidigeSpelerIndex = 0; // Start bij de eerste speler
        this.playboardView.updateSpelerTurnLabel(spelers[huidigeSpelerIndex]);
    }

    // Geef de naam van de huidige speler
    public String getHuidigeSpeler() {
        return spelers[huidigeSpelerIndex];
    }

    // Wissel van beurt naar de volgende speler
    public void volgendeBeurt() {
        huidigeSpelerIndex = (huidigeSpelerIndex + 1) % spelers.length; // Wisselt tussen 0-3 voor 4 spelers
        playboardView.updateSpelerTurnLabel(spelers[huidigeSpelerIndex]);
    }

    // Zet de beurt naar een specifieke speler
    public void setBeurt(int spelerIndex) {
        if (spelerIndex >= 0 && spelerIndex < spelers.length) {
            huidigeSpelerIndex = spelerIndex;
            playboardView.updateSpelerTurnLabel(spelers[huidigeSpelerIndex]);
        }
    }
}