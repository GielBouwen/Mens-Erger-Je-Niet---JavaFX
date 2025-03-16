package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.view.playboard.PlayboardView;

public class TurnManager {
    private int huidigeSpelerIndex;
    private final String[] spelers;
    private final PlayboardView playboardView;

    public TurnManager(PlayboardView playboardView) {
        this.playboardView = playboardView;
        this.spelers = new String[]{"Speler 1", "Speler 2", "Speler 3", "Speler 4"};
        this.huidigeSpelerIndex = 0;
        this.playboardView.updateSpelerTurnLabel(spelers[huidigeSpelerIndex]);
    }

    public String getHuidigeSpeler() {
        return spelers[huidigeSpelerIndex];
    }

    public void volgendeBeurt() {
        huidigeSpelerIndex = (huidigeSpelerIndex + 1) % spelers.length; // Wisselt tussen 0-3 voor 4 spelers
        playboardView.updateSpelerTurnLabel(spelers[huidigeSpelerIndex]);
    }

    public void setBeurt(int spelerIndex) {
        if (spelerIndex >= 0 && spelerIndex < spelers.length) {
            huidigeSpelerIndex = spelerIndex;
            playboardView.updateSpelerTurnLabel(spelers[huidigeSpelerIndex]);
        }
    }
}