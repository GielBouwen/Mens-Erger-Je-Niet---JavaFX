package be.kdg.mens_erger_je_niet;

import javafx.scene.paint.Color;

public enum Kleur {
    ROOD(Color.RED),
    GEEL(Color.YELLOW),
    BLAUW(Color.BLUE),
    GROEN(Color.GREEN);

    private Color kleur;

    Kleur(Color kleur) {
        this.kleur = kleur;
    }
}

